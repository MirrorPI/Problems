import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//유클리드 호제법 - A와 B의 최대 공약수는 B와 A%B의 최대 공약수와 같다.
	//gcd(A, B) = gcd(B, A-B) = gcd(B, A%B) 
	//lcm(A,B) = A*B/gcd(A, B)
	static int a, b;
	static int gcd;
	static int lcm;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int fa = a;
		int fb = b;
		if(a < b) {
			int temp = b;
			b = a;
			a = temp;
		}
		while(true) {
			if(a==b || b==1) {
				gcd = b;
				break;
			}
			if(b == 0) {
				gcd = a;
				break;
			}
			int temp = b;
			b = a%b;
			a = temp;
		}
		lcm = fa*fb/gcd;
		sb.append(gcd).append("\n").append(lcm);
		System.out.print(sb);
	}
}

