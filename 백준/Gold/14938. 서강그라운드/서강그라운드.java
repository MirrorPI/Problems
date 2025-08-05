import java.io.*;
import java.util.*;

public class Main{

    static int n; //지역의 개수(1~100)
    static int m; //수색 범위(1~15)
    static int r; //길의 개수(1~100)
    static int[] t; //각 지역의 아이템 개수(1~30)
    static List<int[]>[] graph; //길의 길이(1~15)
    static int[] minD;
    final static int MAX = 3333;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        t = new int[n+1];
        minD = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            t[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, l});
            graph[v].add(new int[] {u, l});
        }
        for(int i=1; i<=n; i++){
            findMinDist(i);
        }
        System.out.print(ans);
        br.close();
    }
    public static void findMinDist(int start){
        Arrays.fill(minD, MAX);
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) ->{
            return Integer.compare(p1[1], p2[1]);
        });
        pq.add(new int[] {start, 0});
        minD[start] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curX = cur[0];
            int curD = cur[1];
            if(curD < minD[curX]) continue;

            for(int[] next : graph[curX]){
                int nextX = next[0];
                int curNextDist = next[1];
                if(minD[nextX] <= curD + curNextDist) continue;

                minD[nextX] = curD + curNextDist;
                pq.add(new int[] {nextX, minD[nextX]});
            }
        }
        findMaxItems();
    }
    public static void findMaxItems(){
        int items = 0;
        for(int i=1; i<=n; i++){
            if(minD[i] <= m) {
                items += t[i];
            }
        }
        ans = Math.max(ans, items);
    }
}