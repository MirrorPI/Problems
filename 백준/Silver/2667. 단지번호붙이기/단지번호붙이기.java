import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> dan = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0}; //상하좌우.
	static int[] dy = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder(); 
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String data = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = data.charAt(j) - '0';
			}
		}
//		for(int i=0; i<N; i++) {  //input 확인용.
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] || map[i][j] == 0) continue;
				
				solve(i, j);
			}
		}
		Collections.sort(dan);
		sb.append(result).append("\n");
		for(int i=0; i<result; i++) {
			sb.append(dan.get(i)).append("\n");
		}
		System.out.print(sb);
		
		br.close();
	}
	private static void solve(int x, int y) {
		result++;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == 1 && !visited[nx][ny])  {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		dan.add(cnt);
	}
}
