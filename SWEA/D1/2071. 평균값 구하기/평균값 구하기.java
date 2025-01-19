import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int sum;
		
		for(int i=0; i<T; i++) {
			sum = 0;
			String nums = br.readLine();
			String[] tokens = nums.split(" ");
			for(String token : tokens) {
				int num = Integer.parseInt(token);
				sum += num;
			}
//			int aver = sum/10; // 정수/정수 = 몫만 나옴(나머지 버림)
			double averD = sum / 10.0;
			int aver = (int)Math.round(averD);
			bw.write("#"+(i+1)+" "+aver+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
