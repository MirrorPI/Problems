import java.io.*;
import java.util.*;

public class Main {

    static int N; //상자의 개수(1~1,000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.print(N%2==0 ? "CY" : "SK");
    }
}