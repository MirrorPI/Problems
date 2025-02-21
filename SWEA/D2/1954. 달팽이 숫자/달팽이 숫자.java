import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

static int[] dx = new int[] {-1, 1, 0, 0}; //상하좌우
static int[] dy = new int[] {0, 0, -1, 1};
static StringBuilder sb = new StringBuilder();

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    for(int i=0; i<T; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] snail = new int[n+2][n+2];
        boolean[][] visited = new boolean[n+2][n+2];
        
        int direction = 3;

        int data = 1;
        int x = 1; 
        int y = 1;
        snail[1][1] = data;
        visited[1][1] = true;
        int count = 1;
        while(count <= n*n-1) {
        	//System.out.println(count);
            
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if(visited[nx][ny] || nx == n+1 || ny == n+1 || nx == 0 || ny == 0) {
                if(direction == 0) { // 위로 움직였을 때
                    direction = 3;
                } else if(direction == 1) { //아래로 움직였을 때
                    direction = 2;
                } else if(direction == 2) { //왼쪽으로 움직였을 때
                    direction = 0;
                } else if(direction == 3) { //오른쪽으로 움직였을 때
                    direction = 1;
                }
                continue;
               
            }else {
                x= nx;
                y= ny;
            }
            data++;
            snail[x][y] = data;
            visited[x][y] = true;
            count++;
        }
        sb.append("#").append(i+1).append("\n");
        for(int j=1; j<=n; j++) {
            for(int k=1; k<=n; k++) {
                sb.append(snail[j][k]).append(" ");
            }
            sb.append("\n");
        }

        
        
    }
    System.out.println(sb);
}
}