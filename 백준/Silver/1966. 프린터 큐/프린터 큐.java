import java.io.*;
import java.util.*;

public class Main {

    static int N; //문서의 개수(1~100)
    static int M; //궁금한 문서의 현재 위치(0~N-1)
    static int[] priority; //중요도

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Queue<int[]> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int[] order = new int[N];
            for(int i=0; i<N; i++){
                int p = Integer.parseInt(st.nextToken());
                q.add(new int[] {i, p});
                order[i] = p;
            }
            Arrays.sort(order);

            int cnt = 1;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                
                if(order[N-cnt] == cur[1]) {
                    if(cur[0] == M) break;
                    cnt++;
                } else {
                    q.add(cur);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}