import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> password = new ArrayDeque<>();
		
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<8; j++) {
				int num = Integer.parseInt(st.nextToken());
				password.add(num);
			}

			int count = 1;
			
			while(true) {
				int temp = password.pollFirst() - count;
				
				if(temp <= 0) {
					password.addLast(0);
					break;
				} else {
					password.addLast(temp);
				}
				
				count++;
				
				if(count > 5) {
					count = 1;
				}
			}
			
			sb.append("#").append(n).append(" ");
			
			for(int j=0; j<8; j++) {
				sb.append(password.pollFirst()).append(" ");
			}
			
			sb.append("\n");
			
		}
		
		System.out.print(sb);
		br.close();
	}
}
