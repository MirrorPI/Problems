import java.io.*;
import java.util.*;

public class Main {

    static int w, h; //가로, 세로 (1~50)
    static int[][] map; //1 : land, 0 : sea
    static boolean[][] visited;
    final static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    final static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0) break;

            map = new int [w][h];
            visited = new boolean[w][h];
            count = 0;
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    int data = Integer.parseInt(st.nextToken());
                    map[j][i] = data;
                }
            }
            for(int i=0; i<w; i++){
                for(int j=0; j<h; j++){
                    if(visited[i][j] || map[i][j] == 0) continue;

                    checkLand(i, j);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
    public static void checkLand(int x, int y){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i=0; i<8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx>=w || nx<0 || ny>=h || ny<0 || visited[nx][ny] || map[nx][ny] == 0) continue;

                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
        count++;
    }
}