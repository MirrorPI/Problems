import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N; // 사람의 수, 5~2000
	static int M; // 친구 관계의 수, 1~2000
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
//		for(int i=0; i<N; i++) { //입력 확인.
//			System.out.print(i + ": ");
//			for(int n : graph[i]) {
//				System.out.print(n + " ");
//			}
//			System.out.println();
//		}
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			solve(i, 1);
			if(result == 1) {
				break;
			}
		}
		System.out.print(result);
	}
	
	public static void solve(int idx, int cnt) {
		if(cnt == 5) {
			result = 1;
			return;
		}
		if(idx == N) {
			return;
		}
		visited[idx] = true;
		for(int next : graph[idx]) {
			if(visited[next]) continue;
			
			visited[next] = true;
			solve(next, cnt+1);
			visited[next] = false;
		}
	}
}