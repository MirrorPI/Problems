import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to; //from -> to 도착 정점
        int seq; //신호 순서

        Edge(int to, int seq) {
            this.to = to;
            this.seq = seq;
        }
    }

    static class Node {
        int x; //현재 위치
        long t; //현재 위치까지의 누적 시간

        Node(int x, long t){
            this.x = x;
            this.t = t;
        }
    }

    static int N; //지역의 개수(2~100,000)
    static int M; //신호 주기(1~700,000)
    static long[] minT;
    static List<Edge>[] graph;
    static long MAX = 100_001 * 700_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minT = new long[N+1]; // 8 * 100,000 = 0.8MB
        Arrays.fill(minT, MAX);
        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String input = br.readLine();
            st = new StringTokenizer(input);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, i));
            graph[v].add(new Edge(u, i));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) ->{
            return Long.compare(n1.t, n2.t);
        });
        minT[1] = 0;
        Node start = new Node(1, 0);
        pq.add(start);
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.t > minT[now.x]) continue;

            for(Edge next : graph[now.x]){

                long wait = (next.seq - (now.t % M) + M) % M;
                if(now.t + wait + 1 >= minT[next.to]) continue;

                minT[next.to] = now.t + wait + 1;
                pq.add(new Node(next.to, minT[next.to]));
            }
        }
        System.out.print(minT[N]);
    }
}