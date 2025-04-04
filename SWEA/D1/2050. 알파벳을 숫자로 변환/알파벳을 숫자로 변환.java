import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int len = str.length();
		for(int i=0; i<len; i++) {
			int n = str.charAt(i) - 'A' + 1;
			bw.write(n + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
