import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static int zero, one;
    static boolean[] S2;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        int len = S.length();
        S2 = new boolean[len];
        for(int i=0; i<len; i++){
            if(S.charAt(i) == '0'){
                zero++;
            } else {
                one++;
            }
        }
        one = one/2;
        zero = zero/2;
        int idx = 0;
        while(true){ //앞에서부터 1 없애기
            if(one == 0) break;

            if(S.charAt(idx) == '1'){
                S2[idx] = true;
                one--;
            }
            idx++;
        }
        idx = len-1;
        while(true){ //뒤에서부터 0 없애기
            if(zero == 0) break;

            if(S.charAt(idx) == '0'){
                S2[idx] = true;
                zero--;
            }
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            if(!S2[i]){
                sb.append(S.charAt(i));
            }
        }
        System.out.print(sb);
    }
}