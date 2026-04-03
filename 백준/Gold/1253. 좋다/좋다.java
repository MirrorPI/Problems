import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        solve();
    }


    static int N;
    static int[] arr;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void solve() {
        int count = 0;
        Arrays.sort(arr);
        for(int t=0; t<N; t++){
            int target = arr[t];
            int left = 0;
            int right = N-1;
            while(left < right) {
                if(t == left) {
                    left++;
                    continue;
                }
                if(t == right) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];
                if(sum == target) {
                    count++;
                    break;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.print(count);
    }
}