import java.io.*;
import java.util.*;

public class Main {

    static int N; //정점의 개수(1~1,000)
    static int M; //간선의 개수(0~NC2)
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int n=1; n<=N; n++){
            graph[n] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for(int n=1; n<=N; n++){
            if(visited[n]) continue;

            bfs(n);
        }
        System.out.print(count);
    }
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph[cur]){
                if(visited[next]) continue;

                q.add(next);
                visited[next] = true;
            }
        }
        count++;
    }
}