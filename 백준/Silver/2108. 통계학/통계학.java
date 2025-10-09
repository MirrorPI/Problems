import java.io.*;
import java.util.*;

public class Main {

    static int N; //수의 개수(1~500,000), 홀수
    static int[] arr; //-4000~4000
    static int[] count; //0~8000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        count = new int[8001];
        int sum = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
            count[num+4000]++;
        }
        Arrays.sort(arr);
        int average = (int)Math.round((double)sum / N);
        sb.append(average).append("\n");

        int median = arr[N/2];
        sb.append(median).append("\n");

        int mode = 0;
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for(int cnt : count){
            if(max < cnt) max = cnt;
        }
        for(int i=0; i<count.length; i++){
            if(count[i] == max) {
                list.add(i-4000);
            }
        }
        Collections.sort(list);
        mode = list.size()>=2 ? list.get(1) : list.get(0);
        sb.append(mode).append("\n");

        int range = arr[N-1] - arr[0];
        sb.append(range).append("\n");

        System.out.print(sb);
    }
}