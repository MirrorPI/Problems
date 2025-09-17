import java.io.*;
import java.util.*;

public class Main {

    static int[] num = new int[3];
    final static String O = "correct!";
    final static String X = "wrong!";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
           num[i] = Integer.parseInt(st.nextToken());
        }
        String ans = O;
        if(num[0] + num[1] != num[2])  ans = X;

        System.out.print(ans);
    }
}