import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());
        StringBuilder cursorLeft = new StringBuilder();
        StringBuilder cursorRight = new StringBuilder();
        StringBuilder out = new StringBuilder();

        for(int i=0; i<input.length(); i++){
            cursorLeft.append(input.charAt(i));
        }
        for(int i=0; i<M; i++){
            String command = br.readLine();
            if(command.charAt(0) == 'L'){ //커서를 왼쪽으로
                int len = cursorLeft.length();
                if(len > 0){
                    cursorRight.append(cursorLeft.charAt(len-1));
                    cursorLeft.setLength(len-1);
                }
            } else if(command.charAt(0) == 'D'){ //커서를 오른쪽으로
                int len = cursorRight.length();
                if(len > 0){
                    cursorLeft.append(cursorRight.charAt(len-1));
                    cursorRight.setLength(len-1);
                }
            } else if(command.charAt(0) == 'B'){ //커서 왼쪽 삭제
                int len = cursorLeft.length();
                if(len > 0){
                    cursorLeft.setLength(len-1);
                }
            } else { //커서  왼쪽에 문자 추가
                cursorLeft.append(command.charAt(2));
            }
        }
        out.append(cursorLeft).append(cursorRight.reverse());
        System.out.print(out);
        br.close();
    }
}