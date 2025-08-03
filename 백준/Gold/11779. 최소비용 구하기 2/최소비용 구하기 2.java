import java.io.*;
import java.util.*;

public class Main {

    static int n; //도시의 개수(1~1,000)
    static int m; //버스의 개수(1~100,000)
    static int[] minW;
    static int[] preCity;
    static List<int[]>[] graph;
    final static int MAX = 1_000 * 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        minW = new int[n+1]; Arrays.fill(minW, MAX);
        preCity = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> {
           return Integer.compare(c1[1], c2[1]);
        });
        pq.add(new int[] {start, 0});
        minW[start] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int curW = cur[1];
            if(curW > minW[x]) continue;

            for(int[] next : graph[x] ){
                int nx = next[0];
                int w = next[1];
                if(curW + w >= minW[nx]) continue;

                minW[nx] = curW + w;
                pq.add(new int[] {nx, minW[nx]});
                preCity[nx] = x;
            }
        }
        int cur = end;
        List<Integer> path = new ArrayList<>();
        while(cur != 0){
            path.add(cur);
            cur = preCity[cur];
        }
        sb.append(minW[end]).append("\n")
                .append(path.size()).append("\n");
        for(int i=path.size()-1; i>=0; i--){
            sb.append(path.get(i)).append(' ');
        }
        System.out.print(sb);
        br.close();
    }
}