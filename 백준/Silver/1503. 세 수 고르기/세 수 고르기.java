import java.io.*;
import java.util.*;

public class Main {

    static int N; //(1~1000)
    static int S; //집합의 크기(0~50)
    static boolean[] existed; //집합에 존재하는 수
    final static int MAX = Integer.MAX_VALUE;
    static int ans = MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        existed = new boolean[1002];
        if(S>0) st = new StringTokenizer(br.readLine());

        for(int i=0; i<S; i++){
            int num =  Integer.parseInt(st.nextToken());
            existed[num] = true;
        }

        for(int x=1; x<=1000; x++){
            if(existed[x]) continue;
            for(int y=x; y<=1000; y++){
                if(existed[y]) continue;
                for(int z=y; z<=1001; z++){
                    if(existed[z]) continue;
                    ans = Math.min(IN_xyxI(x,y,z), ans);
                }
            }
        }

        System.out.print(ans);
        br.close();
    }

    static int IN_xyxI (int x, int y, int z){
        int result = N - x * y * z;

        if(result < 0) result *= -1;

        return result;
    }
}