import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K; //1~10, 0~N;
	static int result = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=N; i>N-K; i--) {
			result *= i;
		}
		for(int i=K; i>1; i--) {
			result /= i;
		}
		System.out.print(result);
		br.close();
	}
}
