import java.util.*;
import java.io.*;

public class Main {

    static int N; //건물의 수(2~100)
    static int T, M; //남은 시간(10,000), 가지고 있는 돈(0~10000)
    static int L; //길의 개수(1~10,000)
    static List<int[]>[] way;
    static int[][] time; //money[위치][비용]
    static final int INF = 11111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        way = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            way[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(time[i], INF);
        }
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            way[u].add(new int[] {v, t, m});
            way[v].add(new int[] {u, t, m});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1[2], n2[2]);
        });
        pq.add(new int[] {1, 0, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int p = cur[0]; //현재 위치
            int t = cur[1]; //현재 위치까지 오는데 든 시간
            int m = cur[2]; //현재 위치까지 오는데 든 비용

            //처음 실수한 부분 -> 최소비용에 경계조건(T를 넘기면 안된다, M을 넘기면 안된다)만 고려할 경우,
            // 최소비용일 때 시간을 넘겨버려서 갈 수 있는 곳도 못가게 되는 상황이 생김.
            if(time[p][m] < t) continue;
            //같은 비용으로 여기까지 왔을 때 시간이 더 큰 것은 불리하기 때문에 넘김

            for(int[] nxt : way[cur[0]]) {
                int np = nxt[0]; //현재 위치에서 확인할 다음 위치
                int nt = t + nxt[1]; //현재 위치에서 다음 위치까지 들 총 시간
                int nm = m + nxt[2]; //현재 위치에서 다음 위치까지 들 총 비용

                if(nm > M || nt > T ) continue;

                time[np][nm] = nt;
                pq.add(new int[] {np, nt, nm});
            }
        }
        int ans = -1;
        for(int m=0; m<=M; m++){
            if(time[N][m] < INF){
                ans = m;
                break;
            }
        }
        System.out.print(ans);
        br.close();
    }
}