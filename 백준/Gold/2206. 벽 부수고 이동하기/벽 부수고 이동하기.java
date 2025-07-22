import java.io.*;
import java.util.*;

public class Main {

    static int N; //세로 (1~1,000)
    static int M; //가로 (1~1,000)
    static int[][] map; //(0 : 이동가능, 1 : 벽), (시작점, 끝점 0 고정)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] moveAndBreak; //x,y,0 벽을 부수지 않고 x,y까지 움직인 횟수, x,y,1 벽을 부수고 x,y까지 움직인 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        moveAndBreak = new int[N+1][M+1][2];
        for(int i=1; i<=N; i++){
            String input = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = input.charAt(j-1) - '0';
            }
        }
        move();
        int ans = -1;
        int justMove = moveAndBreak[N][M][0];
        int breakMove = moveAndBreak[N][M][1];
        if(justMove == 0){
            if(breakMove != 0){
                ans = breakMove;
            }
        } else {
            if(breakMove == 0){
                ans = justMove;
            } else {
                ans = Math.min(justMove, breakMove);
            }
        }
        System.out.print(ans);
        br.close();
    }
    public static void move(){
        ArrayDeque<int[]> q = new ArrayDeque<>(); //x, y , (x,y)까지 도달했을 때 한번이라도 부쉈으면 1 , 아니면 0
        q.add(new int[] {1, 1, 0});
        moveAndBreak[1][1][0] = 1;
        moveAndBreak[1][1][1] = 1;
        while(!q.isEmpty()){
            int[] here = q.poll();
            int x = here[0];
            int y = here[1];
            int hereBreak = here[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=1 && nx<=N && ny>=1 && ny<=M){
                    if(hereBreak == 0){
                        if(map[nx][ny] == 1){
                            if(moveAndBreak[nx][ny][1] == 0){
                                moveAndBreak[nx][ny][1] = moveAndBreak[x][y][0] + 1;
                                q.add(new int[]{nx, ny, 1});
                            }
                        } else {
                            if(moveAndBreak[nx][ny][0] == 0){
                                moveAndBreak[nx][ny][0] = moveAndBreak[x][y][0] + 1;
                                q.add(new int[] {nx, ny, 0});
                            }
                        }
                    } else {
                        if(map[nx][ny] == 0){
                            if(moveAndBreak[nx][ny][1] == 0){
                                moveAndBreak[nx][ny][1] = moveAndBreak[x][y][1] + 1;
                                q.add(new int[] {nx, ny, 1});
                            }
                        }
                    }
                }
            }
        }
    }
}