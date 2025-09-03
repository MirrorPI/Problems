import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int M; //밭의 가로(1~50)
    static int N; //밭의 세로(1~50)
    static int K; //배추의 개수(1~2500)
    static boolean[][] cabbage;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans;

    public static void countWorms(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<M && ny>=0 && ny<N && cabbage[nx][ny] && !visited[nx][ny]){
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        ans += 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            ans = 0;
            cabbage = new boolean[50][50];
            visited = new boolean[50][50];
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[x][y] = true;
            }

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(cabbage[i][j] && !visited[i][j]){
                        countWorms(i, j);
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}