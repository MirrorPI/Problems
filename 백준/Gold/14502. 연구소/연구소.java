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

	static int N, M; //연구소의 크기, 3~8
	static int[][] map; //연구소, 0: 빈칸, 1: 벽, 2: 바이러스
	static boolean[][] visited; 
	static Queue<int[]> q;
	static List<int[]> virus = new ArrayList<>(); //바이러스 위치 저장.
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int safeZone;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new int[] {i,j});
				}
				if(map[i][j] == 0) {
					safeZone++;
				}
			}
		}
//		for(int i=0; i<N; i++) { //입력확인
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		wall(0);
		System.out.print(max);
	}
	
	public static void wall(int cnt) { //벽 세우기, 백트래킹
		if(cnt == 3) {
			int safe = safeZone - 3; //새로 세운 3개의 벽은 안전 구역에서 제외
			q = new ArrayDeque<>();
//			Arrays.fill(visited, false);
			visited = new boolean[N][M];
			for(int[] p : virus) {
				visited[p[0]][p[1]] = true;
				q.add(p);
			}
			max = Math.max(max, infect(safe));
//			System.out.println("--------------------------------------------------");
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static int infect(int safe) { //감염시키기		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(map[nx][ny] == 1 || visited[nx][ny]) continue;
					
//					System.out.print(nx + " " + ny + "\n");
					safe--;
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
		return safe;
	}
}