import java.util.*;
import java.io.*;

public class Main {

    static int N, M; //(1~8)
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        solve(1, 0, 0);
        System.out.print(sb);
        br.close();
    }
    private static void solve(int n, int idx, int cnt){
        if(cnt == M){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=n; i<=N; i++) {
            arr[idx] = i;
            solve(i, idx + 1, cnt + 1);
        }
    }
}