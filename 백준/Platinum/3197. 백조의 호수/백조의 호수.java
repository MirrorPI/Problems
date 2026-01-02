import java.io.*;
import java.util.*;

public class Main {

    static int R, C; //행과 열(1~1,500), 최대 2,250,000 칸
    static char[][] map; //'.': 물, 'X' : 얼음, 'L': 백조
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    static int[] p;
    static int day;
    static boolean[][] visited;
    static int[] lPos = new int[2];
    static boolean[][] melted;
    static ArrayDeque<Integer> waters = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int size = R*C;
        map = new char[R][C];
        p = new int[size+1];
        Arrays.fill(p, -1);
        int lCnt = 0;
        for(int x=0; x<R; x++){
            String line = br.readLine();
            for(int y=0; y<C; y++){
                char data = line.charAt(y);
                if(data == 'L') {
                    lPos[lCnt++] = C*x + y + 1;
                    data = '.';
                }
                if(data == '.') {
                    waters.add(C*x+y+1);
                }
                map[x][y] = data;
            }
        }

        visited = new boolean[R][C];
        for(int x=0; x<R; x++){
            for(int y=0; y<C; y++){
                if(visited[x][y] || map[x][y] == 'X') continue;

                unionSameAreaByBfs(x, y);
            }
        }

        while(!(find(lPos[0])==find(lPos[1]))){
            ArrayDeque<Integer> meltedWaters = new ArrayDeque<>();
            melted = new boolean[R][C];
            while(!waters.isEmpty()){
                int idx = waters.poll() - 1;
                int x = idx / C;
                int y = idx % C;
                melt(x, y, meltedWaters);
            }
            waters = meltedWaters;
            day++;
        }

        System.out.print(day);
    }

    static void unionSameAreaByBfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0 || nx>=R || ny<0 || ny>=C || visited[nx][ny] || map[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                union(C*cx+cy+1, C*nx+ny+1);
                q.add(new int[] {nx, ny});
            }
        }
    }
    static int find(int x) {
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }
    static void union(int x, int y) {
        int u = find(x);
        int v = find(y);
        if(u==v) return;

        if(p[u] > p[v]) {
            int t = u;
            u = v;
            v = t;
        } else if(p[u] == p[v]) {
            p[u]--;
        }

        p[v] = u;
    }
    static void melt(int x, int y, ArrayDeque<Integer> meltedWaters) {
        int curWater = C*x+y+1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=R || ny<0 || ny>=C || map[nx][ny] != 'X') continue;

            int nxtWater = C*nx+ny+1;
            map[nx][ny] = '.';
            union(curWater, nxtWater);
            melted[nx][ny] = true;
            meltedWaters.add(nxtWater);


            //*XX* 상황에서 왼쪽 물과 오른쪽 물이 합쳐지지는 코드가 없어서 틀림 -> 녹은 물과 그 주변 물을 합쳐주는 코드
            for(int j=0; j<4; j++){
                int nnx = nx + dx[j];
                int nny = ny + dy[j];
                if(nnx<0 || nnx>=R || nny<0 || nny>=C || map[nnx][nny] == 'X') continue;

                union(nxtWater, C*nnx + nny + 1);
            }
        }
    }
}