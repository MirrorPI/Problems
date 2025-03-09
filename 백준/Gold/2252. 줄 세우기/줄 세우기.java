import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; //학생의 수, 1번 2번 ... N번 1~32,000
	static int M; //비교 횟수 1~100,000 
	static ArrayList<Integer>[] graph; //순서 정보 저장.
	static int[] in; //각 노드의 진입차수 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		in = new int[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());  //u의 키는 v의 키보다 작다 -> u가 먼저 서야함. 
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			in[v] += 1;
		}
		ArrayList<Integer> start = new ArrayList<>(); 
		for(int i=1; i<=N; i++) {
			if(in[i] == 0) {
				start.add(i);
			}
		}
		solve(start);
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
			sb.append(now).append(" ");
			
			for(int i=0; i<graph[now].size(); i++) {
				int next = graph[now].get(i);
				in[next] -= 1;
				if(in[next] == 0) {
					q.add(next);
				}
			}
		}
	}
}
