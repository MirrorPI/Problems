import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M; // 과목 수(1~1000), 조건의 수(0~500,000)
	static List<Integer>[] graph;
	static int[] in; 
	//static int[] semester; //학기 저장.
	static ArrayList<Integer> start = new ArrayList<>();
	static Queue<Integer> q = new ArrayDeque<>();
	static Queue<Integer> q2 = new ArrayDeque<>();
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		in = new int[N+1];
		//semester = new int[N+1];
		ans = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v); //u -> v
			in[v] += 1;
		}
		for(int i=1; i<=N; i++) {
			if(in[i] != 0) continue;
			
			start.add(i);
			ans[i] = 1;
		}
		for(int s : start) {
			q.add(s);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph[now]) {
				in[next]--;
				ans[next] = ans[now] + 1;
				if(in[next] == 0) {
					q.add(next);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.print(sb);
		br.close();
	}
}
