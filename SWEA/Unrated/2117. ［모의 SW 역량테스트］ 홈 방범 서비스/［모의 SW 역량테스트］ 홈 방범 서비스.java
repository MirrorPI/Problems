import java.io.*;
import java.util.*;

public class Solution {

    static int N, M; //지도의 크기(5~20), 한집당 낼 수 있는 비용
    static int[][] map; //1: 집
    static List<int[]> home = new ArrayList<>();
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1){
                        home.add(new int[] {i, j});
                    }
                }
            }
            max = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    solve(i, j);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
            home.clear();
        }
        System.out.print(sb);
    }
    public static void solve(int x, int y){
        int k = 1;
        while(true){
            int homes = nearHome(x, y, k);
            int profit = M * homes - cost(k);
            if(profit >= 0){
                max = Math.max(max, homes);
            }
            k++;
            if(homes == home.size()) break;
        }
    }
    public static int cost(int k){
        return 2*k*k - 2*k + 1;
    }
    public static int nearHome(int x, int y, int k){
        int count = 0;
        for(int[] h : home){
            int distX = Math.abs(x - h[0]);
            int distY = Math.abs(y - h[1]);
            int manDis = distX + distY;
            if(manDis <= k-1){
                count += 1;
            }
        }
        return count;
    }
}