import java.io.*;
import java.util.*;

public class Main {

    static int back;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            back = 1;
        } else {
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for(int i=1; i<=N; i++){
                dq.addLast(i);
            }
            while(true){
                dq.pollFirst();
                back = dq.pollFirst();
                if(dq.isEmpty()) break;
                dq.addLast(back);
            }
        }
        System.out.print(back);
        br.close();
    }
}