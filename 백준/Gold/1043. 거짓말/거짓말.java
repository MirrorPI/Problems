import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //사람의 수 (1~50), 파티의 수 (1~50)
    static int T; //진실을 아는 사람의 수
    static int party; //파티에 오는 사람의 수
    static int[] p;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        Arrays.fill(p, -1);
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            union(0, Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer>[] partiesMems = new ArrayList[M];
        for(int i=0; i<M; i++) {
            partiesMems[i] = new ArrayList<>();
        }
        boolean[] isKnown = new boolean[M];
        for(int i=0; i<M; i++){ //앞서 거짓말 한 파티의 다른 파티원은 다 거짓말 그룹으로 묶어야함 -> 뒤쪽 파티에서 거짓말을 들어도 앞쪽 파티에서 거짓말을 하는 사람으로 업데이트 해줘야함
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            partiesMems[i].add(a);
            for(int j=1; j<num; j++){
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
                partiesMems[i].add(b);
            }
        }
        for(int i=0; i<M; i++){
            for(int n : partiesMems[i]) {
                if(find(0) == find(n)) {
                    isKnown[i] = true;
                    break;
                }
            }
        }

        for(int i=0; i<M; i++){
            if(isKnown[i]) continue;

            cnt++;
        }

        System.out.print(cnt);
    }

    public static int find(int x) {
        if(p[x] < 0) return x;

        return p[x] = find(p[x]);
    }

    public static void union(int x, int y) {
        int u = find(x);
        int v = find(y);

        if(u == v) return;

        if(p[v] < p[u]) {
            int t = u;
            u = v;
            v = t;
        }
        if(p[u] == p[v]) p[u]--;

        p[v] = u;
    }
}