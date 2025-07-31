import java.io.*;
import java.util.*;

public class Main {

    static int N; //노드의 개수(2~10,000)
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       StringBuilder sb = new StringBuilder();

       int T = Integer.parseInt(br.readLine());
       for(int t=1; t<=T; t++){
           N = Integer.parseInt(br.readLine());
           parent = new int[N+1];
           visited = new boolean[N+1];
           for(int i=1; i<=N; i++){
               parent[i] = i; //부모가 있으면 그 부모가 저장되는데 리프노드는 부모가 없음 -> 자기 자신이 부모면 리프노트
           }
           for(int i=0; i<N-1; i++){
               st = new StringTokenizer(br.readLine());
               int u = Integer.parseInt(st.nextToken());
               int v = Integer.parseInt(st.nextToken());
               parent[v] = u; //u가 v의 부모
           }
           st = new StringTokenizer(br.readLine());
           int parentA = Integer.parseInt(st.nextToken());
           int parentB = Integer.parseInt(st.nextToken());
           int ans = 0;
           while(true){
               visited[parentA] = true;
                if(parentA == parent[parentA]) break;

                parentA = parent[parentA];
           }
           while(true){
               if(visited[parentB]) {
                   ans = parentB;
                   break;
               }
               parentB = parent[parentB];
           }
          sb.append(ans).append("\n");
       }
       System.out.print(sb);
       br.close();
    }
}