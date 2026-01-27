import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //가로, 세로 (1~1,000)
    static char[][] map; //1: 벽, 0: 빈칸
    static int[] p;
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    static int[][] ans;
    static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        p = new int[N*M]; //0~NM-1
        ans = new int[N][M];
        Arrays.fill(p, -1);
        for(int x=0; x<N; x++){
            String line = br.readLine();
            for(int y=0; y<M; y++){
                map[x][y] = line.charAt(y);
            }
        }
    }
    public static void solve() {
            for(int x=0; x<N; x++){
                for(int y=0; y<M; y++){
                    if(map[x][y] == '0'){
                        zeroUnion(x, y);
                    }
                }
            }
        StringBuilder sb = new StringBuilder(N*M);
        for(int x=0; x<N; x++){
            for(int y=0; y<M; y++){
                sb.append(map[x][y] == '0' ? 0 : count(x, y));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static void zeroUnion(int x, int y){
            int standard = x*M + y;
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                int near = nx*M+ny;
                if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] != '0') continue;

                union(standard, near);
            }
        }
    public static int count(int x, int y){
        HashSet<Integer> groupNearWall = new HashSet<>();
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == '1') continue;

            groupNearWall.add(find(nx*M+ny));
        }
        int cnt = 1;
        for(int num : groupNearWall){
            cnt -= p[num];
        }
        return cnt%10;
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

        p[u] += p[v];
        p[v] = u;
    }
}