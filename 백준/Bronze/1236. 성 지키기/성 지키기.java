import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //세로, 가로(1~50)
    static boolean[] vertical;
    static boolean[] horizontal;
    final static char BLANK = '.';
    final static char GUARD = 'X';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        vertical = new boolean[N];
        horizontal = new boolean[M];

        for(int x=0; x<N; x++){
            String line = br.readLine();
            for(int y=0; y<M; y++){
                char data = line.charAt(y);
                if(data == GUARD){
                    vertical[x] = true; //세로 x 줄에 경호원이 있다.
                    horizontal[y] = true; //가로 y 줄에 경호원이 있다.
                }
            }
        }
        int verticalNum = 0; //세로줄에 필요한 경호원 수
        int horizontalNum = 0; //가로줄에 필요한 경호원 수
        int ans;
        for(int x=0; x<N; x++){
            if(!vertical[x]) verticalNum++;
        }
        for(int y=0; y<M; y++){
            if(!horizontal[y]) horizontalNum++;
        }
        //가로줄에 경호원이 필요하다면 가로줄을 채우면서 원하는 세로줄도 같이 채울 수 있음
        //그래서 더 많이 필요한 줄로 더 적게 필요한 줄을 채워줄 수 있기에 둘 중 최댓값이 가로 세로 모든 줄에 필요한 최소 경호원 수
        ans = Math.max(verticalNum, horizontalNum);
        System.out.print(ans);

    }
}