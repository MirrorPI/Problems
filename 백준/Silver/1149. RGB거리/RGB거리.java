import java.io.*;
import java.util.*;

public class Main{

    static int N; //집의 개수(2~1,000)
    static int[][] cost; //i 번째 집 R, G, B 비용
    static int[][] minCost;
    final static int R = 0;
    final static int G = 1;
    final static int B = 2;
    final static int MAX = 1<<30;
    static int ans = MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        minCost = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int color=0; color<3; color++){
                cost[i][color] = Integer.parseInt(st.nextToken());
            }
        }
        minCost[0][R] = cost[0][R];
        minCost[0][G] = cost[0][G];
        minCost[0][B] = cost[0][B];
        for(int i=1; i<N; i++){
            minCost[i][R] = Math.min(minCost[i-1][G], minCost[i-1][B]) + cost[i][R];
            minCost[i][G] = Math.min(minCost[i-1][B], minCost[i-1][R]) + cost[i][G];
            minCost[i][B] = Math.min(minCost[i-1][R], minCost[i-1][G]) + cost[i][B];
        }
        for(int i=0; i<3; i++){
            ans = Math.min(ans, minCost[N-1][i]);
        }
        System.out.print(ans);
        br.close();
    }
}