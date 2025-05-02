import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] box;
    static int[][] days;
    static int tomato;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        days = new int[N][M]; for(int i=0; i<N; i++) Arrays.fill(days[i], -1);
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    q.add(new int[] {i, j});
                    days[i][j] = 0;
                    tomato += 1;
                } else if (box[i][j] == 0){
                    tomato += 1;
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            tomato -= 1;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && box[nx][ny] == 0 && days[nx][ny] == -1){
                    q.add(new int[] {nx, ny});
                    days[nx][ny] = days[x][y] + 1;
                    ans = Math.max(ans, days[nx][ny]);
                }
            }
        }
        if(tomato != 0){
            ans = -1;
        }
        System.out.print(ans);
        br.close();
    }
}