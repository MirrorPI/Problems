import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] p;
    static boolean[][] check;
    static ArrayList<Edge> edges;
    static class Edge {
        int u;
        int v;
        int w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N]; Arrays.fill(p, -1);
        check = new boolean[N][N];
        edges = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int w = Integer.parseInt(st.nextToken());
                if(i==j || check[i][j]) continue;

                check[i][j] = true;
                edges.add(new Edge(i, j, w));
            }
        }
        edges.sort((e1, e2) -> {
            return Integer.compare(e1.w, e2.w);
        });

        long ans = 0;
        for(Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;
            if(find(u) != find(v)) {
                ans += w;
                union(u, v);
            }
        }
        System.out.print(ans);
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
        if(p[u] == p[v]) p[u]--;

        p[v] = u;
    }
}