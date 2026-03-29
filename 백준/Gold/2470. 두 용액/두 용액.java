import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    final static int INF = Integer.MAX_VALUE;
    static int N;
    static int[] value;
    static int min = INF;
    static int[] answer = new int[2];

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        value = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(value);

        int left = 0;
        int right = N-1;
        while(left < right) {
            int sum = value[left] + value[right];

            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = value[left];
                answer[1] = value[right];
            }

            if(sum < 0) {
                left++;
            } else if(sum > 0) {
                right--;
            } else {
                break;
            }

        }

        sb.append(answer[0]).append(' ').append(answer[1]);
        System.out.print(sb);
    }
}