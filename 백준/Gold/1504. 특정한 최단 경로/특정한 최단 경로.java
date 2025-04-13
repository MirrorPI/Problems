import java.util.*;
import java.io.*;

public class Main {

    static int N, E; //정점의 개수(2~800), 간선의 개수(0~200,000)
    static int[] d1;
    static int[] dv1;
    static int[] dv2;
    static List<int[]>[] graph;
    static final int INF = 222222222;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
        return Integer.compare(n1[1], n2[1]);
    });

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        d1 = new int[N+1]; Arrays.fill(d1, INF);
        dv1 = new int[N+1]; Arrays.fill(dv1, INF);
        dv2 = new int[N+1]; Arrays.fill(dv2, INF);
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        dijkstra(1, d1);
        dijkstra(v1, dv1);
        dijkstra(v2, dv2);

        int path1 = d1[v1] + dv1[v2] + dv2[N]; //1 -> v1 -> v2 -> N
        int path2 = d1[v2] + dv2[v1] + dv1[N]; //1 -> v2 -> v1 -> N
        int ans = Math.min(path1, path2);
        if(ans >= INF) ans = -1;
        System.out.print(ans);
        br.close();
    }
    private static void dijkstra(int s, int[] d){
        pq.offer(new int[] {s, 0});
        d[s] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(d[cur[0]] < cur[1]) continue;
            for(int[] nxt : graph[cur[0]]){
                if(d[nxt[0]] <= d[cur[0]] + nxt[1]) continue;

                d[nxt[0]] = d[cur[0]] + nxt[1];
                pq.offer(new int[] {nxt[0] , d[nxt[0]]});
            }
        }
    }
}