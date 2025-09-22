import java.io.*;
import java.util.*;

public class Main {

    static int N; //(1~1000)
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static int next = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            int target = Integer.parseInt(br.readLine());
            //다음 푸시될 숫자보다 타겟이 더 크거나 같다면 타겟까지 푸시
            if(next <= target){
                for(int j=next; j<=target; j++){
                    stack.push(next++);
                    sb.append("+\n");
                }
            }
            //다음 푸시될 숫자보다 타겟이 작다면 pop을 해줘야함.
            //pop을 하기 전에 stack이 비어있으면 N개의 숫자를 모두 돌기 전에 끝난거고
            //stack의 top 과 pop 할 타겟이 다르면 stack으로 만들 수 없는 배열
            if(stack.isEmpty() || stack.peek() != target){
                //
                System.out.print("NO");
                return;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.print(sb);
    }
}