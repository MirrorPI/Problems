import java.io.*;
import java.util.*;

public class Main {

    final static String no = "No";
    final static String yes = "Yes";
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0){
                break;
            }
            if(N > M){
                sb.append(yes).append("\n");
            }else{
                sb.append(no).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}