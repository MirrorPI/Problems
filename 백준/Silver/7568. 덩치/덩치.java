import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N; //사람의 수, 2~50
	static ArrayList<int[]> data;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			data.add(new int[] {w, h, 1});
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				
				if(data.get(i)[0] > data.get(j)[0]) {
					if(data.get(i)[1] > data.get(j)[1]) {
						data.get(j)[2] += 1; 
					}
				} 
			}
		}
		for(int i=0; i<N; i++) {
			sb.append(data.get(i)[2]).append(" ");
		}
		System.out.print(sb);
		br.close();
	}	
}
