import java.io.*;
import java.util.*;

public class Main {

    static int L, C; //암호의 길이(3~15), 후보 글자.
    static char[] ch;
    static char[] pass;
    static StringBuilder sb = new StringBuilder();
    //모음 하나이상, 자음 두개 이상.
    //오름차순.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pass = new char[L];
        ch = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int c=0; c<C; c++){
            ch[c] = st.nextToken().charAt(0);
        }
        Arrays.sort(ch);
        makePass(0, 0, 0);
        System.out.print(sb);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void makePass(int depth, int start, int vowelCnt) {
        if(depth == L) { //비밀번호 완성 및 검증
            int consonantCnt = depth-vowelCnt;
            if(vowelCnt >= 1 && consonantCnt >= 2) {
                for(int i=0; i<depth; i++){
                    sb.append(pass[i]);
                }
                sb.append("\n");
            }
            return;
        }
        if(start == C) return; //비밀번호가 완성이 안됐는데 더 이상 볼 후보 글자가 없음

        //후보 글자 선택
        char c = ch[start];
        pass[depth] = c;
        makePass(depth+1, start+1, vowelCnt + (isVowel(c) ? 1 : 0));

        //후보 글자 선택 x
        makePass(depth, start+1, vowelCnt);
    }
}