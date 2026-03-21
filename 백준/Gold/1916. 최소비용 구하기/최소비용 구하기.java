import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N; //도시의 개수(1~1000)
    static int M; //버스의 개수(1~100,000)
    static ArrayList<Bus>[] buses;
    static int[] minTotalDist;
    static class City {
        int x; //현재 위치
        int totalDist; //현재까지 비용
        City (int x, int totalDist) {
            this.x = x;
            this.totalDist = totalDist;
        }
    }
    static class Bus {
        int to; //도착 지점
        int dist; //버스 비용
        Bus (int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    static int start;
    static int end;
    final static int INF = 100_000_000;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        buses = new ArrayList[N+1];
        minTotalDist = new int[N+1];
        Arrays.fill(minTotalDist, INF);
        for(int i=1; i<=N; i++) {
            buses[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            buses[s].add(new Bus(e, d));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        PriorityQueue<City> pq = new PriorityQueue<>((c1, c2) -> {
            return Integer.compare(c1.totalDist, c2.totalDist);
        });
        pq.add(new City(start, 0));
        minTotalDist[start] = 0;
        while(!pq.isEmpty()){
            City curr = pq.poll();

            if(curr.totalDist > minTotalDist[curr.x]) continue;

            for(Bus next : buses[curr.x]) {
                int nextTotalDist = curr.totalDist + next.dist;

                if(minTotalDist[next.to] <= nextTotalDist) continue;

                pq.add(new City(next.to, nextTotalDist));
                minTotalDist[next.to] = nextTotalDist;
            }
        }

        System.out.print(minTotalDist[end]);
    }
}