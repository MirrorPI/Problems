import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int ans;
    final static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        input();

        sb.append((1<<N)-1).append('\n');
        hanoi(N, 1, 2, 3);
        System.out.print(sb);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        br.close();
    }
    public static void hanoi(int n, int from, int via, int to) {
        if(n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }
        hanoi(n-1, from, to, via);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(n-1, via, from, to);
    }
}