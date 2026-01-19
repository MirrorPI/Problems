import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solve(0, 0);
        System.out.print(sb);

    }
    public static void solve(int depth, int start) {
        if(depth == M) {
            for(int num : ans){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++){

            ans[depth] = arr[i];
            solve(depth+1, i+1);
        }
    }
}