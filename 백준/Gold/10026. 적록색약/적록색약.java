import java.io.*;
import java.util.*;

public class Main {

    static int N; //1~100
    static char[][] map;
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    static int cntRGB, cntRB;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j);
            }
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]) continue;

                q.add(new int[] {i, j, map[i][j]});
                visited[i][j] = true;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    int color = cur[2];
                    for(int d=0; d<4; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) continue;

                        if(map[nx][ny] == color){
                            q.add(new int[] {nx, ny, color});
                            visited[nx][ny] = true;
                        }
                    }
                }
                cntRGB++;
            }
        }

        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]) continue;

                q.add(new int[] {i, j, map[i][j]});
                visited[i][j] = true;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    int color = cur[2];
                    for(int d=0; d<4; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) continue;

                        if(color == map[nx][ny] ||
                                (color == 'R' && map[nx][ny] == 'G' || color == 'G' && map[nx][ny] == 'R')){
                            q.add(new int[] {nx, ny, color});
                            visited[nx][ny] = true;
                        }
                    }
                }
                cntRB++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cntRGB).append(" ").append(cntRB);
        System.out.print(sb);
    }
}