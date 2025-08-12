import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        BigInteger[] qr = A.divideAndRemainder(B);
        BigInteger q = qr[0];
        BigInteger r = qr[1];

        System.out.println(q);
        System.out.println(r);
    }
}