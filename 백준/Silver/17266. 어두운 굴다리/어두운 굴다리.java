import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N; //굴다리의 길이(1~100,000) 0~N;
    static int M; //가로등의 개수(1~N)
    static int[] x; //가로등을 설치할 위치 - 오름차순

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        x = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        int start = 0;
        int end = N;
        int ans = 0;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(check(mid)) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        System.out.print(ans);
    }
    public static boolean check(int mid) {
        if(x[0] - mid > 0 || x[M-1] + mid < N) return false;

        int last = x[0] + mid;

        for(int i=1; i<M; i++){
            if(last  >= x[i] - mid) {
                last = x[i] + mid;
            } else return false;
        }
        return last >= N;
    }
}