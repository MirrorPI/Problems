import java.util.*;
import java.io.*;

public class Main {

    final static String yes = "YES";
    final static String no = "NO";
    final static char open = '(';
    final static char close = ')';
    static char[] arr;
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Stack<Character> s = new Stack<>();
        for(int t=0; t<T; t++){
            ans = yes;
            s.clear();
            String input = br.readLine();
            arr = input.toCharArray();
            for(int i=0; i<arr.length; i++){
                if(arr[i] == open){
                    s.push(arr[i]);
                } else {
                    if(s.isEmpty()){
                        ans = no;
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
            if(!s.isEmpty()){
                ans = no;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}