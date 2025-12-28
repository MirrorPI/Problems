import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~2,000,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                ad.addLast(n);
            } else if(cmd.equals("pop")){
                sb.append(ad.isEmpty() ? -1 : ad.pollFirst()).append("\n");
            } else if(cmd.equals("size")){
                sb.append(ad.size()).append("\n");
            } else if(cmd.equals("empty")){
                sb.append(ad.isEmpty() ? 1 : 0).append("\n");
            } else if(cmd.equals("front")){
                sb.append(ad.isEmpty() ? -1 : ad.peekFirst()).append("\n");
            } else { //back
                sb.append(ad.isEmpty() ? -1 : ad.peekLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}