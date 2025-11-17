import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //문자열의 개수, 검사해야할 문자열의 개수(1~10000)
    static Set<String> strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        strs = new HashSet<>();
        for(int i=0; i<N; i++){
            strs.add(br.readLine());
        }

        int ans = 0;

        for(int i=0; i<M; i++){
            if(strs.contains(br.readLine())) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}