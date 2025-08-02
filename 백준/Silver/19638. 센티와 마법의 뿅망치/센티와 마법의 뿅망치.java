import java.io.*;
import java.util.*;

public class Main {

    static int N; //센티 제외 인구수 (1~100,000)
    static int H; //센티의 키 (1~2,000,000,000)
    static int T; //뿅망치의 횟수 제한 (1~100,000)
    static int[] h; //거인의 키 (1~2,000,000,000)
    final static String no = "NO";
    final static String yes = "YES";
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((h1, h2) ->{
            return Integer.compare(h2, h1);
        });
        for(int i=0; i<N; i++){
            int height = Integer.parseInt(br.readLine());
            if(height >= H){
               pq.add(height);
            }
        }
        while(!pq.isEmpty()){
            int highest = pq.peek();
            if(highest == 1 || ans == T) break;
            pq.poll();
            if(highest >= H){
                pq.add(highest/2);
                ans += 1;
            }
        }
        if(!pq.isEmpty() && pq.peek() >= H){
            sb.append(no).append("\n").append(pq.peek());
        } else {
            sb.append(yes).append("\n").append(ans);
        }
        System.out.print(sb);
    }
}