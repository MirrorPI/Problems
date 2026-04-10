import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] queries = input();
        solve(queries);
    }

    static int N; //동영상 수(1~5,000)
    static int Q; //질문의 개수(1~5,000)
    static ArrayList<Edge>[] tree; //모두 연결 + 간선 N-1개 = tree
    static class Edge {
        int to;
        int usado;
        Edge(int to, int usado) {
            this.to = to;
            this.usado = usado;
        }
    }

    public static int[][] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());
            tree[u].add(new Edge(v, usado));
            tree[v].add(new Edge(u, usado));
        }
        int[][] queries = new int[Q][2];
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queries[i][0] = k;
            queries[i][1] = v;
        }

        return queries;
    }
    public static void solve(int[][] queries) {
        StringBuilder sb = new StringBuilder();
        for(int[] q : queries) {
            int minRecommendedUsado = q[0];
            int nowWatch = q[1];
            int cnt = countRecommendedVideo(minRecommendedUsado, nowWatch);
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
    public static int countRecommendedVideo(int minRecommendedUsado, int nowWatch) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(nowWatch);
        visited[nowWatch] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(Edge next : tree[curr]) {
                if(next.usado < minRecommendedUsado || visited[next.to]) continue;

                visited[next.to] = true;
                q.add(next.to);
                cnt++;
            }
        }

        return cnt;
    }
}