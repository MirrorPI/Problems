import java.io.*;
import java.util.*;

public class Main {

    static int N; //지원자 (1~100,000)
    static List<int[]> rank;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            rank = new ArrayList<>();
            check = new boolean[N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                rank.add(new int[] {first, second});
            }
            rank.sort((r1, r2) -> {
                return Integer.compare(r1[0], r2[0]);
            });
            int ans = 1;
            int min = rank.get(0)[1];
            for(int i=1; i<N; i++){
                if(min > rank.get(i)[1]) {
                    ans ++;
                    min = rank.get(i)[1];
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}