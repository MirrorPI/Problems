import java.io.*;
import java.util.*;

public class Main {

    static int N; //수열의 길이(1~1,000,000)
    static int[] arr; //수열(-1,000,000,000~1,000,000,000)
    static int[] lisMemo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lisMemo = new int[N+1]; Arrays.fill(lisMemo, -1_000_000_000);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lisLen = 1;
        int updateIdx = 0;
        lisMemo[lisLen] = arr[0];
        for(int i=1; i<N; i++){
            if(arr[i] > lisMemo[lisLen]){
                lisLen++;
                lisMemo[lisLen] = arr[i];
            } else {
                updateIdx = binarySearch(1, lisLen, arr[i]);
                lisMemo[updateIdx] = arr[i];
            }
        }
        System.out.print(lisLen);
    }

    public static int binarySearch(int s, int e, int num){
        int mid;

        while(s<e){
            mid = (s+e)/2;
            if(lisMemo[mid] < num){
                s = mid+1;
            } else {
                e = mid;
            }
        }
        return e;
    }
}