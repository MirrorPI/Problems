import java.io.*;
import java.util.*;

public class Main {

    static int N; //(1~100,000)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n2, n1);
        });
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.add(num);
            }
        }
        System.out.print(sb);
    }
}