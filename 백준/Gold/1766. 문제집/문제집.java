import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N; //문제의 수, 1~32,000.
	static int M; //먼저 풀면 좋은 문제에 대한 정보의 수. 1~100,000
	static ArrayList<Integer>[] problem;
	static int[] in; //진입차수. 
	static Queue<Integer> q = new ArrayDeque<>();
	static ArrayList<Integer> temp = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		in = new int[N+1];
		problem = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			problem[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			problem[u].add(v);
			in[v]++;
		}
//		for(int i=1; i<=N; i++) { //입력값 확인.
//			System.out.print(i + ": ");
//			for(int n : problem[i]) {
//				System.out.print(n + " ");
//			}
//			System.out.println();
//		}
		boolean finded = false;
		for(int i=1; i<=N; i++) {
			if(!finded) {
				if(in[i] == 0) {
					q.add(i);  //최조 시작점. 진입 차수 없는 문제 중에 번호가 가장 작은 지점.
					finded = true;
				}
			} else {
				if(in[i] == 0) {
					temp.add(i);
				}
			}
		}
//		for(int n : temp) {
//			System.out.print(n +  " ");
//		}
		solve();
		System.out.print(sb);
		br.close();
	}
	public static void solve() {
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			
			for(int next : problem[now]) {
				in[next]--;
				if(in[next] == 0) {
					temp.add(next);
				}
			}
			Collections.sort(temp, (p1, p2) -> Integer.compare(p2, p1));
			if(temp.size() != 0) {
				q.add(temp.get(temp.size()-1));
				temp.remove(temp.size()-1);
			}
		}
	}
}
