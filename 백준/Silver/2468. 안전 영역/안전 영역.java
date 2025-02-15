import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int maxHeight = 0;
    static int maxSafeZone = 1; //최대 안전지대가 0이 될 수는 없다. 비가 오지 않는 상황을 고려.
    static int safeZone;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1}; //상하좌우
    static StringBuilder sb = new StringBuilder();

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
       

        for(int i=0; i<N; i++) { //높이 저장, 최대 높이 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
		for(int h=1; h<maxHeight; h++) { //비의 높이가 0일 때는 maxSafeZone = 1;
			safeZone = 0;    //->> 내가 틀린 부분 잠기는 높이를 바꿔줄 때마다 안전지대롤 리셋해야하는데 전역으로 0으로 초기화해서 총합이 나와버림.
			visited = new boolean[N][N]; //default -> false //->>내가 틀린 부분 이 또한 높이마다 방문기록을 리셋해야하는데 위에서 방문 기록을 초기화 함.
	        for(int i=0; i<N; i++) {
	        	for(int j=0; j<N; j++) {
	    			if(!visited[i][j] && map[i][j] > h) {
	    				bfs(i, j, h);
	    				safeZone++;
	    				//sb.append("여기들어왔다.");
	    				
	    			}
	        	}
	        }
	        maxSafeZone = Math.max(maxSafeZone, safeZone);
//	        sb.append(safeZone).append("\n");
		}
        
		sb.append(maxSafeZone);
		
		System.out.print(sb.toString());
		
		br.close();
        


    }

    static void bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] spot = q.poll();


            for(int i=0; i<4; i++) {
                int nx = spot[0] + dx[i];
                int ny = spot[1] + dy[i];

                if(nx >= 0 && nx <N && ny >= 0 && ny< N && !visited[nx][ny] && map[nx][ny] >h) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true; //방문 표시.
                   // sb.append("bfs에 들어옴").append("\n");
                }
            }


        }
    }

}