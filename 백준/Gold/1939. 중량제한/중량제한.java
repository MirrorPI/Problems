import java.io.*;
import java.util.*;

public class Main{

    static int N; //섬의 개수(2~10,000)
    static int M; //다리의 개수(1~100,000)
    static int[] minAvailableWeight;
    static List<int[]>[] graph;
    final static int MAX = 1_111_111_111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minAvailableWeight = new int[N+1]; //Arrays.fill(minAvailableWeight, MAX);
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int aw = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, aw});
            graph[v].add(new int[] {u, aw});
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> {
           return Integer.compare(i2[1], i1[1]);
        });
        pq.add(new int[] {s, MAX});
        minAvailableWeight[s] = MAX;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curX = cur[0];
            int curAW = cur[1];
            if(curAW < minAvailableWeight[curX]) continue;

            for(int[] next : graph[curX]){
                int nextX = next[0];
                int nextAW = next[1];
                int betterRootAW = Math.min(curAW, nextAW);
                if(betterRootAW <= minAvailableWeight[nextX]) continue;

                minAvailableWeight[nextX] = betterRootAW;
                pq.add(new int[] {nextX, betterRootAW});
            }
        }
        System.out.print(minAvailableWeight[e]);
        br.close();
    }
}