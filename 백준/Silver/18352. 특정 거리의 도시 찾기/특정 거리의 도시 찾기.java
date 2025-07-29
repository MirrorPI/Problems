import java.io.*;
import java.util.*;

public class Main {

    static int N; //도시의 개수 (2~300,000)
    static int M; //도로의 개수 (1~1,000,000)
    static int K; //X에서 K만큼의 거리의 도시를 출력해야함 (1~300,000)
    static int X; //출발 도시
    static List<Integer>[] graph;
    static int[] minD;
    static final int MAX = 1_111_111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        minD = new int[N+1]; Arrays.fill(minD, MAX);
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((cd1, cd2) -> {
            return Integer.compare(cd1[1], cd2[1]);
        });
        pq.offer(new int[] {X, 0});
        minD[X] = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curX = cur[0]; //현재 위치
            int curD = cur[1]; //현재 위치까지 누적 거리 (최소 아님) - 우선순위큐에서 거리가 작은 데이터 부터 꺼냄.
            if(minD[curX] < curD) continue; //현재 위치까지의 누적거리가 현재 위치까지의 저장된 최소 누적거리보다 크면 볼 필요 없음

            for(int nxt : graph[curX]){
                if(minD[nxt] <= curD + 1) continue; //현재 위치까지의 누적거리에서 다음 위치까지 간 누적거리가 다음 위치까지의 저장된 최소 누적거리보다 크거나 같으면 볼 필요 없음
                minD[nxt] = curD + 1;
                pq.offer(new int[] {nxt, minD[nxt]});
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean exist = false;
        for(int i=1; i<=N; i++){
            if(minD[i] == K){
                sb.append(i).append("\n");
                exist = true;
            }
        }
        if(!exist) System.out.print("-1");

        System.out.print(sb);
        br.close();
    }
}