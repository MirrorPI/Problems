import java.io.*;
import java.util.*;

public class Main {

    public static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static class Line {
        Point p1;
        Point p2;
        Line(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }
    }
    static ArrayList<Line> lines;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lines = new ArrayList<>();
        for(int i=0; i<2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            Point p1 = new Point(x1, y1);
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            Point p2 = new Point(x2, y2);
            lines.add(new Line(p1, p2));
        }
    }
    public static void solve() {
        Line l1 = lines.get(0);
        Line l2 = lines.get(1);
        System.out.print(isCrossed(l1, l2) ? 1 : 0);
    }
    public static boolean isCrossed(Line l1, Line l2) {
        int abc = ccw(l1, l2.p1);
        int abd = ccw(l1, l2.p2);
        int cda = ccw(l2, l1.p1);
        int cdb = ccw(l2, l1.p2);

        if(abc * abd == 0 && cda * cdb == 0) { //일직선 위에 있어서 겹치는지 별도의 계산 필요
            int maxX1 = Math.max(l1.p1.x, l1.p2.x);
            int minX1 = Math.min(l1.p1.x, l1.p2.x);
            int maxY1 = Math.max(l1.p1.y, l1.p2.y);
            int minY1 = Math.min(l1.p1.y, l1.p2.y);

            int maxX2 = Math.max(l2.p1.x, l2.p2.x);
            int minX2 = Math.min(l2.p1.x, l2.p2.x);
            int maxY2 = Math.max(l2.p1.y, l2.p2.y);
            int minY2 = Math.min(l2.p1.y, l2.p2.y);

            return minX1 <= maxX2 && minX2 <= maxX1 && minY1 <= maxY2 && minY2 <= maxY1;
        }

        return abc * abd <= 0 && cda * cdb <= 0;
    }
    public static int ccw(Line AB, Point C){
        long result =  (long)(AB.p2.x - AB.p1.x)*(C.y - AB.p1.y) - (long)(C.x - AB.p1.x)*(AB.p2.y - AB.p1.y);
        if(result > 0) { //외적 결과 양수 -> 오른손 법칙 -> 반시계 -> C는 AB 선분 왼쪽에 있다.
            return 1;
        } else if(result < 0){ //시계
            return -1;
        } else { //일직선
            return 0;
        }
        // ccw(AB, C) ccw(AB, D) 의 부호가 반대면 C와 D가 직선 AB를 기준으로 반대편에 있음
        // ccw(CD, A) ccW(CD, B) 의 부호도 반대면 두 선분은 교차함
    }
}