import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static StringBuilder sb = new StringBuilder();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());
            solve(K, str);
        }
        br.close();
    }
    public static void solve(int K, String str) {
        int len = str.length();
        ArrayList<Integer>[] alpha = new ArrayList[26];
        for(int i=0; i<26; i++) {
            alpha[i] = new ArrayList<>();
        }
        for(int i=0; i<len; i++){
            int c = str.charAt(i);
            alpha[c - 'a'].add(i);
        }
        int min = 11111;
        int max = 0;
        for(int i=0; i<26; i++){
            int alphaNum = alpha[i].size();

            if(alphaNum < K) continue;

            for(int j=0; j<=alphaNum-K; j++) {
                int start = alpha[i].get(j);
                int end = alpha[i].get(j+K-1);
                min = Math.min(end - start + 1, min);
                max = Math.max(end - start + 1, max);
            }
        }
        if(min == 11111) {
            sb.append(-1).append('\n');
        } else {
            sb.append(min).append(' ').append(max).append('\n');
        }
    }
}