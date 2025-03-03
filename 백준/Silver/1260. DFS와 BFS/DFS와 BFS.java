import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V; //정점의 수, 간선의 수, 시작 노드 
	static boolean[] visited;
	static List<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>()); //정점 초기화. 노드 인덱스를 1부터 N까지 쓰기 위해 N+1 개의 리스트를 초기화.
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u); //양방향으로 저장. 
		}
		for(int i=1; i<=N; i++) {
			Collections.sort(graph.get(i)); //정점 번호가 작은 것부터 탐색하니까 오름차순 정렬.
		}
		
		visited = new boolean[N+1]; 
		dfs(V);
		sb.append("\n");
		visited = new boolean[N+1]; 
		bfs(V);
		
		System.out.print(sb);
		br.close();
	}
	public static void dfs(int node) {
		visited[node] = true;
		sb.append(node).append(" ");
		
		for(int next : graph.get(node)) {
			if(visited[next]) continue;
			
			dfs(next);
		}
	}
	public static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		visited[node] = true;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			sb.append(n).append(" ");
			
			for(int next : graph.get(n)) {
				if(visited[next]) continue;
				
				q.offer(next);
				visited[next] = true;
			}
		}
	}
}
