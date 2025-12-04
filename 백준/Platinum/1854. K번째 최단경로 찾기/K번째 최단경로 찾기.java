import java.io.*;
import java.util.*;

public class Main {

    static class Road {
        int to; //도착지점
        int dist;
        Road(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }
    static class City {
        int x; //현재 위치
        int totalDist; //현재까지의 거리 합
        City (int x, int totalDist){
            this.x = x;
            this.totalDist = totalDist;
        }
    }
    static int n; //도시의 개수(1~1000)
    static int m; //도로의 개수(0~250,000)
    static int k; //k번째 최단경로(1~100), mk(1~3,000,000)
    static ArrayList<Road>[] roads;
    static PriorityQueue<Integer>[] maxHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        roads = new ArrayList[n+1];
        maxHeap = new PriorityQueue[n+1];
        for(int i=1; i<=n; i++){
            roads[i] = new ArrayList<>();
            maxHeap[i] = new PriorityQueue<>((n1, n2) -> {
                return Integer.compare(n2, n1);
            });
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            roads[s].add(new Road(e, d));
        }
        PriorityQueue<City> pq = new PriorityQueue<>((c1, c2) -> {
            return Integer.compare(c1.totalDist, c2.totalDist);
        });
        pq.add(new City(1, 0));
        maxHeap[1].add(0);
        while(!pq.isEmpty()){
            City curr = pq.poll();

            for(Road next : roads[curr.x]){
                int nextDist = curr.totalDist + next.dist;
                if(!maxHeap[next.to].isEmpty() && maxHeap[next.to].size() >= k){
                    if(maxHeap[next.to].peek() <= nextDist) continue;


                    maxHeap[next.to].poll();
                    maxHeap[next.to].add(nextDist);
                    pq.add(new City(next.to, nextDist));
                } else {
                    maxHeap[next.to].add(nextDist);
                    pq.add(new City(next.to, nextDist));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            if(!maxHeap[i].isEmpty() && maxHeap[i].size() >= k) {
                sb.append(maxHeap[i].peek()).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.print(sb);
    }
}