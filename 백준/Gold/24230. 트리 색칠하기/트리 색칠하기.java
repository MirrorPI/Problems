import java.util.*;
import java.io.*;

public class Main {

	static int N; //정점의 개수(1~200,000)
	static int[] want; //i번째 노드에 색칠될 색
	static List<Integer>[] tree;
	static int cnt;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		want = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			want[i] = Integer.parseInt(st.nextToken());
		}
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		if(want[1] != 0) { //1번부터 색칠이 될 가능성
			cnt += 1;
		}
		visited[1] = true;
		solve(1);
		System.out.print(cnt);
		br.close();
	}
	private static void solve(int now) {
		for(int next : tree[now]) {
			if(visited[next]) continue;
			
			visited[next] = true;
			if(want[now] != want[next]) {
				cnt += 1;
				solve(next);
			} else {
				solve(next);
			}	
		}
	}
}