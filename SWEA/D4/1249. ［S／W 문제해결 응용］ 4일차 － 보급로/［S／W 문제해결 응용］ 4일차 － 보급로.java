import java.util.*;
import java.io.*;

public class Solution {

    static int N; //맵의 크기(1~100)
    static int[][] map; //지도(깊이 0~)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] minTime; //i, j 점까지의 최소 복구 시간
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            minTime = new int[N][N];
            for (int i = 0; i < N; i++) Arrays.fill(minTime[i], INF);
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
                return Integer.compare(p1[2], p2[2]);
            });
            pq.add(new int[]{0, 0, 0});
            minTime[0][0] = 0;
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int x = cur[0];
                int y = cur[1];
                int t = cur[2];

                if (minTime[x][y] < t) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || minTime[nx][ny] <= t + map[nx][ny]) continue;

                    minTime[nx][ny] = t + map[nx][ny];
                    pq.add(new int[]{nx, ny, minTime[nx][ny]});
                }
            }
            sb.append("#").append(testCase).append(" ").append(minTime[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}