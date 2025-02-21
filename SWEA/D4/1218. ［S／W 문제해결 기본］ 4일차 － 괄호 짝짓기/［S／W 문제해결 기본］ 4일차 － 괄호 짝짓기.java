import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static char[] open = new char[] {'(', '[', '{', '<'};
	static char[] close = new char[] {')', ']', '}', '>'};
	static Map<Character, Character> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<4; i++) {
			map.put(open[i], close[i]);
		}
		
		for(int i=0; i<10; i++) {
			int length = Integer.parseInt(br.readLine().trim());
			//StringTokenizer st = new StringTokenizer(br.readLine(), "");
			String input = br.readLine();
			Stack<Character> arr = new Stack<>();
			int isCorrect = 1;
			
			for(int j=0; j<length; j++) {
				char temp = input.charAt(j);
				
				if(map.containsKey(temp)) {
					arr.push(temp);
				} else {
					if(arr.isEmpty() || map.get(arr.pop()) != temp ) {
						isCorrect = 0;
						break;
					}
				}
			}
			if(arr.isEmpty()) {
				isCorrect = 1;
			} else {
				isCorrect = 0;
			}
			
			sb.append("#").append(i+1).append(" ").append(isCorrect).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}

}
