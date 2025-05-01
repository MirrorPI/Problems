import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //지도 사이즈(1~1000)
    static int[][] map; //0: 갈 수 없음, 1: 갈 수 있음, 2: 도착지점.
    static int[][] ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ans = new int[N][M]; for(int i=0; i<N; i++) Arrays.fill(ans[i], -1);
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    q.add(new int[] {i, j});
                    ans[i][j] = 0;
                } else if(map[i][j] == 0){
                    ans[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] == 1 && ans[nx][ny] == -1){
                    ans[nx][ny] = ans[x][y] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}