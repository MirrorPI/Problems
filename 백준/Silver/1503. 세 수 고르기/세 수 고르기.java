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
                //집합의 숫자가 1000이하인 자연수이지 x, y, z가 1000이하라는 소리가 아니다.
                //N의 최대가 1000일 때 999, 1000이라는 숫자가 집합에 있다면
                //x y z = 1 1 1001 인 상황이 최소가 됨.
                //1001까지인 이유는 집합에서 제외할 숫자의 한계가 1000이고 N의 최댓값도 1000이기 때문에
                //더 커지는 것은 의미없음
                for(int z=y; z<=1001; z++){
                    if(existed[z]) continue;
                    ans = Math.min(IN_xyxI(x,y,z), ans);

                    //계산 값이 0 보다 작아진 시점에서 계산 값이 더 커지는 것은 의미없음.
                    if(N - x * y * z < 0) break;
                }
                if(N - x * y < 0) break;
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