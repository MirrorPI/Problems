import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; //전체 사람 수.
	static int M; //관계의 수.
	static int a, b; //촌수를 계산 해야할 두 사람의 번호.
	static List<ArrayList<Integer>> f = new  ArrayList<>();
	static boolean[] visited;
	static boolean find = false;
	static int[] cnt; //a 부터 인덱스 지점가지 최단 거리를 저장할 배열
	// a = 7이고 b가 3이면 cnt[7] = 3까지 최단 거리.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		cnt = new int[N+1];
		for(int i=0; i<N+1; i++) {
			f.add(new ArrayList<>());
			cnt[i] = -1;
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //부모
			int y = Integer.parseInt(st.nextToken()); //자식
			f.get(x).add(y);
			f.get(y).add(x); 
		}
//		for(int i=1; i<=N; i++) { //input 확인용.
//			System.out.print(i + ": ");
//			for(int j=0; j<f.get(i).size(); j++) {
//				System.out.print(f.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
		solve(a);
		System.out.print(cnt[b]);
	}
	private static void solve(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		visited[node] = true;
		cnt[node] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next: f.get(now)) {
				if(visited[next]) continue;
				
				cnt[next] = cnt[now] + 1;
				if(next == b) return;
				q.offer(next);
				visited[next] = true;
			}
		}
	}
}
