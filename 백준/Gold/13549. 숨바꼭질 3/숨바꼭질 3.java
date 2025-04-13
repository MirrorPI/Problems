import java.util.*;
import java.io.*;

public class Main {

    static int N, M; //수빈 위치(0~100,000), 동생 위치(0~100,000)
    static int[] t;
    static final int INF = 111111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = new int[140000]; //2x - 100000 <= 100000 - x, x < 70000
        Arrays.fill(t, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1[1], n2[1]);
        });
        pq.add(new int[] {N, 0});
        t[N] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(t[cur[0]] < cur[1]) continue;

            int[] nxt1 = new int[] {cur[0] + 1, cur[1] + 1};
            int[] nxt2 = new int[] {cur[0] - 1, cur[1] + 1};
            int[] nxt3 = new int[] {cur[0] * 2, cur[1]};

            if(nxt1[0] <= 100000 && t[nxt1[0]] > t[cur[0]] + 1){
                t[nxt1[0]] = t[cur[0]] + 1;
                pq.add(new int[] {nxt1[0], t[nxt1[0]]});
            }
            if(nxt2[0] >= 0 && t[nxt2[0]] > t[cur[0]] + 1){
                t[nxt2[0]] = t[cur[0]] + 1;
                pq.add(new int[] {nxt2[0], t[nxt2[0]]});
            }
            if(nxt3[0] > 0 && nxt3[0] < 140000 && t[nxt3[0]] > t[cur[0]]){
                t[nxt3[0]] = t[cur[0]];
                pq.add(new int[] {nxt3[0], t[nxt3[0]]});
            }
        }
        System.out.print(t[M]);
        br.close();
    }
}