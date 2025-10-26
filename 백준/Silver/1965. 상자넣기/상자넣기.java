import java.io.*;
import java.util.*;

public class Main {

    static int N; //상자의 개수(1~1000)
    static int[] box; //상자의 번호(1~1000)
    static int[] lisMemo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        box = new int[N];
        lisMemo = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            box[i] = Integer.parseInt(st.nextToken());
        }
        int lisLen = 1;
        int updateIdx = 0;
        lisMemo[lisLen] = box[0];
        for(int i=1; i<N; i++){
            if(box[i] > lisMemo[lisLen]){
                lisLen++;
                lisMemo[lisLen] = box[i];
            } else {
                updateIdx = binarySearch(1, lisLen, box[i]);
                lisMemo[updateIdx] = box[i];
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