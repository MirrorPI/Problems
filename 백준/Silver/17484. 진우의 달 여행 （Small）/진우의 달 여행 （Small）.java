import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //가로, 세로(2~6)
    static int[][] map; //1~100
    static int[][][] dp;
    final static int INF = 3600;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                for(int d=0; d<3; d++){
                    if(r==0) {
                        dp[0][c][d] = map[0][c];
                    } else {
                        dp[r][c][d] = INF;
                    }
                }
            }
        }

        //d : 0 왼쪽 아래 방향으로 지금 위치 도달
        //d : 1 바로 아래 방향으로 지금 위치 도달
        //d : 2 오른쪽 아래 방향으로 지금 위치 도달.
        for(int r=1; r<N; r++){
            for(int c=0; c<M; c++){
                if(c==0) {
                    dp[r][0][0] = Math.min(dp[r][0][0],
                            Math.min(dp[r-1][1][1], dp[r-1][1][2]) + map[r][0]);
                    dp[r][0][1] = Math.min(dp[r][0][1],
                            Math.min(dp[r-1][0][0], dp[r-1][0][2]) + map[r][0]);
                } else if(c==M-1){
                    dp[r][M-1][1] = Math.min(dp[r][M-1][1],
                            Math.min(dp[r-1][M-1][0], dp[r-1][M-1][2]) + map[r][M-1]);
                    dp[r][M-1][2] = Math.min(dp[r][M-1][2],
                            Math.min(dp[r-1][M-2][0], dp[r-1][M-2][1]) + map[r][M-1]);
                } else {
                    dp[r][c][0] = Math.min(dp[r][c][0],
                            Math.min(dp[r-1][c+1][1], dp[r-1][c+1][2]) + map[r][c]);
                    dp[r][c][1] = Math.min(dp[r][c][1],
                            Math.min(dp[r-1][c][0], dp[r-1][c][2]) + map[r][c]);
                    dp[r][c][2] = Math.min(dp[r][c][2],
                            Math.min(dp[r-1][c-1][0], dp[r-1][c-1][1]) + map[r][c]);
                }
            }
        }
        int min = INF;
        for(int d=0; d<3; d++){
            for(int c=0; c<M; c++){
                int temp = dp[N-1][c][d];
                if(temp == INF || temp == 0) continue;
                min = Math.min(min, temp);
            }
        }
        System.out.print(min);
    }
}