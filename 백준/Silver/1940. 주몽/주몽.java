import java.io.*;
import java.util.*;

public class Main {

    static int N; //재료의 개수(1~15,000)  N^2 = 225,000,000
    static int M; //갑옷의 기준(1~10,000,000)
    static boolean[] uniqueNum; //(1~100,000)
    final static int max = 100_001;
    static int cnt;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        uniqueNum = new boolean[max];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            uniqueNum[Integer.parseInt(st.nextToken())] = true;
        }
    }
    public static void solve() {
        for(int i=1; i<max; i++){
            int remain = M-i;
            if(!uniqueNum[i] || remain <= 0 || remain >= max) continue;

            if(uniqueNum[remain]) cnt++;
        }

        System.out.print(cnt/2);
    }
}