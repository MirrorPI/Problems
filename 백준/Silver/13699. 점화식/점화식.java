import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long[] t = new long[n+1];
        t[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                t[i] += t[i-1-j] * t[j];
            }
        }
        System.out.print(t[n]);
    }
}