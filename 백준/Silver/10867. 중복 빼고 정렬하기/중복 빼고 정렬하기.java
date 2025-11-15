import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~100,000
    static boolean[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = new boolean[2001];
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            nums[n+1000] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=2000; i++){
            if(nums[i]) sb.append(i-1000).append(" ");
        }
        System.out.print(sb);
    }
}