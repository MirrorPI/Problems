import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H; //상자의 사이즈(2~100), 높이(1~100)
    static int[][][] box; //상자의 상태 1: 익은 토마토, -1 : 빈 공간, 0: 익지 않은 토마토
    static int[][][] days;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int tomato;
    static Queue<int[]> q = new ArrayDeque<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        days = new int[H][N][M];
        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                Arrays.fill(days[h][i], -1);
            }
        }
        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    box[h][i][j] = Integer.parseInt(st.nextToken());
                    if(box[h][i][j] == 1){
                        q.add(new int[]{h, i, j});
                        tomato += 1;
                        days[h][i][j] = 0;
                    } else if(box[h][i][j] ==  0){
                        tomato += 1;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int h = cur[0];
            int x = cur[1];
            int y = cur[2];
            tomato -= 1;
            for(int i=0; i<6; i++){
                int nh = h + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nh>=0 && nh<H && nx>=0 && nx<N && ny>=0 && ny<M && box[nh][nx][ny] == 0 && days[nh][nx][ny] == -1){
                    q.add(new int[] {nh, nx, ny});
                    days[nh][nx][ny] = days[h][x][y] + 1;
                    ans = Math.max(ans, days[nh][nx][ny]);
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