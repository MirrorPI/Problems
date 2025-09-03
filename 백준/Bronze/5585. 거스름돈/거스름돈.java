import java.io.*;
import java.util.*;

public class Main {

    static int pay; //지불할 돈 (1~999)
    static int ans;
    static int[] coin = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pay = Integer.parseInt(br.readLine());
        int remain = 1000 - pay;
        for(int i=0; i<coin.length; i++){
            ans += remain/coin[i];
            remain %= coin[i];
        }
        System.out.print(ans);
        br.close();
    }
}