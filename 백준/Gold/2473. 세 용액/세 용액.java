import java.io.*;
import java.util.*;

public class Main {

    static int N; //용액의 수 (3~5,000)
    static long[] value; //(-1,000,000,000~1,000,000,000)
    final static long INF = Long.MAX_VALUE;
    static long min = INF;
    static long[] nearZeroNum = new long[3];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        value = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void solve() {
        Arrays.sort(value);

        for(int i=0; i<N-2; i++){
            int left = i+1;
            int right = N-1;
            while(left < right){
                long sum = value[i] + value[left] + value[right];

                if(Math.abs(sum) < min) {
                    nearZeroNum[0] = value[i];
                    nearZeroNum[1] = value[left];
                    nearZeroNum[2] = value[right];
                    min = Math.abs(sum);
                }

                if(sum < 0) {
                    left++;
                } else if (sum > 0){
                    right--;
                } else {
                    return;
                }
            }
        }
    }
    public static void output() {
        for(int i=0; i<3; i++){
            sb.append(nearZeroNum[i]).append(' ');
        }
        System.out.print(sb);
    }
}