import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String inputA = st.nextToken();
        String inputB = st.nextToken();
        BigInteger A = new BigInteger(inputA);
        BigInteger B = new BigInteger(inputB);
        System.out.print(A.add(B));
    }
}