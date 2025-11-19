import java.io.*;
import java.util.*;

public class Main {

    static int N; //주어지는 포켓몬 수
    static int M; //맞춰야하는 문제 수
    static Map<String, Integer> poketmons;
    static String[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        poketmons = new HashMap<>();
        nums = new String[N+1];
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            poketmons.put(name, i);
            nums[i] = name;
        }
        for(int j=0; j<M; j++){
            String q = br.readLine();
            char first = q.charAt(0);
            if(first <= '9' && first >= 1) {
                sb.append(nums[Integer.parseInt(q)]).append("\n");
            } else {
                sb.append(poketmons.get(q)).append("\n");
            }
        }
        System.out.print(sb);
    }
}