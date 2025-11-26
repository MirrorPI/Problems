import java.io.*;
import java.util.*;

public class Main {

    static int N; //수열의 길이(1~1,000,000)
    static int M; //M으로 나누어 떨어지는 구간합을 구해야함(2~1,000)
    static int[] arr; //(0~1,000,000,000)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long[] remainCnt = new long[M];
        for(int i=0; i<N; i++){
            sum += arr[i];
            int r = (int)(sum % M);
            remainCnt[r]++;
        }
        long ans = remainCnt[0];
        for(int i=0; i<M; i++){
            if(remainCnt[i] >= 2){
                ans += (remainCnt[i] * (remainCnt[i] - 1))/2;
            }
        }
        System.out.print(ans);
    }
}