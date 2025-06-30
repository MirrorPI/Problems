import java.util.*;
import java.io.*;

public class Main {

    final static int diff = 'a' - 'A';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();
        for(int i=0; i<word.length(); i++){
            char ch = ' ';
            if(word.charAt(i) >= 'a'){
                ch = (char)(word.charAt(i) - diff);
            } else {
                ch = (char)(word.charAt(i) + diff);
            }
            sb.append(ch);
        }
        System.out.print(sb);
        br.close();
    }
}