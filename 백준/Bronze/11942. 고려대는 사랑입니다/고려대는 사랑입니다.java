import java.io.*;
import java.util.*;

public class Main {

    static int N; //세로 (1~1,000)
    static int M; //가로 (1~1,000)
    static int[][] map; //(0 : 이동가능, 1 : 벽), (시작점, 끝점 0 고정)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] moveNum;

    public static void main(String[] args) throws IOException {
        System.out.print("고려대학교");
    }
    public static void move(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {1, 1, 0});
        moveNum[1][1] = 1;
        while(!q.isEmpty()){
            int[] here = q.poll();
            int x = here[0];
            int y = here[1];
            int breakNum = here[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=1 && nx<=N && ny>=1 && ny<=M && breakNum < 2){
                    if(map[nx][ny] == 1){
                        breakNum += 1;
                    }
                    moveNum[nx][ny] = moveNum[x][y] + 1;
                    q.add(new int[] {nx, ny, breakNum});
                }
            }
        }
    }
}