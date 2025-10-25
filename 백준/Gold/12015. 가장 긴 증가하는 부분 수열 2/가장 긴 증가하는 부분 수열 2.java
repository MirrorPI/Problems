import java.io.*;
import java.util.*;

public class Main {

    static int N; //수열의 길이(1~1,000,000)
    static int[] arr;
    static int[] lisMemo; //lis의 길이를 구하기 위해 증가 수열 저장, -> 최종 lis 가 남지 않을 수 있음

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        lisMemo = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lisLen = 0; //lis의 길이
        int updateIdx = 0; //lisMemo에 저장된 수열에서 arr의 숫자가 저장 혹은 업데이트 될 위치
        for(int i=0; i<N; i++){
            if(arr[i] > lisMemo[lisLen]) {
                lisLen++;
                lisMemo[lisLen] = arr[i];
            } else {
                updateIdx = binarySearch(0, lisLen, arr[i]);
                lisMemo[updateIdx] = arr[i];
            }
        }
        System.out.print(lisLen);
    }
    public static int binarySearch(int s, int e, int num){
        int mid = 0;
        while(s < e){
            mid = (s+e)/2;
            if(lisMemo[mid] < num){
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return e;
    }
}