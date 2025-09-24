import java.io.*;
import java.util.*;

public class Main{

    static int N; //지름길의 개수(1~12)
    static int D; //고속도로의 길이(1~10,000)
    static int[] minD;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        minD = new int[D+1]; Arrays.fill(minD, 11111);
        graph = new ArrayList[D+1];
        for(int i=0; i<=D; i++){
            graph[i] = new ArrayList<>();

            if(i==D) break;
            graph[i].add(new int[] {i+1, 1});
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int shortcutS = Integer.parseInt(st.nextToken());
            int shortcutE = Integer.parseInt(st.nextToken());
            int shortcutD = Integer.parseInt(st.nextToken());
            if(shortcutE > D || shortcutE - shortcutS <= shortcutD) continue;
            graph[shortcutS].add(new int[] {shortcutE, shortcutD});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((w1, w2) ->{
           return Integer.compare(w1[1], w2[1]);
        });
        pq.add(new int[] {0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curX = cur[0];
            int curD = cur[1];
            if(curD > minD[curX]) continue;

            for(int[] next : graph[curX]){
                int nextX = next[0];
                int nextD = next[1];
                if(minD[nextX] <= curD + nextD) continue;

                minD[nextX] = curD + nextD;
                pq.add(new int[] {nextX, minD[nextX]});
            }
        }
        System.out.print(minD[D]);
    }
}