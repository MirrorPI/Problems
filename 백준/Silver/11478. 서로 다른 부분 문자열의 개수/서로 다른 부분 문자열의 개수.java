import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static Set<String> strs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        strs = new HashSet<>();
        int len = S.length();
        for(int i=0; i<len; i++){
            for(int j=i+1; j<=len; j++){
                strs.add(S.substring(i, j));
            }
        }
        System.out.print(strs.size());
    }
}