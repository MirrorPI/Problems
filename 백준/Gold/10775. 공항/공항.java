import java.io.*;
import java.util.*;

public class Main {

    static int G; //게이트의 수 (1~100,000)
    static int P; //비행기의 수 (1~100,000)
    static int[] p;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        p = new int[G+1];
        for(int i=1; i<=G; i++){
            p[i] = i;
        }
        for(int i=0; i<P; i++){
            int gi = Integer.parseInt(br.readLine()); //i번째 비행기 gi 이하 도킹 가능
            int g = find(gi); //g : 도킹할 숫자, find(gi) : gi 이하 숫자 중 가능한 가장 큰 숫자 찾기
            if(g == 0) break;

            p[g] = find(g-1); // 5 4 3 2 1 순서대로 다 도킹이 된 상태에서 5이하의 숫자가 들어오면 g == 0 으로 탐색 멈춤
            cnt++;
        }
        System.out.print(cnt);
    }

    public static int find(int x) {
        if(p[x] == x) return x;

        return p[x] = find(p[x]);
    }
}