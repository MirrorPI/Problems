import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] lastZero = new long[91];
        long[] lastOne = new long[91];

        lastOne[1] = 1;
        lastZero[1] = 0;
        for(int i=1; i<90; i++){
            lastOne[i+1] = lastZero[i];
            lastZero[i+1] = lastZero[i] + lastOne[i];
        }
        long ans = lastOne[N] + lastZero[N];
        System.out.print(ans);
    }
}