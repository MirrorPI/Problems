import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //세로 가로 (1~100)
    static int[][] map; //0: 빈방, 1: 벽
    static int[][] min; //x, y 까지의 최소 거리
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final int MAX = 10_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        min = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String input = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = input.charAt(j-1) - '0';
            }
        }
        for(int i=1; i<=N; i++){
            Arrays.fill(min[i], MAX);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
           return Integer.compare(p1[2], p2[2]);
        });
        pq.add(new int[] {1, 1, 0});
        min[1][1] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            if(min[x][y] < d) continue;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=1 && nx<=N && ny>=1 && ny<=M){
                    if(map[nx][ny] == 1){
                        if(min[nx][ny] <= d + 1) continue;
                        min[nx][ny] = d + 1;
                        pq.add(new int[] {nx, ny, min[nx][ny]});
                    } else {
                        if(min[nx][ny] <= d) continue;
                        min[nx][ny] = d;
                        pq.add(new int[] {nx, ny, min[nx][ny]});
                    }
                }
            }
        }
        System.out.print(min[N][M]);
    }
}