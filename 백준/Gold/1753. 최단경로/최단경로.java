import java.util.*;
import java.io.*;

public class Main {

    static int V, E; //정점의 개수(1~20,000), 간선의 개수(1~300,000)
    static int start; //시작 정점.
    static List<int[]>[] graph;
    static int[] d; //최단 경로;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        d = new int[V+1];
        Arrays.fill(d, INF);
        for(int i=1; i<=V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //u -> v 의 가중치 w
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{w, v});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1[0], n2[0]);
        });
        d[start] = 0;
        pq.offer(new int[] {d[start], start});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (d[cur[1]] < cur[0]) continue; //현재 저장된 최단 거리보다 지금 확인할 거리가 더 크다면 볼 필요가 없음.

            for (int[] nxt : graph[cur[1]]) {
                if (d[nxt[1]] <= d[cur[1]] + nxt[0]) continue;
                d[nxt[1]] = d[cur[1]] + nxt[0];
                pq.offer(new int[]{d[nxt[1]], nxt[1]});
            }
        }
        for(int i=1; i<= V; i++){
            if(d[i] == INF) sb.append("INF").append("\n");
            else sb.append(d[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}