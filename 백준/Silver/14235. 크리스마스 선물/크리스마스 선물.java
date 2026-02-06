import java.io.*;
import java.util.*;

public class Main {

    static int n; //방문 횟수, (1~5,000)
    static int a; //거점지 도착시 충전할 선물의 개수(1~100)
    static PriorityQueue<Integer> gift; //선물의 가치(1~100,000)


    public static void main(String[] args) throws Exception {
        solve();
    }
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(2*n);
        gift = new PriorityQueue<>((g1, g2) -> {
            return Integer.compare(g2, g1);
        });
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a == 0) {
                sb.append(gift.isEmpty() ? -1 : gift.poll()).append('\n');
            } else {
                for(int j=0; j<a; j++){
                    gift.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.print(sb);
    }
}