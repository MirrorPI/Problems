import java.io.*;
import java.util.*;

public class Main {

    static int N; //수열의 길이(1~1000)
    static int[] arr; //수열(1~1000)
    static int[] decCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        decCnt = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(decCnt, 1);
        for(int i=0; i<N-1; i++){
            int base = arr[i];
            for(int j=i+1; j<N; j++){
                if(base > arr[j]) {
                    decCnt[j] = Math.max(decCnt[j], decCnt[i] + 1);
                } else if (base == arr[j]) {
                    decCnt[j] = Math.max(decCnt[j], decCnt[i]);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(decCnt[i], ans);
        }
        System.out.print(ans);
    }
}