import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final static String str = "Hello World, Judge ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            sb.append(str).append(i).append('!').append("\n");
        }
        System.out.print(sb);
    }
}