import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int T;
	static int N, M; // 세로 가로, 5~50
	static int x, y; //맨홀 뚜껑 위치
	static int L; //소요된 시간. 1~20
	//N, M, 맨홀뚜껑위치(x, y), L
	static int[][] map; // 0빈공간, 1상하좌우, 2상하, 3좌우, 4상우, 5하우, 6하좌, 7상좌
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int[][] visited;
	static List<Integer>[] dr = new ArrayList[8];
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M];
			ans = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<8; i++) {
				dr[i] = new ArrayList<>();
			}
			for(int i=0; i<4; i++) {
				dr[1].add(i);
			}
			for(int i=0; i<2; i++) {
				dr[2].add(i);
			}
			for(int i=2; i<4; i++) {
				dr[3].add(i);
			}
			dr[4].add(0);
			dr[4].add(3);
			
			dr[5].add(1);
			dr[5].add(3);
			
			dr[6].add(1);
			dr[6].add(2);
			
			dr[7].add(0);
			dr[7].add(2);
			
			solve(x, y);
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(visited[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j] == 0 || visited[i][j] > L) continue;
					
					ans++;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	public static void solve(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y] = 1;
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			int tunnel = map[now[0]][now[1]];
			for(int n : dr[tunnel]) {
				int nx = now[0] + dx[n];
				int ny = now[1] + dy[n];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(visited[nx][ny] == 0 && canGo(map[nx][ny], n)){
						visited[nx][ny] = visited[now[0]][now[1]] + 1;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
	static boolean canGo(int x, int n) { //다음 맵의 정보, 방향 정보
		if(n == 0) { //현재 위치에서 방향 정보 순서대로 상하좌우.
			if(x == 1 || x == 2 || x == 5 || x == 6) {
				return true;
			}
		} else if(n==1) {
			if(x == 1 || x == 2 || x == 4 || x == 7) {
				return true;
			}
		} else if(n==2) {
			if(x == 1 || x == 3 || x == 4 || x == 5) {
				return true;
			}
		} else {
			if(x == 1 || x == 3 || x == 6 || x == 7) {
				return true;
			}
		}
		
		return false;
	}
}