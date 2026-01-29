import java.io.*;
import java.util.*;

public class Main {

    static int N; //선분의 개수(1~3,000)
    static int[] p;
    public static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static class Line {
        int i;
        Point p1;
        Point p2;
        Line(int i, Point p1, Point p2){
            this.i = i;
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
        N = Integer.parseInt(br.readLine());
        p = new int[N]; Arrays.fill(p, -1);
        lines = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            Point p1 = new Point(x1, y1);
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            Point p2 = new Point(x2, y2);
            lines.add(new Line(i, p1, p2));
        }
    }
    public static void solve() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i == j) continue;

                Line l1 = lines.get(i);
                Line l2 = lines.get(j);
                if(isCrossed(l1, l2)){
                    union(l1.i, l2.i);
                }
            }
        }
        int min = 0;
        int cnt = 0;
        int maxCrossLine = 0;
        for(int i=0; i<N; i++){
            if(p[i] < min) {
                min = p[i];
                maxCrossLine = p[i] * -1;
            }
            if(p[i] < 0) {
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder(3);
        sb.append(cnt).append('\n').append(maxCrossLine);
        System.out.print(sb);
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
        int result =  (AB.p2.x - AB.p1.x)*(C.y - AB.p1.y) - (C.x - AB.p1.x)*(AB.p2.y - AB.p1.y);
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
    public static int find(int x) {
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }
    public static void union(int x, int y) {
        int u = find(x);
        int v = find(y);
        if(u == v) return;

        if(p[u] > p[v]) {
            int t = u;
            u = v;
            v = t;
        }
        p[u] += p[v];

        p[v] = u;
    }
}