import java.io.*;
import java.util.*;

public class Main {

    static int N; //동전의 종류(1~10)
    static int K; //만들어야할 가치(1~100,000,000)
    static int[] A; //각 동전의 가치(1~1,000,000) // 배수 관계, 오름차순
    static int maxIdx;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        for(int i=N-1; i>=0; i--){
            if(A[i] <= K){
                maxIdx = i;
                break;
            }
        }
        for(int i=maxIdx; i>=0; i--){
            ans += K/A[i];
            K = K%A[i];
        }
        System.out.print(ans);
        br.close();
    }
}