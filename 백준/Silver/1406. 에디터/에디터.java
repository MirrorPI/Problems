import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());
        Stack<Character> cursorLeft = new Stack<>();
        Stack<Character> cursorRight = new Stack<>();
        Stack<Character> answer = new Stack<>();
        for(int i=0; i<input.length(); i++){
            cursorLeft.add(input.charAt(i));
        }
        for(int i=0; i<M; i++){
            String command = br.readLine();
            if(command.charAt(0) == 'L'){ //커서를 왼쪽으로
                if(!cursorLeft.empty()){
                    cursorRight.add(cursorLeft.pop());
                }
            } else if(command.charAt(0) == 'D'){ //커서를 오른쪽으로
                if(!cursorRight.empty()){
                    cursorLeft.add(cursorRight.pop());
                }
            } else if(command.charAt(0) == 'B'){ //커서 왼쪽 삭제
                if(!cursorLeft.empty()){
                    cursorLeft.pop();
                }
            } else { //커서  왼쪽에 문자 추가
                cursorLeft.add(command.charAt(2));
            }
        }

        while(!cursorLeft.empty()){
            answer.add(cursorLeft.pop());
        }
        while(!answer.empty()){
            sb.append(answer.pop());
        }
        while(!cursorRight.empty()){
            sb.append(cursorRight.pop());
        }
        System.out.print(sb);
        br.close();
    }
}