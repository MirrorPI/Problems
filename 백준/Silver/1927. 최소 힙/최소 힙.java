import java.io.*;
import java.util.*;

public class Main {

    static int N; //연산 횟수(100,000)
    static PriorityQueue<Integer> pq; //1~2^31-1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1, n2);
        });

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(pq.isEmpty()){
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(num);
            }
        }
        System.out.print(sb);
    }
}