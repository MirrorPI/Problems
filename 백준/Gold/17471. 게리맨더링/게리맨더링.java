import java.util.*;
import java.io.*;

public class Main {

    static int N; //구역의 수(2~10)
    static int[] pop; //인구수(1~100)
    static boolean[][] connect; //두 구역 연결정보
    static boolean[] selected; //부분집합 선택 정보
    static boolean[] visited; //
    static final int NO = 987654321;
    static int ans = NO;

    public static void main(String[] args) throws IOException{
        init();
        solve();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        connect = new boolean[N+1][N+1];
        selected = new boolean[N+1];
        visited = new boolean[N+1];
        pop = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            pop[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                int v = Integer.parseInt(st.nextToken());
                connect[i][v] = true;
                connect[v][i] = true;
            }
        }
        br.close();
    }
    public static void select(int idx, int cnt){ //부분집합
        if(cnt >= 1 && cnt <N){ //(원소 0개,원소 6개), (6, 0) 제외
            if(check()){
                cal();
            }
        }

        for(int i=idx; i<=N; i++){
            if(selected[i]) continue;
            selected[i] = true;
            select(i, cnt+1);
            selected[i] = false;
        }
    }
    public static boolean check(){ //하나의 선거구 안의 구역들이 전부 연결되어 있는가?
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(selected[i]) A.add(i);
            else B.add(i);
        }
        boolean aState = connectCheck(A, true);
        if(!aState) return false;
        boolean bState = connectCheck(B, false);
        return bState;// A 선거구 B 선거구 모두 연결되었다면 문제없이 나뉘어진 부분집합
    }
    public static boolean connectCheck(List<Integer> state, boolean group){ //부분집합을 나뉜 구역들이 같은 그룹에 묶여있는지 체크
        Arrays.fill(visited, false);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(state.get(0));
        visited[state.get(0)] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=1; i<=N; i++){
                if(connect[cur][i] && !visited[i] && selected[i] == group){ //현재지점과 확인할 지점이 연결되어 있고 방문하지 않고 선택된 그룹과 같은가
                    q.add(i);
                    visited[i] = true;
                    cnt += 1;
                }
            }
        }
        if(cnt == state.size()) return true; //같은 구역에 모두 연결된 갯수가 지금 나뉘어진 부분집합의 크기와 같다면 모두 문제 없이 연결됨
        return false;
    }
    public static void cal(){
        int Asum, Bsum, diff;
        Asum = 0;
        Bsum = 0;
        for(int i=1; i<=N; i++){
            if(selected[i]) Asum += pop[i];
            else Bsum += pop[i];
        }
        diff = Math.abs(Asum - Bsum);
        ans = Math.min(ans, diff);
    }
    public static void solve(){
        select(1, 0);
        if(ans == NO) ans = -1;

        System.out.print(ans);
    }
}