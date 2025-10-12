import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayDeque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.addLast(num);
            } else if(cmd.equals("pop")){
                if(queue.isEmpty()) sb.append("-1\n");
                else sb.append(queue.pollFirst()).append("\n");
            } else if(cmd.equals("front")){
                if(queue.isEmpty()) sb.append("-1\n");
                else sb.append(queue.peekFirst()).append("\n");
            }  else if(cmd.equals("back")){
                if(queue.isEmpty()) sb.append("-1\n");
                else sb.append(queue.peekLast()).append("\n");
            } else if(cmd.equals("size")){
                sb.append(queue.size()).append("\n");
            } else {
                sb.append(queue.isEmpty() ? "1\n" : "0\n");
            }
        }
        System.out.print(sb);
    }
}