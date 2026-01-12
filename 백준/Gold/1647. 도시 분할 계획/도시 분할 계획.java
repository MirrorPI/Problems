import java.io.*;
import java.util.*;

public class Main {

    static int N; //집의 개수 (2~100,000)
    static int M; //길의 개수 (1~1,000,000)
    static int[] p;
    static ArrayList<Edge> edges;
    static class Edge {
        int u;
        int v;
        int w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N+1]; Arrays.fill(p, -1);
        edges = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
        edges.sort((e1, e2) -> {
            return Integer.compare(e1.w, e2.w);
        });
        int minTotalCost = 0;
        int maxEdgeCost = 0;
        for(Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;
            if(find(u) != find(v)) {
                minTotalCost += w;
                union(u, v);
                if(maxEdgeCost < w){
                    maxEdgeCost = w;
                }
            }
        }
        int ans = minTotalCost - maxEdgeCost;

        System.out.print(ans);
    }
    public static int find(int x) {
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }
    public static void union(int x, int y){
        int u = find(x);
        int v = find(y);
        if(u == v) return;

        if(p[u] > p[v]) {
            int t = u;
            u = v;
            v = t;
        }
        if(p[u] == p[v]) p[u]--;

        p[v] = u;
    }
}