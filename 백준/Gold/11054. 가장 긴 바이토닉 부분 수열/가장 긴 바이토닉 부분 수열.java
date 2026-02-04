import java.io.*;
import java.util.*;

public class Main {

    static int N; //수열의 길이(1~1,000)
    static int[] arr; //(1~1,000)
    static int[] inDp;
    static int[] deDp;

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        inDp = new int[N]; Arrays.fill(inDp, 1);
        deDp = new int[N]; Arrays.fill(deDp, 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solve() {
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]) {
                    inDp[i] = Math.max(inDp[i], inDp[j] + 1);
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>i; j--){
                if(arr[i] > arr[j]) {
                    deDp[i] = Math.max(deDp[i], deDp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, inDp[i] + deDp[i]);
            //System.out.println(inDp[i] +" "+ deDp[i]);
        }
        System.out.print(max-1);
    }
}