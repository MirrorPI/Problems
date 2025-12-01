import java.io.*;
import java.util.*;

public class Main {

    static class Road {
        int to; //도로의 끝.
        int dist;
        Road (int to, int dist){
            this.to = to;
            this.dist = dist;
        }
    }
    static class City {
        int x; //현재 위치
        long totalTime; //지금까지 총 시간
        int k; //지금까지 포장한 도로 수
        City (int x, long totalTime, int k) {
            this.x = x;
            this.totalTime = totalTime;
            this.k = k;
        }
    }

    static int N; //도시의 개수(1~10,000)
    static int M; //도로의 개수(1~50,000)
    static int K; //포장할 도로의 개수(1~20)
    static long[][] minTotalTime;
    final static long INF = Long.MAX_VALUE;
    static List<Road>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        minTotalTime = new long[N+1][K+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(minTotalTime[i], INF);
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new Road(e, t));
            graph[e].add(new Road(s, t));
        }

        PriorityQueue<City> pq = new PriorityQueue<>((c1, c2) -> {
            return Long.compare(c1.totalTime, c2.totalTime);
        });
        minTotalTime[1][0] = 0;
        pq.add(new City(1, 0, 0));
        while(!pq.isEmpty()){
            City cur = pq.poll();
            if(cur.totalTime > minTotalTime[cur.x][cur.k]) continue;

            for(Road next : graph[cur.x]){
                if(cur.k == K) {
                    if(cur.totalTime + next.dist >= minTotalTime[next.to][K]) continue;

                    minTotalTime[next.to][K] = cur.totalTime + next.dist;
                    pq.add(new City(next.to, minTotalTime[next.to][K], K));
                } else {
                    if(cur.totalTime < minTotalTime[next.to][cur.k + 1]){
                        minTotalTime[next.to][cur.k + 1] = cur.totalTime;
                        pq.add(new City(next.to, cur.totalTime, cur.k+1));
                    }
                    if(cur.totalTime + next.dist < minTotalTime[next.to][cur.k]){
                        minTotalTime[next.to][cur.k] = cur.totalTime + next.dist;
                        pq.add(new City(next.to, minTotalTime[next.to][cur.k], cur.k));
                    }
                }
            }
        }
        long ans = INF;
        for(int i=0; i<=K; i++){
            if(minTotalTime[N][i] == INF) continue;

            ans = Math.min(minTotalTime[N][i], ans);
        }
        System.out.print(ans);
        br.close();
    }
}