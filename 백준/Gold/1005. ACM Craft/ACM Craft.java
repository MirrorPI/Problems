import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; //건물의 개수, 2~1000  (노드의 개수)
	static int K; //건물 순서 규칙 개수 1~100,000; (간선의 개수)
	static int[] t; //각 건물의 건설 시간
	static int[] in; //진입차수 저장.
	static ArrayList<Integer>[] list;
	static int[] time; // 특정 노드 까지 온 시간.
	static int W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			list = new ArrayList[N+1];
			t = new int[N+1];
			time = new int[N+1];
			in = new int[N+1];
			for(int i=0; i<=N; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				t[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<K; i++) {
				 st = new StringTokenizer(br.readLine());
				 int u = Integer.parseInt(st.nextToken());
				 int v = Integer.parseInt(st.nextToken());
				 list[u].add(v); //u 건설 후 v 건설 가능.
				 in[v] += 1;
			}
			W = Integer.parseInt(br.readLine());
			ArrayList<Integer> start = new ArrayList<>(); //진입 차수 0인 지점 저장.(시작 노드);
			for(int i=1; i<=N; i++) {
				if(in[i] == 0) {
					start.add(i);
					time[i] = t[i];
				}
			}
			solve(start);
			sb.append(time[W]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	private static void solve(ArrayList<Integer> s) {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0; i<s.size(); i++) {
			q.add(s.get(i));
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			//if(now == W) return;
			
			for(int i=0; i<list[now].size(); i++) {
				int next = list[now].get(i);
				in[next] -= 1;
				if(in[next] == 0) q.add(next);
				time[next] = Math.max(time[next], time[now] + t[next]);
			}
		}
	}
}
