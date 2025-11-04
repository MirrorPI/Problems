import java.io.*;
import java.util.*;

public class Main {

    static int I; //4~300
    static boolean[][] map;
    static int[] start;
    static int[] end;
    static ArrayDeque<int[]> q;
    final static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    final static int[] dy = {1, -1, -2, -2, -1, 1, 2, 2};

    public static void main (String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            I = Integer.parseInt(br.readLine());
            map = new boolean[I][I];
            start = new int[2];
            end = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            q = new ArrayDeque<>();
            q.add(new int[] {start[0], start[1], 0});
            map[start[0]][start[1]] = true;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int d = cur[2];

                if(x == end[0] && y == end[1]) {
                    sb.append(d).append("\n");
                    break;
                }

                for(int i=0; i<8; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx<0 || nx>=I || ny<0 || ny>=I || map[nx][ny]) continue;

                    q.add(new int[] {nx, ny, d+1});
                    map[nx][ny] = true;
                }
            }
        }
        System.out.print(sb);
    }
}