import java.io.*;
import java.util.*;

public class Main {

    static int N; //(1~500,000)
    static String balls;
    static int min = 555_555;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balls = br.readLine();

        count('L', 'R');
        count('L', 'B');
        count('R', 'R');
        count('R', 'B');

        System.out.print(min);
    }

    public static void count(char dir, char color) {
        int cnt = 0;
        if(dir == 'L') {
            int start = 0;
            while(start<N && balls.charAt(start) == color) start++;

            for(int i=start; i<N; i++){
                char now = balls.charAt(i);
                if(now == color){
                    cnt++;
                }
            }
        } else {
            int start = N-1;
            while(start>=0 && balls.charAt(start) == color) start--;

            for(int i=start; i>=0; i--){
                char now = balls.charAt(i);
                if(now == color){
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);
    }
}