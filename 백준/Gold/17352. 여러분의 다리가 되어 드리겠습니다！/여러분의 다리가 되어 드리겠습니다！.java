import java.io.*;
import java.util.*;

public class Main {

    static int N; //(2~300,000)
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        Arrays.fill(p, -1);
        String line;
        int start = 1;
        while((line = br.readLine()) != null){
            if(line.isEmpty()) break;

            StringTokenizer st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
            start = u;
        }
        for(int i=1; i<=N; i++){
            if(find(start) != find(i)){
                sb.append(start).append(" ").append(i);
                break;
            }
        }
        System.out.print(sb);
    }

    public static int find(int x) {
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }
    public static void union(int x, int y){
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