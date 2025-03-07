import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	//길이는 30000이하, 제곱하면 900,000,000 int 범위 내.
	static String end = "0 0 0";
	static String r = "right";
	static String w = "wrong";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals(end)) break;
			StringTokenizer st = new StringTokenizer(str);
			ArrayList<Integer> len = new ArrayList<>();
			for(int i = 0; i<3; i++) {
				len.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(len);
			int a = len.get(0);
			int b = len.get(1);
			int c = len.get(2);
			if(a*a + b*b == c*c) {
				sb.append(r).append("\n");
			} else {
				sb.append(w).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
