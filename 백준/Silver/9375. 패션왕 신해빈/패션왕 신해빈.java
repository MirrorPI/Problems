import java.io.*;
import java.util.*;

public class Main {

    static int N; //의상 수(0~30)
    static Map<String, Integer> cloths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        cloths = new HashMap<>();
        for(int t=1; t<=T; t++){
            cloths.clear();

            N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String part = st.nextToken();
                cloths.put(part, cloths.getOrDefault(part,0) + 1);
            }
            int ans = 1;
            for(Integer num : cloths.values()) {
                ans *= num+1;
            }
            sb.append(ans-1).append("\n");
        }
        System.out.print(sb);
    }
}