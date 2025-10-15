import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~500,000
    static int M; //1~500,000
    static HashSet<Integer> sang;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sang = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            sang.add(num);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(sang.contains(num) ? "1 " : "0 ");
        }
        System.out.print(sb);
    }
}