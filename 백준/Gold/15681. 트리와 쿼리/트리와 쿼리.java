import java.io.*;
import java.util.*;

public class Main {

    static int N, R, Q; //정점의 수, 루트의 번호, 쿼리의 수(2 ≤ N ≤ 105, 1 ≤ R ≤ N, 1 ≤ Q ≤ 105)
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static int[] size;
    static int[] q;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1];
        parent = new int[N+1];
        size = new int[N+1];
        q = new int[Q];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        for(int i=0; i<Q; i++){
            q[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void solve() {
        StringBuilder sb = new StringBuilder();
        dfs(R, -1);
        for(int n : q){
            sb.append(size[n]).append('\n');
        }
        System.out.print(sb);
    }

    public static int dfs(int node, int p) {
        size[node] = 1;
        parent[node] = p;

        for(int next : tree[node]){
            if(next == parent[node]) continue;

            size[node] += dfs(next, node);
        }

        return size[node];
    }
}