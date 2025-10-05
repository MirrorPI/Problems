import java.io.*;
import java.util.*;

public class Main {

    static int K; //랜선의 개수(1~10,000)
    static int N; //필요한 랜선의 개(1,000,000)
    static int[] LANCable; //랜선의 길이(1~2^31-1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        LANCable = new int[K];
        long low = 1;
        long high = 0;
        for(int i=0; i<K; i++){
            LANCable[i] = Integer.parseInt(br.readLine());
            if(high < LANCable[i]) high = LANCable[i];
        }

        long ans = 0;

        while(low <= high){
            long mid = (low + high)/2;
            long pieces = 0;
            for(int len : LANCable){
                pieces += len/mid;
            }
            if(N <= pieces){ //N개보다 많이 만드는 것도 포함
                ans = mid;
                low = mid + 1;
            } else { //조각이 모자라다 = 더 작은 값으로 나눠야한다.
                high = mid - 1;
            }
        }

        System.out.print(ans);

    }
}