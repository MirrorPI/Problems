import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		String[] dp1 = new String[13];
		String[] dp2 = new String[13];
		dp2[1] = " ";
		dp2[2] = "   ";
		dp2[3] = "         ";
		
		dp1[0] = "-";
		dp1[1] = dp1[0] + dp2[1] + dp1[0];  //- -
		dp1[2] = dp1[1] + dp2[2] + dp1[1];  //- -   - -
		dp1[3] = dp1[2] + dp2[3] + dp1[2];  //- -   - -         - -   - -
		
		for(int i=4; i<13; i++) {
			sb = new StringBuilder();
			dp2[i] = sb.append(dp2[i-1]).append(dp2[i-1]).append(dp2[i-1]).toString();
			sb = new StringBuilder();
			dp1[i] = sb.append(dp1[i-1]).append(dp2[i]).append(dp1[i-1]).toString();
		}
		
		String input;
		sb = new StringBuilder();
		while((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			sb.append(dp1[N]).append("\n");
		}
		System.out.print(sb);
		
		br.close();
	}

}
