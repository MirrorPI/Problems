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
		for(int i=0; i<T; i++) {
			String nums = br.readLine();
			String[] splitNums = nums.split(" ");
			int max = -1;
			for(String token : splitNums) {
				int num = Integer.parseInt(token);
				if(max < num) {
					max = num;
				}
			}
			bw.write("#"+(i+1)+" "+max+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
