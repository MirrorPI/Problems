import java.io.*;
import java.util.*;

public class Main {

    static int n; //동기의 수(2~500)
    static int m; //리스트의 길이(1~10,000)
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
    }
    public static void solve() {
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        for(int n : graph[1]) {
            q.add(n);
            cnt++;
            visited[n] = true;
        }
        while(!q.isEmpty()) {
            int friend = q.poll();
            for(int nxt : graph[friend]) {
                if(visited[nxt]) continue;

                visited[nxt] = true;
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}