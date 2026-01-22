import java.io.*;
import java.util.*;

public class Main {

    static int N; //3^k (3~3^7)
    static char[][] starMap;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        input();
        printStar(0, 0, N, false);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(starMap[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        starMap = new char[N][N];
        sb = new StringBuilder(N*(N+1)); //용량 설정 후랑 그냥 비교해보기. 최초 용량 16인데 범위 넘어서면 확장하는데 비용이듦
    }
    public static void printStar(int x, int y, int size, boolean isBlank) {
        if(isBlank){
            for(int i=x; i<=x+size; i++){
                for(int j=y; j<=y+size; j++){
                    starMap[i][j] = ' ';
                }
            }
            return;
        }
        if(size == 1){
            starMap[x][y] = '*';
            return;
        }

        int reSize = size/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) {
                    printStar(x + i*reSize, y + j*reSize, reSize, true);
                } else {
                    printStar(x + i*reSize, y + j*reSize, reSize, false);
                }
            }
        }
    }
}