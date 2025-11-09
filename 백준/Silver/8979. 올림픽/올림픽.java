import java.io.*;
import java.util.*;

public class Main {

    static int N; //국가 수(1~1000)
    static int K; //
    static List<int[]> data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data.add(new int[] {num, g, s, b});
        }
        data.sort((d1, d2) -> {
            if(d1[1] != d2[1]) return Integer.compare(d2[1], d1[1]);
            if(d1[2] != d2[2]) return Integer.compare(d2[2], d1[2]);
            return Integer.compare(d2[3], d1[3]);

        });

        int rank = 1;
        int[] pre = data.get(0);
        if(pre[0] == K) {
            System.out.print(rank);
            return;
        }

        for(int i=1; i<N; i++){
            int[] now = data.get(i);
            if(!(pre[1] == now[1] && pre[2] == now[2] && pre[3] == now[3])) {
                rank = i+1;
            }
            if(now[0] == K) {
                System.out.print(rank);
                return;
            }
            pre = now;
        }
    }
}