import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //(1~300)
    static int[][] arr; //(-10,000~10,000)
    static int[][] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        pre = new int[N+1][M+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + arr[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int ans = pre[x][y] - pre[i-1][y] - pre[x][j-1] + pre[i-1][j-1];
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}