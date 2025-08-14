import java.io.*;
import java.util.*;

public class Main{

    static int n; //컴퓨터 수(1~10,000)
    static int d; //의존성 수(1~100,000)
    static int c; //해킹당한 컴퓨터 번호
    static List<int[]>[] graph;
    static int[] minT;
    final static int MAX = 11_111_111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> {
            return Integer.compare(c1[1], c2[1]);
        });

        int T = Integer.parseInt(br.readLine());
        for(int testCase=0; testCase<T; testCase++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int count = 0;
            int last = c;
            minT = new int[n+1]; Arrays.fill(minT, MAX);
            graph = new ArrayList[n+1];
            for(int i=1; i<=n ;i++){
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                graph[v].add(new int[] {u, t });
            }
            pq.clear();
            pq.add(new int[] {c, 0});
            minT[c] = 0;
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int curX = cur[0];
                int curT = cur[1];
                if(curT > minT[curX]) continue;
                count += 1;

                for(int[] next : graph[curX]){
                    int nextX = next[0];
                    int nextT = next[1];
                    if(curT + nextT >= minT[nextX]) continue;

                    minT[nextX] = curT + nextT;
                    pq.add(new int[] {nextX, minT[nextX]});
                }
                last = curX;
            }
            sb.append(count).append(" ").append(minT[last]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}