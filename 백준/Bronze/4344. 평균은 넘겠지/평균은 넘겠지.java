import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] point;
    static double total;
    static int goodStudent;
    static double avg;
    static double ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            total = 0;
            goodStudent = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            point = new int[N];
            for(int i=0; i<N; i++){
                point[i] = Integer.parseInt(st.nextToken());
                total += point[i];
            }
            avg = total/N;
            for(int i=0; i<N; i++){
                if(point[i] > avg){
                    goodStudent += 1;
                }
            }
            ans = (double)goodStudent / N * 100;
            System.out.printf("%.3f%%\n", ans);
        }
    }
}