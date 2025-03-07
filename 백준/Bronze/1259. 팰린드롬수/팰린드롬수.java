import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) {
				break;
			}
			
			int len = str.length();
			boolean isP = true;
			for(int i=0; i<len/2; i++) {
				if(str.charAt(i) != str.charAt(len - i - 1)) {
					sb.append("no");
					isP = false;
					break;
				}
			}
			if(isP) {
				sb.append("yes");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}