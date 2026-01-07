import java.io.*;
import java.util.*;

public class Main {

    static int V, E; //정점의 개수(1~10,000), 간선의 개수(1~100,000)
    static ArrayList<int[]> edges;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        p = new int[V+1];
        Arrays.fill(p, -1);

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[] {u, v, c});
        }
        edges.sort((e1, e2) -> {
            return Integer.compare(e1[2], e2[2]);
        });

        int ans = 0;
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];

            if(find(u) != find(v)){
                ans += c;
                union(u, v);
            }
        }
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