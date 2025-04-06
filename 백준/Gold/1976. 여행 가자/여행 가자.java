import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N; //도시의 수. 1~200
	static int M; //여행 계획에 속한 도시들의 수. ~1000
	static int[] p; //갈 수 있는 경로 정보를 유니온 파인드식 집합으로 정리.
	static int[] plan;
	static String ans;
	//여행 경로 연결 정보.p[i][j] = 1이면 i, j 연결, 0이면 연결x
	//유니온 파인드 라는 문제라고 생각하고 접근하는 중 -> 같은 집합이라면 갈 수 있는 여행지.
	//예를 들어 1, 2, 3 이라는 여행 계획이 있을 때 1과 2가 같은 집합에 존재하고 3이 다른 집합에 존재한다면 성립할 수 없는 계획임
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 StringTokenizer st;
		 
		 N = Integer.parseInt(br.readLine());
		 M = Integer.parseInt(br.readLine());
		 p = new int[N+1];
		 Arrays.fill(p,  -1);
		 plan = new int[M];
		 for(int i=1; i<=N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=1; j<=N; j++) {
				 if(Integer.parseInt(st.nextToken()) == 0) continue;
				 
				 union(i, j);
			 }
		 }
		 st = new StringTokenizer(br.readLine());
		 for(int i=0; i<M; i++) {
			 plan[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 boolean isPoss = true;
		 for(int i=0; i<M-1; i++) {
			 if(find(plan[i]) != find(plan[i+1])) {
				 isPoss = false;
				 break;
			 }
		 }
		 if(isPoss) ans = "YES";
		 else ans = "NO";
		 
//		 for(int i=1; i<=N; i++) {
//			 System.out.print(p[i] + " ");
//
//		 }
//		 System.out.println();
//		 for(int i=0; i<M; i++) {
//			 System.out.print(plan[i] + " ");
//		 }
				 
		 System.out.print(ans);
		 br.close();

	}
	public static int find(int x) {
		if(p[x] < 0) return x;
		
		return p[x] = find(p[x]);
	}
	
	public static void union(int x, int y) {
		int u = find(x);
		int v = find(y);
		
		if(u==v) return;
		
		if(p[v] < p[u]) {
			int temp = u;
			u = v; 
			v = temp;
		}
		
		if(p[v] == p[u]) {
			p[u]--;
		}
		p[v] = u;
	}
}
