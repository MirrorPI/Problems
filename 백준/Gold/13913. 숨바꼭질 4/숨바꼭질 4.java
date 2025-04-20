import java.io.*;
import java.util.*;

public class Main {

    static int N, K; //나의 위치(0~100000), 찾아갈 위치(0~100000)
    static int[] min;
    static int max = 140000; //2x - 100000 <= 100000 - x, x < 70000
    static int[] prev;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        min = new int[max]; Arrays.fill(min, max);
        prev = new int[max]; Arrays.fill(prev, -1);
        solve(N);

        sb.append(min[K]).append("\n");
        List<Integer> path = new ArrayList<>();
        for (int cur = K; cur != -1; cur = prev[cur]) {
            path.add(cur);
        }
        Collections.reverse(path);
        for (int p : path) {
            sb.append(p).append(" ");
        }
        System.out.print(sb);
        br.close();
    }

    private static void solve(int s){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        min[s] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == K) break;
            int[] next = {cur - 1, cur + 1, cur * 2};
            for (int nxt : next) {
                if (nxt >= 0 && nxt < max && min[nxt] > min[cur] + 1) {
                    min[nxt] = min[cur] + 1;
                    prev[nxt] = cur;
                    q.add(nxt);
                }
            }
        }
    }
}