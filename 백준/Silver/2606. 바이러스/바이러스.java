import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] infected;
	static List<ArrayList<Integer>> com = new ArrayList<>();
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		infected = new boolean[N+1];
		for(int i=0; i<N+1; i++) { // 인덱스를 노드의 숫자와 일치시키기 위해 N+1 개의 List 생성.
			com.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			com.get(u).add(v);
			com.get(v).add(u);
		}
//		for(int i=1; i<=N; i++) { //input 확인용.
//			System.out.print(i + ": ");
//			for(int j=0; j<com.get(i).size(); j++) {
//				System.out.print(com.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
		check(1);
		System.out.print(cnt);
		
		br.close();
	}
	private static void check(int node) {
		infected[node] = true;

		for(int next : com.get(node)) {
			if(infected[next]) continue;
			
			cnt++;
			check(next);
		}
	}
}
