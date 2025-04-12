import java.util.*;
import java.io.*;

public class Main {

    static int N; //도시의 개수(1~1000)
    static int M; //버스의 개수(1~100,000)
    static List<int[]>[] graph;
    static final int INF = Integer.MAX_VALUE;
    static int[] d;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        d = new int[N+1];
        Arrays.fill(d, INF);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w});
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1[1], n2[1]);
        });
        d[s] = 0;
        pq.offer(new int[] {s, d[s]});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(d[cur[0]] < cur[1]) continue;

            for(int[] nxt : graph[cur[0]]){
                if(d[nxt[0]] <= d[cur[0]] + nxt[1]) continue;

                d[nxt[0]] = d[cur[0]] + nxt[1];
                pq.offer(new int[] {nxt[0], d[nxt[0]]});
            }
        }
        System.out.print(d[e]);
        br.close();
    }
}