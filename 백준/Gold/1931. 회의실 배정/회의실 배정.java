import java.io.*;
import java.util.*;

public class Main {

    static int N; //회의의 개수(1~100,000)
    static int[][] meetings; //회의 시작, 회의 끝(0~2^31 -1)
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        meetings = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i][0] = s;
            meetings[i][1] = e;
        }
        Arrays.sort(meetings, (m1, m2) -> {
           if(m1[1] == m2[1]){
               return Integer.compare(m1[0], m2[0]);
           } else {
               return Integer.compare(m1[1], m2[1]);
           }
        });
        int prevEnd = meetings[0][1];
        for(int i=1; i<N; i++){
            if(prevEnd <= meetings[i][0]){
                ans += 1;
                prevEnd = meetings[i][1];
            }
        }
        System.out.print(ans);
        br.close();
    }
}