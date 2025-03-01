import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Solution {
	static int[] dx = new int[] {0, 0, 1}; //좌 우 하
	static int[] dy = new int[] {-1, 1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<10; i++) {
			List<Integer> startPoint = new ArrayList<>();
			boolean find = false;
			
			int result = 0;
			int T = Integer.parseInt(br.readLine().trim());
			
			for(int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<100; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
					//visited[j][k]= false;
				}
				
			}
//			for(int j=0; j<100; j++) {
//				for(int k=0; k<100; k++) {
//					System.out.print(map[j][k]);
//				}
//				System.out.println();
//			}
			
			for(int k=0; k<100; k++) {
				if(map[0][k] == 1) {
					startPoint.add(k);
					
					//System.out.println(k+ " ");
				}
			}
			for(int s=0; s<startPoint.size(); s++) {
				boolean[][] visited = new boolean[100][100];
				int x = 0;
				//System.out.println(x+ " ");
				int y = startPoint.get(s);
				visited[x][y] = true;
				while(map[x][y] != 2) {
					//System.out.println(x + ", "+y);
					for(int j=0; j<3; j++) {  //왼쪽 -> 오른쪽 -> 아래
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(nx>=0 && nx < 100 && ny>=0 && ny <100 && !visited[nx][ny]) { // 맵 범위 안 그리고 지나갔던 길인지 확인
//							if(map[x][ny] == 1 && !visited[x][ny]) {
//								y = ny;
//								visited[x][ny] = true;
//								continue;
//							}

							if(map[nx][ny] == 1) { //이동 할 곳에 1이 있으면 
								x = nx; //좌표변경(이동)
								y= ny;
								visited[nx][ny] = true; //방문
								break; //좌우하 탐색 for 탈출
							}
							if(map[nx][ny] == 2){ //이동할 곳에 2가 있으면 성공.
								x = nx;
								y = ny;
								result = startPoint.get(s);
								find = true;
								visited[nx][ny] = true;
								break; //좌우하 탐색 for 탈출
							}

						}
						
					}
					if(x == 99 && map[x][y] != 2) { //  끝까지 내려왔는데 2가 아니면 실패.
						find = false;
						break; //2찾는 while 탈출
					}

				}
				if(find) {
					break;//시작점 정하는 for 탈출
				}

				
			}
			
			
			sb.append("#").append(T).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
