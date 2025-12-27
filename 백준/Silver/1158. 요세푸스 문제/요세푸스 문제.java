import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~5000
    static int K; //1~N

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            cnt++;
            if(cnt != K){
                q.add(n);
            } else {
                cnt = 0;
                if(q.isEmpty()){
                    sb.append(n).append(">");
                } else {
                    sb.append(n).append(", ");
                }
            }
        }
        System.out.print(sb);
    }
}