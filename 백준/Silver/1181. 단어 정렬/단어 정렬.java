import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static int N; //단어의 개수 1~20,000
	static ArrayList<String> word;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		word = new ArrayList<>();
		for(int i=0; i<N; i++) {
			word.add(br.readLine());
		}
		Collections.sort(word);
		Collections.sort(word, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
//		Collections.sort(word, (o1, o2) -> {
//		int cmp = Integer.compare(o1.length(), o2.length());
//		if(cmp == 0) {
//			cmp = Integer.compare(o1.charAt(0),o2.charAt(0));
//		}
//		return cmp;
//		});
		sb.append(word.get(0)).append("\n");
		String temp = word.get(0);
		for(int i=1; i<N; i++) {
			if(temp.equals(word.get(i))) {
				continue;
			}
			temp = word.get(i);
			sb.append(temp).append("\n");
		}
		System.out.print(sb);
		br.close();		
	}
}
