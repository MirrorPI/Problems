import java.io.*;
import java.util.*;

public class Main {

    static int n; //유저의 수(1~1,000,000)
    static int k; //친구 관계의 수(1~100,000)
    static int m; //구해야하는 쌍의 개(1~100,000)
    static int[] p;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            sb.append("Scenario ").append(t).append(":\n");
            int n = Integer.parseInt(br.readLine());
            p = new int[n];
            Arrays.fill(p, -1);
            int k = Integer.parseInt(br.readLine());
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                union(u, v);
            }
            int m = Integer.parseInt(br.readLine());
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if(find(u) == find(v)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int find(int x){
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }

    public static void union(int x, int y) {
        int u = find(x);
        int v = find(y);
        if(u == v) return;

        if(p[u] > p[v]) {
            int t = u;
            u = v;
            v = t;
        }

        if(p[u] == p[v]) p[u]--;

        p[v] = u;
    }
}