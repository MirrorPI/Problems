import java.io.*;
import java.util.*;

public class Main {

    static int N; //별의 개수(1~100)
    static int[] p;
    static ArrayList<Star> stars;
    static ArrayList<Edge> edges;
    static class Star{
        double x;
        double y;
        int i;
        Star(int i, double x, double y){
            this.i = i;
            this.x = x;
            this.y = y;
        }
    }
    static class Edge {
        int u;
        int v;
        double distSquare;
        Edge (int u, double x1, double y1, int v, double x2, double y2){
            this.u = u;
            this.v = v;
            this.distSquare = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N]; Arrays.fill(p, -1);
        stars = new ArrayList<>();
        edges = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars.add(new Star(i, x, y));
        }
        for(Star starU : stars) {
            for(Star starV : stars){
                if(starU.i == starV.i) continue;

                edges.add(new Edge(starU.i, starU.x, starU.y, starV.i, starV.x, starV.y));
            }
        }
        edges.sort((e1, e2) -> {
            return Double.compare(e1.distSquare, e2.distSquare);
        });
        double minDist = 0.0;
        for(Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            double distSquare = edge.distSquare;
            if(find(u) != find(v)){
                minDist += Math.sqrt(distSquare);
                union(u, v);
            }
        }
        System.out.printf("%.2f", minDist);
    }
    public static int find(int x) {
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }
    public static void union(int x, int y){
        int u = find(x);
        int v = find(y);
        if(u == v) return;

        if(p[u] > p[v]){
            int t = u;
            u = v;
            v = t;
        }
        if(p[u] == p[v]) p[u]--;

        p[v] = u;
    }
}