import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String asc = "1 2 3 4 5 6 7 8";
	static String des = "8 7 6 5 4 3 2 1";
	StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		if(str.equals(asc)) {
			System.out.print("ascending");
		} else if(str.equals(des)) {
			System.out.print("descending");
		} else {
			System.out.print("mixed");
		}
		
		br.close();
	}
}
