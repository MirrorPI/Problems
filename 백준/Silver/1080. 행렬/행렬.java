import java.io.*;
import java.util.*;

public class Main {

    static int N, M; //(1~50)
    static boolean[][][] matrix;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new boolean[2][N][M];
        for(int i=0; i<2; i++){
            for(int x=0; x<N; x++){
                String input = br.readLine();
                for(int y=0; y<M; y++){
                    if(input.charAt(y) == '1'){
                        matrix[i][x][y] = true;
                    }
                }
            }
        }
        if(N < 3 || M < 3) {
            if(!check()){
                System.out.print(-1);
                return;
            }
        }
        for(int x=0; x<N; x++){
            for(int y=0; y<M; y++){
                if(matrix[0][x][y] == matrix[1][x][y]) continue;

                if(x+2 < N && y+2 < M){
                    flip(x, y);
                }
            }
        }
        if(!check()){
            System.out.print(-1);
        } else {
            System.out.print(count);
        }
    }
    static void flip(int x, int y){
        count++;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                matrix[0][x+i][y+j] = !matrix[0][x+i][y+j];
            }
        }
    }
    static boolean check() {
        for(int x=0; x<N; x++){
            for(int y=0; y<M; y++){
                if(matrix[0][x][y] != matrix[1][x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}