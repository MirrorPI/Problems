import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String input;
	static int[] num = new int[10];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		for(int i=0; i<input.length(); i++) {
			num[input.charAt(i) - '0']++;
		}
		for(int i=9; i>=0; i--) {
			for(int j=0; j<num[i]; j++) {
				sb.append(i);
			}
		}
		System.out.print(sb);
		br.close();
	}
}
