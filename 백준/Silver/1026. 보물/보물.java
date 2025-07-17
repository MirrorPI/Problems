import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] A;
    static int[] B;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0; i<N; i++){
            ans += A[i] * B[N-1-i];
        }
        System.out.print(ans);
        br.close();
    }
}