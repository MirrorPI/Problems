import java.io.*;
import java.util.*;

public class Main {

    static class Road {
        int to; //도착 도시
        int dist;
        Road(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }
    static class City {
        int x;
        int nowCostPerDist;
        long totalCost;
        City(int x, int nowCostPerDist, long totalCost){
            this.x = x;
            this.nowCostPerDist = nowCostPerDist;
            this.totalCost = totalCost;
        }
    }

    static int N; //도시의 개수 (2~2,500)
    static int M; //도로의 개수 (1~4,000)
    static int[] costPerDist;
    static long[][] minTotalCost;
    final static long INF = Long.MAX_VALUE/4;
    final static int MAX_COST = 2500;
    static List<Road>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        costPerDist = new int[N+1];
        minTotalCost = new long[N+1][MAX_COST+1];
        graph = new ArrayList[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            Arrays.fill(minTotalCost[i], INF);
            costPerDist[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[s].add(new Road(e, d));
            graph[e].add(new Road(s, d));
        }
        PriorityQueue<City> pq = new PriorityQueue<>((c1, c2) -> {
            return Long.compare(c1.totalCost, c2.totalCost);
        });
        pq.add(new City(1, costPerDist[1], 0));
        minTotalCost[1][costPerDist[1]] = 0;
        while(!pq.isEmpty()){
            City cur = pq.poll();
            if(cur.totalCost > minTotalCost[cur.x][cur.nowCostPerDist]) continue;

            if(cur.x == N) {
                System.out.print(cur.totalCost);
                return;
            }

            for(Road next : graph[cur.x]){
                long addCost = (long)cur.nowCostPerDist * next.dist;
                long nextTotalCost = cur.totalCost + addCost;
                if(nextTotalCost >= minTotalCost[next.to][cur.nowCostPerDist]) continue;
                int nextCostPerDist = Math.min(cur.nowCostPerDist, costPerDist[next.to]);

                minTotalCost[next.to][cur.nowCostPerDist] = nextTotalCost;
                pq.add(new City(next.to, nextCostPerDist, nextTotalCost));
            }
        }
    }
}