import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~1000
    static int K;
    static ArrayDeque<Integer> ad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ad = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            ad.addLast(i);
        }
        sb.append("<");
        while(!ad.isEmpty()){
            for(int i=0; i<K-1; i++){
                ad.addLast(ad.pollFirst());
            }
            sb.append(ad.pollFirst());
            if(!ad.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.print(sb);
    }

}