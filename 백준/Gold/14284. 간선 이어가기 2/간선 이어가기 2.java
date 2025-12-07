import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int totalCost;

        Node(int x, int totalCost){
            this.x = x;
            this.totalCost = totalCost;
        }
    }
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static int n; //정점의 개수(2~5,000)
    static int m; //간선의 개수(1~100,000)
    static ArrayList<Edge>[] graph;
    static int s, e; //최소 가중치를 구해야하는 시작과 끝 정점
    static int[] minTotalCost;
    final static int INF = 11_111_111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        minTotalCost = new int[n+1];
        Arrays.fill(minTotalCost, INF);

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1.totalCost, n2.totalCost);
        });
        pq.add(new Node(s, 0));
        minTotalCost[s] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.totalCost > minTotalCost[cur.x]) continue;

            for(Edge next : graph[cur.x]){
                int nextTotalCost = cur.totalCost + next.cost;
                if(nextTotalCost >= minTotalCost[next.to]) continue;

                pq.add(new Node(next.to, nextTotalCost));
                minTotalCost[next.to] = nextTotalCost;
            }
        }
        System.out.print(minTotalCost[e]);
    }
}