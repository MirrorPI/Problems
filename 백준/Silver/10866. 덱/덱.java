import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~10,000
    static ArrayDeque<Integer> ad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ad = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num;
            if(cmd.equals("push_back")){
                num = Integer.parseInt(st.nextToken());
                ad.addLast(num);
                continue;
            } else if(cmd.equals("push_front")) {
                num = Integer.parseInt(st.nextToken());
                ad.addFirst(num);
                continue;
            } else if(cmd.equals("pop_front")) {
                num = ad.isEmpty() ? -1 : ad.pollFirst();
            } else if(cmd.equals("pop_back")) {
                num = ad.isEmpty() ? -1 : ad.pollLast();
            } else if(cmd.equals("size")) {
                num = ad.size();
            } else if(cmd.equals("empty")) {
                num = ad.isEmpty() ? 1 : 0;
            } else if(cmd.equals("front")) {
                num = ad.isEmpty() ? -1 : ad.peekFirst();
            } else { //back
                num = ad.isEmpty() ? -1 : ad.peekLast();
            }
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}