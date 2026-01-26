import java.io.*;
import java.util.*;

public class Main {

    static int N; //좌표의 개수(3~10,000)
    static double area;
    static Point[] points;
    static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        points = new Point[N+1];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        points[N] = points[0];
    }
    public static void solve() {
        for(int i=0; i<N; i++){
            area += (double)points[i].x * points[i+1].y;
            area -= (double)points[i].y * points[i+1].x;
        }
        area = area < 0 ? area * -1 : area;
        area /= 2;
        System.out.printf("%.1f", area);
    }
}