import java.io.*;
import java.util.*;

public class Main {

    static int N; //qs 수열의 길이 (100,000)
    static int M; //삽입할 수열의 길이 (1~100,000)
    static int[] type;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        type = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            type[i] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(type[i] == 0){
                nums.addFirst(num);
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            nums.addLast(num);
        }
        for(int i=0; i<M; i++){
            sb.append(nums.pollFirst()).append(" ");
        }
        System.out.print(sb);
    }
}