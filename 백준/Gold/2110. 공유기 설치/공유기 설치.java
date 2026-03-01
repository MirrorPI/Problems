import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N; //집의 개수 (2~200,000)
    static int C; //공유기의 개수(2~N)
    static int[] pos; //집의 좌표(0~1,000,000,000)

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pos = new int[N];
        for(int i=0; i<N; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void solve() {
        Arrays.sort(pos);
        int ans = 0;
        int start = 1;
        int end = pos[N-1] - pos[0];
        while(start <= end) {
            int mid = (start + end)/2;
            if(isPossible(mid)) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.print(ans);
    }
    public static boolean isPossible(int dis) {
        int last = pos[0];
        int cnt = 1;
        for(int i=1; i<N; i++){
            if(pos[i] - last >= dis) {
                last = pos[i];
                cnt++;
            }
        }
        return cnt >= C;
    }
}