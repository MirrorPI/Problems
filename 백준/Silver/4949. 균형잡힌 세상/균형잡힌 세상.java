import java.io.*;
import java.util.*;

public class Main {

    static Stack<Character> parentheses = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String input = br.readLine();
            if(input.equals(".")) break;

            parentheses.clear();
            boolean ok = true;
            for(int i=0; i<input.length(); i++){
                char ch = input.charAt(i);
                if(ch == '(' || ch == '[') {
                    parentheses.push(ch);
                } else if(ch == ')'){ //잘못된 닫힘 체크
                    if(parentheses.isEmpty() || parentheses.peek() != '(') {
                        ok = false;
                        break;
                    } else {
                        parentheses.pop();
                    }
                } else if(ch == ']'){
                    if(parentheses.isEmpty() || parentheses.peek() != '[') {
                        ok = false;
                        break;
                    } else {
                        parentheses.pop();
                    }
                }
            }
            //잘못된 닫힘 없었고 비어 있어야 완벽 "((" -> X
            sb.append(ok && parentheses.isEmpty() ? "yes\n" : "no\n");
        }
        System.out.print(sb);
    }
}