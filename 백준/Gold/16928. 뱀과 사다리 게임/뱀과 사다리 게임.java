import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //사다리, 뱀의 개수(1~15)
    static int[] minDiceCnt;
    static ArrayList<Integer>[] edge;
    static ArrayDeque<int[]> q;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minDiceCnt = new int[101];
        edge = new ArrayList[101];
        for(int i=0; i<101; i++){
            edge[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edge[x].add(y);
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edge[u].add(v);
        }
        q = new ArrayDeque<>();
        q.add(new int[] {1, 0});
        minDiceCnt[1] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int curCnt = cur[1];
            for(int i=1; i<=6; i++){
                int nxt = x + i;
                if(nxt>100) break;
                if(minDiceCnt[nxt] != 0) continue;


                minDiceCnt[nxt] = curCnt+1;
                if(!edge[nxt].isEmpty()){
                    if(minDiceCnt[edge[nxt].get(0)] != 0) continue;

                    q.add(new int[] {edge[nxt].get(0), curCnt+1});
                    minDiceCnt[edge[nxt].get(0)] = curCnt+1;
                } else {
                    q.add(new int[] {nxt, curCnt+1});
                }
            }
        }
        System.out.print(minDiceCnt[100]);
    }
}