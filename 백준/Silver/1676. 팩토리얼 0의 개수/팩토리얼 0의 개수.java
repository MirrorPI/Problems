import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N; //0~500, 0! = 1;
	static int two; //
	static int five;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=2; i<=N; i++) {
			int temp = i;
			while(true) {
				if(temp%2 != 0) {
					break;
				} else {
					temp = temp/2;
					two++;
				}
				//System.out.print(temp + " ");
			}
			temp = i;
			while(true) {
				if(temp%5 != 0) {
					break;
				} else {
					temp = temp/5;
					five++;
				}
				//System.out.print(i + "*");
			}
		}
		if(two >= five) {
			System.out.print(five);
		} else {
			System.out.print(two);
		}
		br.close();
	}
}
