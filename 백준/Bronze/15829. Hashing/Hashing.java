import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final long MOD = 1234567891L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long result = 0;
		
		for(int i=0; i<L; i++) {
			int ch = str.charAt(i) - 'a' + 1;
			result = (result + (ch * power31mod(i)) % MOD) % MOD;
		
		}
		System.out.print(result);

	}
	private static long power31mod (long temp) {
		long result = 1;
		
		if(temp == 0) {
			return result;
		}
		
		for(int i=1; i<=temp; i++) {
			result = (result * 31L) % MOD;
		}
		
		return result;
	}
}
