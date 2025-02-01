import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int P = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		bw.write((P-K+1) + "");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
