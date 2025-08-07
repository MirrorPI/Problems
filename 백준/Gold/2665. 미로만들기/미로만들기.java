import java.io.*;
import java.util.*;

public class Main {

    static int n; //한 줄의 방의 개수(1~50)
    static int[][] map; //1 : 흰방, 0 : 벽
    static int[][] min;
    final static int MAX = 2555;
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        min = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(min[i], MAX);
        }
        for(int i=1; i<=n; i++){
            String input = br.readLine();
            for(int j=1; j<=n; j++){
                map[i][j] = input.charAt(j-1) - '0';
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) ->{
           return Integer.compare(p1[1], p2[1]);
        });
        pq.add(new int[] {1, 1, 0});
        min[1][1] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int curW = cur[2];
            if(curW > min[x][y]) continue;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=1 && nx<=n && ny>=1 && ny<=n){
                    int w = 0;
                    if(map[nx][ny] == 0){
                        w = 1;
                    }
                    if(curW + w >= min[nx][ny]) continue;

                    min[nx][ny] = curW + w;
                    pq.add(new int[] {nx, ny, curW + w});
                }
            }
        }
        System.out.print(min[n][n]);
    }
}