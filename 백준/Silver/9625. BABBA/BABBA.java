import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 1;
        for(int i=1; i<N; i++){
            int temp = a;
            a = b;
            b += temp;
        }
        System.out.print(a + " " + b);
    }
}