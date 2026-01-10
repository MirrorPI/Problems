import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //1~8;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        combination(0, 1);

        System.out.print(sb);
    }

    public static void combination(int depth, int start) {
        if(depth == M) {
            for(int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        if(start > N) return;

        arr[depth] = start;
        combination(depth + 1, start + 1);

        combination(depth, start+1);
    }
}