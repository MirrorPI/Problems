import java.io.*;
import java.util.*;

public class Main {

    static int N; //컴퓨터 수 (1~1000)
    static int M; //연결할 수 있는 선의 수(1~100,000)
    static int[] p;
    static ArrayList<Edge> edges;
    static class Edge {
        int u;
        int v;
        int w; //(1~10,000)
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        p = new int[N+1]; Arrays.fill(p, -1);
        edges = new ArrayList<>();
        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
        edges.sort((e1, e2) -> {
            return Integer.compare(e1.w, e2.w);
        });

        int minWeight = 0;
        for(Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;
            if(find(u) != find(v)) {
                minWeight += w;
                union(u, v);
            }
        }
        System.out.print(minWeight);
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