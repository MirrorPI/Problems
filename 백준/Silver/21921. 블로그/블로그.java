import java.io.*;
import java.util.*;

public class Main {

    static int N; //총 일(1~250,000)
    static int X; //구해야하는 구간의 길이(1~N)
    static int[] visitors; //방문자수(0~8000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N+1];
        prefix[0] = 0;
        for(int i=1; i<=N; i++){
            prefix[i] = prefix[i-1] + visitors[i-1];
        }

        int max = 0;
        int cnt = 0;
        for(int i=0; i<=N-X; i++){
            int prefixSum = prefix[i+X] - prefix[i];
            if(prefixSum > max) {
                max = prefixSum;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(max == 0) {
            sb.append("SAD");
        } else {
            for(int i=0; i<=N-X; i++){
                int prefixSum = prefix[i+X] - prefix[i];
                if(prefixSum == max) {
                    cnt++;
                }
            }
            sb.append(max).append("\n");
            sb.append(cnt);
        }
        System.out.print(sb);
    }
}