import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //지도 사이즈(1~3000)
    static int[][] map; // 지도 상황 1: 벽, 0: 갈 수 있는 곳
    static int[][] min;
    static List<int[]> start = new ArrayList<>();
    static final int max = 3000 * 3000;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int ans = max;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        min = new int[N][M]; for(int i=0; i<N; i++) Arrays.fill(min[i], max);

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map[0][0] = -1;
        map[N-1][M-1] = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            return Long.compare(p1[2], p2[2]);
        });
        for(int i=1; i<M; i++) { //위쪽 면에서 시작하는 벽 찾기
            if(map[0][i] == 1) {
                min[0][i] = 0;
                pq.add(new int[] {0, i, 0});
            } else {
                min[0][i] = 1;
                pq.add(new int[] {0, i, 1});
            }

        }
        for(int i=1; i<N-1; i++) { //오른쪽 면에서 시작하는 벽 찾기
            if(map[i][M-1] == 1) {
                min[i][M-1] = 0;
                pq.add(new int[] {i, M-1, 0});
            } else {
                min[i][M-1] = 1;
                pq.add(new int[] {i, M-1, 1});
            }
        }
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];

            if(min[x][y] < cur[2] || map[x][y] < 0) continue;

            for(int i=0; i<8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M) {
                    if(map[nx][ny] == 0) {
                        if(min[nx][ny] <= min[x][y] + 1) continue;

                        min[nx][ny] = min[x][y] + 1;
                        pq.add(new int[] {nx, ny, min[nx][ny]});
                    } else if (map[nx][ny] == 1) {
                        if(min[nx][ny] <= min[x][y]) continue;

                        min[nx][ny] = min[x][y];
                        pq.add(new int[] {nx, ny, min[nx][ny]});
                    }
                }
            }
        }
        for(int i=1; i<N; i++) {
            ans = Math.min(ans, min[i][0]);
        }
        for(int i=0; i<M-1; i++) {
            ans = Math.min(ans, min[N-1][i]);
        }
        System.out.print(ans);
    }
}