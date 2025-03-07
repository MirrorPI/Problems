import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int V; //Vertex 정점의 개수, 3~1000
	static int E; //Edge 간선의 개수, 2~3000
	static ArrayList<Integer>[] list; //정점의 연결 정보를 저장.
	static int[] in; //진입차수를 저장할 배열 -> 진입차수가 만약 1이면 그 작업은 선행할 작업이 있기때문에 안됨 -> 0인 지점 찾아서 그 작업부터 수행.
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			in = new int[V+1];
			list = new ArrayList[V+1]; //list[노드번호].get(다음 수행 노드 인덱스)
			visited = new boolean[V+1];
			for(int i=0; i<=V; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v); // u -> v
				in[v] += 1; // 진입차수 +1 
			}
//			for(int i=1; i<=V; i++) { //입력확인.
//				System.out.print(i + ": " );
//				for(int j=0; j<list[i].size(); j++) {
//					System.out.print(list[i].get(j) + " ");
//				}
//				System.out.println();
//			}
//			for(int i=1; i<=V; i++) {
//				System.out.println(i + ": " + in[i]);
//			}
			ArrayList<Integer> start = new ArrayList<>(); //진입차수 0인 노드 저장.
			for(int i=1; i<=V; i++) {
				if(in[i] == 0) {
					start.add(i);
				}
			}
			sb.append("#").append(tc).append(" ");
			solve(start);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	private static void solve(ArrayList<Integer> s) {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=0; i<s.size(); i++) { //진입 차수가 0인 node를 모두 큐에 넣어둠.
			q.add(s.get(i));
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			for(int i=0; i<list[now].size(); i++) {
				int next = list[now].get(i);
                in[next] -= 1;
                if(in[next] == 0) {
                    q.add(next);
                }
			}
		}
	}
}
