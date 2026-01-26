import java.io.*;
import java.util.*;

public class Main {

    static int N; //숫자의 개수(1~100,000)
    static int M; //숫자의 차 기준.(0~2,000,000,000)
    static int[] arr; //(-1,000,000,000~1,000,000,000)
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.print(min);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void solve() {
        Arrays.sort(arr);

        int right = 0;
        for(int left=0; left<N; left++){
            while(right < N && arr[right] - arr[left] < M) right++;

            if(right == N) break;

            min = Math.min(min, arr[right] - arr[left]);
        }
    }
}