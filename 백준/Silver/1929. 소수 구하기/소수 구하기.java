import java.io.*;
import java.util.*;

public class Main {

    static int M, N;//M이상 N이하 소수 구하기(1~100,000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[N+1];
        isNotPrime[1] = true;

        for(int i=2; i*i<=N; i++){
            if(isNotPrime[i]) continue;

            for(int j=i*i; j<=N; j+=i){ //i의 배수 삭제, 제곱부터하는 이유는 i에게 i보다 작은 수가 곱해진 배수는 이미 삭제됨
                isNotPrime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++){
            if(isNotPrime[i]) continue;

            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}