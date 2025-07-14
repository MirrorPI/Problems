import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N; //1~1000
    static int[] hansu = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=1; i<=1000; i++){
            if(i<100){
                hansu[i] = i;
            } else if(i<1000){
                int a = i/100;
                int b = (i%100)/10;
                int c = i%10;
                if(a - b == b - c){
                    hansu[i] = hansu[i-1] + 1;
                } else {
                    hansu[i] = hansu[i-1];
                }
            } else {
                hansu[i] = hansu[i-1];
            }
        }
        System.out.print(hansu[N]);
        br.close();
    }
}