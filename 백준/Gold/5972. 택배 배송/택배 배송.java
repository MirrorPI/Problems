import java.io.*;
import java.util.*;

public class Main {

    static class Barn {
        int x;
        int totalCost;

        Barn(int x, int totalCost) {
            this.x = x;
            this.totalCost = totalCost;
        }
    }
    static class Road {
        int to; //도착 헛간
        int cost;

        Road(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int N; //헛간의 갯수(1~50,000)
    static int M; //소의 길의 개수 - 양방향 (1~50,000)
    static ArrayList<Road>[] graph;
    static int[] minTotalCost;
    final static int INF = 55_555_555;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minTotalCost = new int[N+1];
        Arrays.fill(minTotalCost, INF);

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new Road(e, c));
            graph[e].add(new Road(s, c));
        }

        PriorityQueue<Barn> pq = new PriorityQueue<>((b1, b2) -> {
            return Integer.compare(b1.totalCost, b2.totalCost);
        });
        pq.add(new Barn(1, 0));
        minTotalCost[1] = 0;
        while(!pq.isEmpty()){
            Barn cur = pq.poll();
            if(cur.totalCost > minTotalCost[cur.x]) continue;

            for(Road next : graph[cur.x]) {
                int nextTotalCost = cur.totalCost + next.cost;
                if(nextTotalCost >= minTotalCost[next.to]) continue;

                pq.add(new Barn(next.to, nextTotalCost));
                minTotalCost[next.to] = nextTotalCost;
            }
        }
        System.out.print(minTotalCost[N]);
    }
}