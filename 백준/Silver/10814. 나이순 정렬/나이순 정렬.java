import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N; //회원의 수  1~100,000
	static ArrayList<String>[] name = new ArrayList[201];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<=200; i++) {
			name[i] = new ArrayList<>();
		}
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			name[age].add(st.nextToken());
		}
		for(int i=1; i<=200; i++) {
			for(int j=0; j<name[i].size(); j++) {
				sb.append(i).append(" ").append(name[i].get(j)).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
