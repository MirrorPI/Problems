import java.io.*;
import java.util.*;

public class Main {

    static int K; //입력 개수 1~100,000
    static Stack<Integer> stack = new Stack<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            int input = Integer.parseInt(br.readLine());
            if(!stack.isEmpty() && input == 0){
                stack.pop();
            } else {
                stack.push(input);
            }
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        System.out.print(ans);
        br.close();
    }
}