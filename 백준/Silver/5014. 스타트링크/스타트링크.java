import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D; //건물 총 F층, 현재 S층, 목적지 G층, U누르면 +U층 이동, D누르면 -D층 이동.
	static String cant = "use the stairs";
	static boolean[] visited;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[F+1];
		visited[S] = true;
		cnt = new  int[F+1];
		solve(S);
		if(G == S) {
			System.out.print(0);
		} else if(cnt[G] == 0) {
			System.out.print(cant);
		} else {
			System.out.print(cnt[G]);
		}
//		System.out.println();
//		for(int i=1; i<=F; i++) {
//			System.out.print(cnt[i] + " ");
//		}
		br.close();
	}
	private static void solve(int here) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(here);
		visited[here] = true;
		cnt[here] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int nextU = now + U;
			int nextD = now - D;
			if(nextU <= F && !visited[nextU]) {
				q.offer(nextU);
				visited[nextU] = true;
				cnt[nextU] = cnt[now] + 1;
				if(nextU == G) return;
			}
			if(nextD > 0 && !visited[nextD]) {
				q.offer(nextD);
				visited[nextD] = true;
				cnt[nextD] = cnt[now] + 1;
				if(nextD == G) return;
			}
		}
	}
}
