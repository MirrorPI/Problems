import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static double a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            a = Double.parseDouble(br.readLine());
            System.out.printf("%.10f\n", a/6);
        }
    }
}