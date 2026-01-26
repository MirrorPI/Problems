import java.io.*;
import java.util.*;

public class Main {

    final static int INF = 111_111;
    static int N; //수의 개수(10~100,000)
    static int S; //합의 최소 기준(0~100,000,000)
    static int[] arr;//(1~10,000)
    static int min = INF;


    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }
    public static void solve() {
        int right = 0;
        int sum = arr[0];
        for(int left=0; left<N; left++){
            while(right < N && sum < S) {
                right++;
                if(right < N) {
                    sum += arr[right];
                }
            }
            if(right == N) break;
            min = Math.min(min, right-left+1);
            sum -= arr[left];
        }

        System.out.print(min == INF ? 0 : min);
    }
}