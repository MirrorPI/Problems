import java.io.*;
import java.util.*;

public class Main {

    static String N;
    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();
        char[] arr = N.toCharArray();
        int sum = 0;
        for(int i=0; i<N.length(); i++){
            int n = N.charAt(i) - '0';
            sum += n;
        }

        StringBuilder sb = new StringBuilder();
        if(sum % 3 == 0) {
            Arrays.sort(arr);
            if(arr[0] == '0') {
                for(int i=N.length()-1; i>=0; i--){
                    sb.append(arr[i]);
                }
            } else {
                System.out.print(-1);
            }
        } else {
            System.out.print(-1);
        }
        System.out.print(sb);
    }
}