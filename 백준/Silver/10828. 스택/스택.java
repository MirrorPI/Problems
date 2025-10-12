import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayDeque<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        stack = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.addLast(num);
            } else if(cmd.equals("pop")){
                if(stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.pollLast()).append("\n");
            } else if(cmd.equals("top")){
                if(stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.peekLast()).append("\n");
            } else if(cmd.equals("size")){
                sb.append(stack.size()).append("\n");
            } else {
                sb.append(stack.isEmpty() ? "1\n" : "0\n");
            }
        }
        System.out.print(sb);
    }
}