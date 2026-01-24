import java.io.*;
import java.util.*;

public class Main {

    static int N; //학교의 수(2~1,000)
    static int M; //도로의 수(1~10,000)
    static int[] p;
    static int sumWeight;
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

    public static void main(String[] args) throws Exception {
        input();
    }

    public static void input() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String line = br.readLine();
                if (line == null) break;

                StringTokenizer st = new StringTokenizer(line);
                int m = Integer.parseInt(st.nextToken()); // 집의 수
                int n = Integer.parseInt(st.nextToken()); // 길의 수

                if (m == 0 && n == 0) break; // 종료 조건

                // 매 케이스마다 초기화 필수
                N = m;
                M = n;
                sumWeight = 0;
                edges = new ArrayList<>();
                p = new int[N]; // 문제에서 집 번호는 0부터 m-1까지임
                Arrays.fill(p, -1);

                for (int i = 0; i < M; i++) {
                    st = new StringTokenizer(br.readLine());
                    int u = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    sumWeight += w;
                    edges.add(new Edge(u, v, w));
                }

                solve();
            }
    }
    public static void solve() {
        edges.sort((e1, e2) -> {
            return Integer.compare(e1.w, e2.w);
        });

        int mstWeight = 0;
        for(Edge edge : edges){
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;
            if(find(u) != find(v)) {
                mstWeight += w;
                union(u, v);
            }
        }
        System.out.println(sumWeight - mstWeight);
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