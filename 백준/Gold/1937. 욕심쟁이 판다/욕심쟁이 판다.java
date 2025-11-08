import java.io.*;
import java.util.*;

public class Main {

    static int N; //대나무 숲의 길이 (1~500)
    static int[][] map; //(1~1,000,000)
    static List<int[]> datas;
    static int[][] dp;
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        datas = new ArrayList<>();
        dp = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                datas.add(new int[] {map[i][j], i, j});
            }
        }
        datas.sort((d1, d2) -> {
            return Integer.compare(d1[0], d2[0]);
        });
        for(int i=0; i<N; i++) {
            Arrays.fill(dp[i], 1);
        }
        for(int[] data : datas) {
            int bamboo = data[0];
            int x = data[1];
            int y = data[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(map[nx][ny] > bamboo) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                    ans = Math.max(ans, dp[nx][ny]);
                }
            }
        }
        System.out.print(ans);
    }
}