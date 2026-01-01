import java.io.*;
import java.util.*;

public class Main {

    static String pass;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(!(pass = br.readLine()).equals("end")) {
            boolean haveVowel = false;
            boolean isTriple = false;
            boolean isSame = false;
            int vowelCnt = 0;
            int consonantCnt = 0;
            for(int i=0; i<pass.length(); i++){
                char ch = pass.charAt(i);
                if(isVowel(ch)){
                    haveVowel = true;
                    vowelCnt++;
                    consonantCnt = 0;
                } else {
                    vowelCnt = 0;
                    consonantCnt++;
                }

                if(vowelCnt == 3 || consonantCnt == 3) {
                    isTriple = true;
                }

                if(ch != 'e' && ch != 'o' && i != pass.length()-1) {
                    if(ch == pass.charAt(i+1)){
                        isSame = true;
                    }
                }
            }
            if(!haveVowel || isTriple || isSame) {
                sb.append("<").append(pass).append(">").append(" is not acceptable.\n");
            } else {
                sb.append("<").append(pass).append(">").append(" is acceptable.\n");
            }
        }
        System.out.print(sb);
    }

    static boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        } else {
            return false;
        }
    }
}