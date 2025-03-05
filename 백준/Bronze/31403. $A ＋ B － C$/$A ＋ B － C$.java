import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int A, B, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		int num = A + B - C;
		solve();
		int str = A + B - C;
		sb.append(num).append("\n").append(str);
		System.out.print(sb);
		br.close();
	}
	private static void solve() {
		if(B>=1 && B<10) {
			A *= 10;
		} else if(B>=10 && B<100) {
			A *= 100;
		} else if(B>=100 && B<1000){
			A *= 1000;
		}else {
			A *= 10000;
		}
	}
}