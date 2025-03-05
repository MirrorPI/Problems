
import java.util.*;
import java.io.*;

public class Main {

	private static int R, C, answer;
	private static boolean isReached;

	private static int[] dx = { -1, 0, 1 };
	private static int[] dy = { 1, 1, 1 };

	private static boolean[][] visited;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			isReached = false;
			search(i, 0);
		}

		sb.append(answer);

		bw.write(sb.toString());
		bw.flush();

		bw.close();
		br.close();

	}

	private static void search(int r, int c) {
		if (c == C - 1) {
			answer++;
			isReached = true;
		}

		for (int i = 0; i < 3 && !isReached; i++) {
			int nx = r + dx[i], ny = c + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;
			if (map[nx][ny] == 'x')
				continue;
			if (visited[nx][ny])
				continue;

			visited[nx][ny] = true;
			search(nx, ny);
		}
	}
}
