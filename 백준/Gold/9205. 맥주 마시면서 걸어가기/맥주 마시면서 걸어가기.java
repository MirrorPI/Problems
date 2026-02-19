import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int n; //맥주를 파는 편의점의 개수(0~100)
    static Point home;
    static Point[] spot;
    static boolean[] visited;
    public static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        solve();
    }
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(6 * T);
        for(int t=1; t<=T; t++){
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            home = new Point(x, y);

            spot = new Point[n+1]; //0~n-1 : 편의점, n : 축제
            visited = new boolean[n+1];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                spot[i] = new Point(x, y);
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            spot[n] = new Point(x, y);

            bfs();
            sb.append(visited[n] ? "happy\n" : "sad\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(home);
        while(!q.isEmpty()){
            Point curr = q.poll();
            for(int i=0; i<=n; i++){
                if(visited[i]) continue;

                Point next = spot[i];

                if(calculateManhattanDistance(curr, next) > 1000) continue;

                q.add(spot[i]);
                visited[i] = true;
            }
        }
    }
    public static int calculateManhattanDistance(Point p1, Point p2){
        int xDis = Math.abs(p1.x - p2.x);
        int yDis = Math.abs(p1.y - p2.y);
        return xDis + yDis;
    }
}