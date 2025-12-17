import java.io.*;
import java.util.*;

public class Main {

    static int N; //도시의 수(1~200)
    static int M; //여행계획에 포함된 도시의 수(1~1000)
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        p = new int[N+1];
        Arrays.fill(p, -1);
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int status = Integer.parseInt(st.nextToken());

                if(i == j || status == 0 || find(i) == find(j)) continue;

                union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int startGroup = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<M; i++){
            int plan = Integer.parseInt(st.nextToken());

            if(startGroup != find(plan)) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }

    public static int find(int x) {
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }

    public static void union(int x, int y){
        int u = find(x);
        int v = find(y);

        if(u == v) return;

        if(p[v] < p[u]){
            int t = u;
            u = v;
            v = t;
        }
        if(p[u] == p[v]) p[u]--;

        p[v] = u;
    }
}