import java.io.*;
import java.util.*;

public class Main {

    static int N; //학교의 수(2~1,000)
    static int M; //도로의 수(1~10,000)
    static boolean[] isMan;
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

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isMan = new boolean[N+1];
        p = new int[N+1];
        Arrays.fill(p, -1);
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            isMan[i] = st.nextToken().charAt(0) == 'M';
        }

        edges = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }
    }
    public static void solve() {
        edges.sort((e1, e2) -> {
            return Integer.compare(e1.w, e2.w);
        });

        int mstWeight = 0;
        int connectCnt = 0;
        for(Edge edge : edges){
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;
            if(find(u) != find(v) && isMan[u] != isMan[v]) {
                connectCnt += 1;
                mstWeight += w;
                union(u, v);
            }
        }
        System.out.print(connectCnt == N-1 ? mstWeight : -1);
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