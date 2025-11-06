import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        String ans;
        long temp = N % 7;
        if(temp == 2 || temp == 0){
            ans = "CY";
        } else {
            ans = "SK";
        }
        System.out.print(ans);
    }
}