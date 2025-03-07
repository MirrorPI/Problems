import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//좌측상단(0,0) 시작, 같은 알파벳을 두 번 지날 수 없음.
	//출력: 최대 움직일 수 있는 칸 수(시작점 포함)
	static int R; //행 수. 1~20
	static int C; //열 수. 1~20
	static char[][] map;
	static boolean[][] visited;
	static boolean[] alpha = new boolean[26]; //abcde fghij klmno pqrst uvwxy z 지아온 알파벳 기록.
	//static int[][] cnt; //이동 거리 저장.
	static int[] dx = {-1, 1, 0, 0}; //상하좌우.
	static int[] dy = {0, 0, -1, 1};
	static int max = 0;
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		//cnt = new int[R][C];
		for(int i=0; i<R; i++) {
			String data = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = data.charAt(j);
			}
		}
//		for(int i=0; i<R; i++) { //input 확인용
//			System.out.println();
//			for(int j=0; j<C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//		}
		
		solve(0, 0, 1);
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				if(!visited[i][j]) continue;
//				max = Math.max(max, cnt[i][j]);
//			}
//		}
		System.out.print(max);
		br.close();
	}
//	private static void bfs(int x, int y) { //BFS로 적합하지 않은 문제, 
//		Queue<int[]> q = new ArrayDeque<>();
//		q.offer(new int[]{x, y});
//		visited[x][y] = true;
//		cnt[x][y] = 1;
//		alpha[map[x][y]-'A'] = true;
//		
//		while(!q.isEmpty()) {
//			int[] now = q.poll();
//			for(int i=0; i<4; i++) {
//				int nx = now[0] + dx[i];
//				int ny = now[1] + dy[i];
//				if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny]) {
//					if(!alpha[map[nx][ny]-'A']) {
//						alpha[map[nx][ny]-'A'] = true;
//						q.offer(new int[] {nx, ny});
//						visited[nx][ny] = true;
//						cnt[nx][ny] = cnt[now[0]][now[1]] + 1;
//					} else {
//						continue;
//					}
//				}
//			}
//		}
//	}
	private static void solve(int x, int y, int cnt) {
		visited[x][y] = true;
		alpha[map[x][y]-'A'] = true; 
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny]) {
				if(!alpha[map[nx][ny]-'A']) {
					solve(nx, ny, cnt+1);
					visited[nx][ny] = false;
					alpha[map[nx][ny]-'A'] = false; 
				} else {
					max = Math.max(max, cnt);
				}
			} else {
				max = Math.max(max, cnt);
			}
		}
	}
}
