import java.util.*;

class Solution {

    int[][] expandedRectangle;
    int expandedCharacterX;
    int expandedCharacterY;
    int expandedItemX;
    int expandedItemY;
    final int SIZE = 105;
    int[][] map;
    int[][] dist;
    final int[] dx = {-1, 1, 0, 0};
    final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[SIZE][SIZE];
        dist = new int[SIZE][SIZE];
        
        expandCordinate(rectangle, characterX, characterY, itemX, itemY);
        clearInsideOfFrame(expandedRectangle);
        
        return bfs(expandedCharacterX, expandedCharacterY, expandedItemX, expandedItemY) / 2;
    }

    //1111
    //1111 이런 사각형이 있다고 생각하면 중간 공백이 없어서
    //테두리와 내부를 분리할 수 없음, 그래서 모든 좌표를 2배함으로써 중간 공백을 만들어줌
    public void expandCordinate(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        expandedRectangle = new int[rectangle.length][4];

        expandedCharacterX = 2 * characterX;
        expandedCharacterY = 2 * characterY;
        expandedItemX = 2 * itemX;
        expandedItemY = 2 * itemY;
        for(int i=0; i<rectangle.length; i++){
            expandedRectangle[i][0] = 2 * rectangle[i][0];
            expandedRectangle[i][1] = 2 * rectangle[i][1];
            expandedRectangle[i][2] = 2 * rectangle[i][2];
            expandedRectangle[i][3] = 2 * rectangle[i][3];
        }
    }
    public void fillRectangle(int[][] rectangle) {

        for(int[] r : rectangle) {
            fillMap(r[0], r[1], r[2], r[3], 1);
        }
    }
    public void clearInsideOfFrame(int[][] rectangle) {
        fillRectangle(rectangle);
        
        for(int[] r : rectangle) {
            fillMap(r[0]+1, r[1]+1, r[2]-1, r[3]-1, 0);
        }
    }
    public void fillMap(int x1, int y1, int x2, int y2, int fillNum) {
        for(int x=x1; x<=x2; x++) {
            for(int y= y1; y<=y2; y++) {
                map[x][y] = fillNum;
            }
        }
    }
    public int bfs(int startX, int startY, int targetX, int targetY) {
        for(int i=0; i<SIZE; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY});
        dist[startX][startY] = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            if(x == targetX && y == targetY) return dist[x][y];
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE) continue;
                if(map[nx][ny] == 0) continue;
                if(dist[nx][ny] != -1) continue;
                
                q.add(new int[] {nx, ny});
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
        return -1;
    }
}