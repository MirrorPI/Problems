import java.io.*;
import java.util.*;

public class Main {

    static int N; //건물의 종류 수(1~500)
    static int[] time; //각 건물의 완성 시간 (1~100,000)
    static int[] in; //진입차수
    static int[] minTime; //각 건물의 완성되기까지 최소 시간.
    static ArrayList<Integer>[] graph;
    static ArrayDeque<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        time = new int[N+1];
        in = new int[N+1];
        minTime = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            minTime[i] = t;
            while(true){
                int pre = Integer.parseInt(st.nextToken());
                if(pre == -1) break;

                graph[pre].add(i);
                in[i]++;
            }
        }

        q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(in[i] == 0) {
                q.addLast(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.pollFirst();

            for(int next : graph[cur]){
                in[next] -= 1;
                minTime[next] = Math.max(minTime[next], minTime[cur] + time[next]);
                if(in[next] == 0){
                    q.addLast(next);
                }
            }
        }
        for(int i=1; i<=N; i++){
            sb.append(minTime[i]).append("\n");
        }
        System.out.print(sb);
    }
}