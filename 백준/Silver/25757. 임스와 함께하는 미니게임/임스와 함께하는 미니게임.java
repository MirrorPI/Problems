import java.io.*;
import java.util.*;

public class Main {

    static int N; //신청횟수 (1~100,000)
    static String gameType;
    static HashSet<String> names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        gameType = st.nextToken();
        names = new HashSet<>();
        for(int i=0; i<N; i++){
            names.add(br.readLine());
        }
        int num = names.size();
        int ans = 0;
        if(gameType.equals("Y")){
            ans = num;
        }else if(gameType.equals("F")) {
            ans = num/2;
        } else {
            ans = num/3;
        }

        System.out.print(ans);
    }
}