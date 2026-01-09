import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //(1<=M<=N<=8)
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    //1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) continue;

            visited[i] = true;
            arr[depth] = i;
            dfs(depth+1);
            visited[i] = false;
        }
    }
}