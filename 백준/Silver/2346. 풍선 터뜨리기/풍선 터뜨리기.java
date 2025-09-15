import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~1,000
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dq.addLast(new int[] {num, i});
        }

        while(!dq.isEmpty()){
            int[] balloon = dq.pollFirst();
            int num = balloon[0];
            int index = balloon[1];
            sb.append(index).append(" ");

            if(dq.isEmpty()) break;

            for(int i=1; i<num; i++){
                dq.addLast(dq.pollFirst());
            }
            for(int i=0; i>num; i--){
                dq.addFirst(dq.pollLast());
            }
        }
        System.out.print(sb);
    }
}