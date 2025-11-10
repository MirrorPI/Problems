import java.io.*;
import java.util.*;

public class Main {

    static int M, N; //세로, 가로(1~500)
    static int[][] map;
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    static int[][] dp;
    static List<int[]> datas;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        datas = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                datas.add(new int[] {map[i][j], i, j});
            }
        }
        datas.sort((d1, d2) -> {
            return Integer.compare(d2[0], d1[0]);
        });
        dp[0][0] = 1;

        for(int[] data : datas){
            int h = data[0];

            if(h > map[0][0]) continue;

            int x = data[1];
            int y = data[2];
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;

                if(map[nx][ny] < h) {
                    dp[nx][ny] += dp[x][y];
                }
            }
        }

        System.out.print(dp[M-1][N-1]);
    }
}