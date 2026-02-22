import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N; //기간 (1~100,000)
    static int M; //사용 횟수 제한(1~N)
    static int[] plan; //(1~10,000)
    final static int MAX = 100_000 * 10_000;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        plan = new int[N];
        for(int i=0; i<N; i++) {
            plan[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }
    public static void solve() {
        int start = 0;
        int end = MAX;
        int ans = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(available(mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.print(ans);
    }
    public static boolean available(int k) {
        int budget = 0;
        int cnt = 0;
        for(int i=0; i<N; i++){
            int need = plan[i];
            if(need > k) {
                return false;
            }
            if(need > budget) {
                budget = k - need;
                cnt++;
            } else {
                budget -= need;
            }
        }
        return cnt <= M;
    }
}