import java.util.*;
import java.io.*;

public class Main {

    static int N; //동굴의 크기(2~125)
    static int[][] map; //밟으면 루피 잃음(0~9) -> 가장 적게 읽는 루피
    static int[][] min;
    static int max = 22222;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = 0;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            t += 1;
            map = new int[N][N];
            min = new int[N][N];
            for(int i=0; i<N; i++) Arrays.fill(min[i], max);
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2)->{
                return Integer.compare(p1[2], p2[2]);
            });
            pq.add(new int[] {0, 0, map[0][0]});
            min[0][0] = map[0][0];
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                if(min[cur[0]][cur[1]] < cur[2]) continue;

                for(int i=0; i<4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || min[nx][ny] <= cur[2] + map[nx][ny]) continue;

                    min[nx][ny] = cur[2] + map[nx][ny];
                    pq.add(new int[] {nx, ny, min[nx][ny]});
                }
            }
            sb.append("Problem").append(" ").append(t).append(": ").append(min[N-1][N-1]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}