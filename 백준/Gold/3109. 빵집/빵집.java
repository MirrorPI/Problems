import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

static int R;
static int C;
static char[][] map;
static final int[] dx = {-1, 0, 1};  //우상 우 우하
static final int dy = 1;
static boolean[][] visited;
static int result = 0;

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    map = new char[R][C]; //지도.
	    
	    for(int i=0; i<R; i++) {
	        String data = br.readLine();
	        for(int j=0; j<C; j++) {
	            map[i][j] = data.charAt(j);
	        }
	    }
	    visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            int x=i;
            int y=0;
            findPipeLine(x, y);
            if(visited[R-1][C-1]) {
            	break;
            }
        }
        System.out.print(result);
        br.close();
	}
	    public static boolean findPipeLine(int x, int y) {
	        if(x==-1 || x==R) return false;
	
	        if(y == C-1) {
	            result++;
	            visited[x][y] = true;
	            return true;
	        }
	
	        if(visited[x][y] || map[x][y] == 'x') return false;
	
	        visited[x][y] = true;
	       
	    if(!findPipeLine(x-1, y+1)) {
	        if(!findPipeLine(x, y+1)) {
	            if(!findPipeLine(x+1, y+1)) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
}