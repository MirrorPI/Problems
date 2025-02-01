import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Solution  {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) {
			String date = br.readLine();
			String year = date.substring(0,4);
			String month = date.substring(4, 6);
			String day = date.substring(6, 8);
			
			int m = Integer.parseInt(month);
			int d = Integer.parseInt(day);
			int[] max = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			
			boolean isItDate = true;
			if(m > 12 || m < 1) {
				isItDate = false;
			}
			if(isItDate) {
				if(max[m-1] < d || d < 1) {
					isItDate = false;
				}
			}
			
			if(isItDate) {
				bw.write("#" + (i+1) + " " + year + "/" + month + "/" + day + "\n");
			}
			else {
				bw.write("#" + (i+1) + " " + "-1" + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
			
	}

}
