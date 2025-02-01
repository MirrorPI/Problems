import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String STR = str.toUpperCase();
		
		bw.write(STR);
		
		bw.flush();
		bw.close();
		br.close();
	}

}