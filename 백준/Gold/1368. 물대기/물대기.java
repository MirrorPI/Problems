import java.io.*;
import java.util.*;

public class Main {

    static int N; //논의 수(1~300)
    static int[] p;
    static ArrayList<Edge> edges;
    static class Edge {
        int u;
        int v;
        int weight;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.weight = w;
        }
    }
    static int mstTotalWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        edges = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        p = new int[N+1]; Arrays.fill(p, -1);
        for(int i=1; i<=N; i++){
            int w = Integer.parseInt(br.readLine());
            edges.add(new Edge(0, i, w));
        }
        boolean[][] isChecked = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int w = Integer.parseInt(st.nextToken());
                if(i == j || isChecked[i][j]) continue;

                isChecked[i][j] = true;
                edges.add(new Edge(i, j, w));
            }
        }

        edges.sort((e1, e2) -> {
            return Integer.compare(e1.weight, e2.weight);
        });

        for(Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int w = edge.weight;

            if(find(u) != find(v)) {
                mstTotalWeight += w;
                union(u, v);
            }
        }
        System.out.print(mstTotalWeight);
    }

    static int find(int x) {
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }
    static void union(int x, int y){
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