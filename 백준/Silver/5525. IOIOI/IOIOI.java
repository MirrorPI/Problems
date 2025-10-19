import java.io.*;
import java.util.*;

public class Main {

    static int N; //문자열 PN (1~1,000,000)
    static int M; //S의 길이(2N+1~1,000,000)
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //"I" + "OI" * N
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        int n = 0; //"OI"의 개수
        int cnt = 0; //S에 있는 PN의 개수
        for(int i=0; i<M-2; i++){
            if(S.charAt(i) == 'I') { //비교 시작
                n = 0;
                while(i+2 < M) {
                    if(S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I'){
                        n += 1;
                        i = i+2;
                    } else break;
                }
                if(n-N+1 > 0){
                    cnt += n-N+1;
                }
            }
        }
        System.out.print(cnt);
    }
}