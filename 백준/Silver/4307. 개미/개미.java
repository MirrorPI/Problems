import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
    }

    static int n; //개미의 수 (1~100,000)
    static int l; //나무의 길이 (1~1,000,000)
    static int[] pos; //개미의 위치
    static StringBuilder sb = new StringBuilder();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            pos = new int[n];
            for(int i=0; i<n; i++) {
                pos[i] = Integer.parseInt(br.readLine());
            }
            solve();
        }
        System.out.print(sb);
        br.close();
    }
    public static void solve() {
        Arrays.sort(pos);
        int max = Math.max(l - pos[0], pos[n-1]);
        int min = 0;
        int mid = l/2;
        for(int i=0; i<n; i++){
            if(pos[i] < mid) {
                min = Math.max(min, pos[i]);
            } else {
                min = Math.max(min, l - pos[i]);
            }
        }
        sb.append(min).append(' ').append(max).append('\n');
    }
}