import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			int sum = 0;
			int cnt = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == 'O') {
					sum += ++cnt;
				} else if(str.charAt(i) == 'X') {
					cnt = 0;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
