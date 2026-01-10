import java.io.*;
import java.util.*;

public class Main {

    static int N; //행성의 개수(1~100,000)
    static ArrayList<Planet> planets;
    static ArrayList<Edge> edges;
    static int[] p;
    static class Planet {
        int i;
        long x;
        long y;
        long z;
        Planet(int i, long x, long y, long z){
            this.i = i;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Edge {
        int u;
        int v;
        long w;
        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        planets = new ArrayList<>();
        edges = new ArrayList<>();
        p = new int[N]; Arrays.fill(p, -1);
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(i, x, y, z));
        }

        //x 정렬
        planets.sort((p1, p2) -> {
            return Long.compare(p1.x, p2.x);
        });
        for(int i=0; i<N-1; i++){
            int u = planets.get(i).i;
            int v = planets.get(i+1).i;
            long ux = planets.get(i).x;
            long vx = planets.get(i+1).x;
            edges.add(new Edge(u, v, vx-ux));
        }

        //y 정렬
        planets.sort((p1, p2) -> {
            return Long.compare(p1.y, p2.y);
        });
        for(int i=0; i<N-1; i++){
            int u = planets.get(i).i;
            int v = planets.get(i+1).i;
            long uy = planets.get(i).y;
            long vy = planets.get(i+1).y;
            edges.add(new Edge(u, v, vy-uy));
        }

        //z 정렬
        planets.sort((p1, p2) -> {
            return Long.compare(p1.z, p2.z);
        });
        for(int i=0; i<N-1; i++){
            int u = planets.get(i).i;
            int v = planets.get(i+1).i;
            long uz = planets.get(i).z;
            long vz = planets.get(i+1).z;
            edges.add(new Edge(u, v, vz-uz));
        }
        edges.sort((e1, e2) -> {
            return Long.compare(e1.w, e2.w);
        });

        long ans = 0L;
        for(Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            long w = edge.w;

            if(find(u) != find(v)) {
                ans += w;
                union(u, v);
            }
        }
        System.out.print(ans);
    }

    public static int find(int x){
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