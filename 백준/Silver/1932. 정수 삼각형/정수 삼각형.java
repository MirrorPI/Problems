import java.io.*;
import java.util.*;

public class Main {

    static int N; //(1~500)
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=N-1; i>0; i--){
            for(int j=0; j<i; j++){
                tree[i-1][j] += Math.max(tree[i][j], tree[i][j+1]);
            }
        }


        System.out.print(tree[0][0]);
    }
}