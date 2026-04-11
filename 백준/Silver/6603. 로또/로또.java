import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
    }

    static int[] nums;
    static int[] selected = new int[6];
    final static StringBuilder sb = new StringBuilder();
    static int k;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            nums = new int[k];
            if(k == 0) {
                System.out.print(sb);
                break;
            }

            for(int i=0; i<k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            solve(0, 0);
            sb.append('\n');
        }

    }
    public static void solve(int start, int depth) {
        if(depth == 6) {
            for(int i=0; i<6; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=start; i<k; i++) {
            selected[depth] = nums[i];
            solve(i+1, depth+1);
        }
    }
}