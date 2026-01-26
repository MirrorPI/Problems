import java.io.*;
import java.util.*;

public class Main {

    final static int INF = Integer.MAX_VALUE;
    static int N; //용액의 수(2~100,000)
    static int[] value; //(-1,000,000,000~1,000,000,000)
    static int min = INF;
    static int[] addNearZeroNum = new int[2];

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        value = new int[N];
        for(int i=0; i<N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void solve() {
        int left = 0;
        int right = N-1;
        addNearZeroNum = new int[2];

        while(left < right) {
            int sum = value[left] + value[right];

            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                addNearZeroNum[0] = value[left];
                addNearZeroNum[1] = value[right];
            }

            if(sum < 0) {
                left++;
            } else if(sum > 0){
                right--;
            } else {
                break;
            }
        }

        System.out.print(addNearZeroNum[0] + " " + addNearZeroNum[1]);
    }
}