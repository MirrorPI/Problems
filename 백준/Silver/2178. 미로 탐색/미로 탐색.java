import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] maze;
	static int[][] cnt; //인덱스별 최소 이동경로 저장.
	static int[] dx = {0, 1, 0, -1}; //우하좌상.
	static int[] dy = {1, 0, -1, 0};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		cnt = new int[N][M];
		for(int i=0; i<N; i++) {
			String data = br.readLine();
			for(int j=0; j<M; j++) {
				maze[i][j] = data.charAt(j) - '0';
				cnt[i][j] = -1; //지나가지 않은 곳 -1로 저장.
			}
		}
		solve(0, 0);
		System.out.print(cnt[N-1][M-1]);
	}
	public static void solve(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		cnt[x][y] = 1; //시작점도 포함.
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && maze[nx][ny] == 1 && cnt[nx][ny] == -1) {//배열 내부확인, 이동가능 확인(1), 방문 확인.
					q.offer(new int[]{nx, ny});
					cnt[nx][ny] = cnt[now[0]][now[1]] + 1; //이전 경로에서 한칸 움직임.
				}
			}
		}
	}
}
