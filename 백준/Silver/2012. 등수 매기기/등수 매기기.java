import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    static int N; //사람수(1~500,000)
    static int[] expectedRank;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expectedRank = new int[N];
        for(int i=0; i<N; i++){
            expectedRank[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }
    public static void solve() {
        Arrays.sort(expectedRank);
        long sum = 0;
        for(int i=0; i<N; i++){
            sum += Math.abs(expectedRank[i] - (i+1));
        }
        System.out.print(sum);
    }
}