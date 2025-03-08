import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N; //1~10,000,000
	static int[] n = new int[10001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			n[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=1; i<=10000; i++) {
			for(int j=0; j<n[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
