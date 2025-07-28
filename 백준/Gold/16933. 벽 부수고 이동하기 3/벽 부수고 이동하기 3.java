import java.io.*;
import java.util.*;

public class Main {

    static final int max = 1_000_001;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int N; //세로(1~1000)
    static int M; //가로(1~1000)
    static int K; //최대로 부술 수 있는 벽의 개수(1~10)
    static int[][]map;
    static int[][][][] moves; //낮밤, 벽을 부순 개수, (x, y)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        moves = new int[2][K+1][N+1][M+1];
        for(int i=1; i<=N; i++){
            String input = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = input.charAt(j-1) - '0';
            }
        }
        move();
        int ans = max;
        for(int i = 0; i<2; i++){
            for(int j=0; j<=K; j++){
                if(moves[i][j][N][M] == 0) continue;

                ans = Math.min(ans, moves[i][j][N][M]);
            }
        }
        if(ans == max) {
            ans = -1;
        }
        System.out.print(ans);
        br.close();
    }
    public static void move(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1, 1});
        moves[0][0][1][1] = 1;
        while(!q.isEmpty()){
            int[] here = q.poll();
            int day = here[0];
            int brk = here[1];
            int x = here[2];
            int y = here[3];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=1 && nx<=N && ny>=1 && ny<=M){
                    if(day == 0){ //낮
                        if(map[nx][ny] == 1) { //벽
                            if(brk == K) continue;
                            if(moves[1][brk+1][nx][ny] == 0){
                                q.add(new int[]{1, brk+1, nx, ny});
                                moves[1][brk+1][nx][ny] = moves[0][brk][x][y] + 1;
                            }
                        } else { //길
                            if(moves[1][brk][nx][ny] == 0){
                                q.add(new int[]{1, brk, nx, ny});
                                moves[1][brk][nx][ny] = moves[0][brk][x][y] + 1;
                            }
                        }
                    } else { //밤
                        if(map[nx][ny] == 1){
                            if(moves[0][brk][x][y] == 0){
                                q.add(new int[] {0, brk, x, y});
                                moves[0][brk][x][y] = moves[1][brk][x][y] + 1;
                            }
                        } else {
                            if(moves[0][brk][nx][ny] == 0){
                                q.add(new int[] {0, brk, nx, ny});
                                moves[0][brk][nx][ny] = moves[1][brk][x][y] + 1;
                            }
                        }
                    }
                }
            }
        }
    }
}