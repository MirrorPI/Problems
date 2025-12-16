import java.io.*;
import java.util.*;

public class Main {

    static int n; //초기 집합 {0}, {1}, ... {n} (1~1,000,000)
    static int m; //연산 횟수 (1~100,000)
    static int[] p; //부모 노드 배열 (양수 = 부모 노드 번호, 음수 = 루트 노드 and rank)
    static int cmd; //0, a, b -> a, b Union, 1, a, b -> a, b 같은 집합 ? "YES" : "NO"
    static int a, b;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = new int[n+1];
        Arrays.fill(p, -1);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            cmd = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(cmd == 0) {
                union(a, b);
            } else {
                if(find(a) == find(b)){
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.print(sb);
    }

    public static int find(int x){
        if(p[x] < 0) return x; //루트 노드 도달 -> x 그룹

        //return find(p[x]); //경로 압축 적용 X
        return p[x] = find(p[x]); //경로 압축 -> x의 부모의 부모를 업데이트 하면서 나아감.
    }

    //Union by rank 적용
    public static void union(int x, int y){
        int u = find(x); //x의 루트
        int v = find(y); //y의 루트

        if(u == v) { //x 와 y가 이미 같은 집합
            return;
        }

        if(p[v] < p[u]) { //v집합이 더 높은 랭크일 때
            int temp = u;
            u = v;
            v = temp;
            //u가 랭크가 더 클 때 v가 랭크가 더 클 때 나눠서 코드를 작성해도 되지만 아래의 코드를 상황에 따라 다르게 작성해야함
            //그래서 u의 랭크가 더 크거나 같은 상황으로 고정.
        }
        if(p[v] == p[u]) p[u]--; //둘이 같다면 랭크는 하나만 늘어남

        p[v] = u; //랭크가 더 큰 곳에 합쳐지기 때문에 더 큰 곳은 랭크 변화 없음 그리고 더 작은 집합의 루트노드의 부모를 더 큰 집합의 루트 노드로 변경
    }
}