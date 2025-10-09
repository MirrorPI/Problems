import java.io.*;
import java.util.*;

public class Main {

    static int N; //수의 개수(1~1,000,000), 홀수
    static int[] arr; //(-10^9~10^9)
    static int[] ascendingArr;
    static Map<Integer, Integer> compression;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ascendingArr = new int[N];
        compression = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            ascendingArr[i] = num;
        }
        Arrays.sort(ascendingArr);
        int count = 0;
        for(int i=0; i<N; i++){
            if(!compression.containsKey(ascendingArr[i])) {
                compression.put(ascendingArr[i], count++);
            }
        }
        for(int i=0; i<N; i++){
            int newCoordinate = compression.get(arr[i]);
            sb.append(newCoordinate).append(" ");
        }
        System.out.print(sb);
    }
}