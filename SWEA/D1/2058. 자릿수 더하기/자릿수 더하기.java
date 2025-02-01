import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int sum;
		
		sum = N/1000 + (N%1000)/100 + (N%100)/10 + N%10;
		bw.write(String.valueOf(sum));
		
		bw.flush();
		bw.close();
		br.close();

	}

}
