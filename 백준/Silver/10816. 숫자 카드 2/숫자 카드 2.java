import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //상근이 카드 개수, 확인할 카드 개수 (500,000)
    static Map<Integer, Integer> sanguen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sanguen = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(sanguen.containsKey(num)){
                sanguen.put(num, sanguen.get(num) + 1);
            } else {
                sanguen.put(num, 1);
            }
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            int haveNum = sanguen.getOrDefault(num, 0);
            sb.append(haveNum).append(' ');
        }

        System.out.print(sb);
    }
}