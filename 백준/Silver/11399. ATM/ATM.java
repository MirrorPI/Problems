import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] P;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        for(int i=0; i<N; i++){
            ans += P[i] * (N-i);
        }
        System.out.print(ans);
        br.close();
    }
}