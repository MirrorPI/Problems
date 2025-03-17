import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] point;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		point = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(point, (p1, p2) -> {
			if(p1[1] == p2[1]) return Integer.compare(p1[0], p2[0]);
			
			return Integer.compare(p1[1], p2[1]);
		});
		
		for(int i=0; i<N; i++) {
			sb.append(point[i][0]).append(" ").append(point[i][1]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
