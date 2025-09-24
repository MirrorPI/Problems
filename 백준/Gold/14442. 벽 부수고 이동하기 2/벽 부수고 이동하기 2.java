import java.io.*;
import java.util.*;

public class Main {

    final static int[] dx = {-1, 1, 0, 0 };
    final static int[] dy = {0, 0, -1, 1};
    final static int max = 1_000_001;
    static int N; //세로 (1~1000)
    static int M; //가로 (1~1000)
    static int[][] map;
    static int K; //벽을 부수는 최대횟수(1~10)
    static int[][][] moveNum; //k, x, y -> x, y 점에 k 개를 부수고 왔을 때 이동 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        moveNum = new int[K+1][N+1][M+1];
        for(int i=1; i<=N; i++){
            String input = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = input.charAt(j-1) - '0';
            }
        }
        int ans = max;
        move();
        for(int i=0; i<=K; i++){
            if(moveNum[i][N][M] == 0){
                continue;
            }
            ans = Math.min(ans, moveNum[i][N][M]);
        }
        if(ans == max){
            ans = -1;
        }
        System.out.print(ans);
        br.close();
    }
    public static void move(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 1, 1});
        moveNum[0][1][1] = 1;
        while(!q.isEmpty()){
            int[] here = q.poll();
            int k = here[0];
            int x = here[1];
            int y = here[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=1 && nx<=N && ny>=1 && ny<=M) {
                    if(map[nx][ny] == 1){
                        if(k == K) continue;
                        if(moveNum[k+1][nx][ny] == 0){
                            q.add(new int[] {k+1, nx, ny});
                            moveNum[k+1][nx][ny] = moveNum[k][x][y] + 1;
                        }
                    } else {
                        if(moveNum[k][nx][ny] == 0){
                            q.add(new int[] {k, nx, ny});
                            moveNum[k][nx][ny] = moveNum[k][x][y] + 1;
                        }
                    }
                }
            }
        }
    }
}