import java.io.*;
import java.util.*;

public class Main {

    static int N; //학생 수 (3~1000)
    static int[][] classNum;
    static boolean[][] checked;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classNum = new int[N+1][6];
        checked = new boolean[N+1][N+1];
        cnt = new int[N+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int g=1; g<=5; g++){
                classNum[i][g] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=N; i++){
            for(int g=1; g<=5; g++){
                for(int j=1; j<=N; j++){
                    if(i==j || checked[i][j]) continue;

                    if(classNum[i][g] == classNum[j][g]){
                        checked[i][j] = true;
                        cnt[i]++;
                    }
                }
            }
        }
        int max = 0;
        int ans = 0;
        for(int i=1; i<=N; i++){
            if(max < cnt[i]){
                max = cnt[i];
            }
        }
        for(int i=1; i<=N; i++){
            if(max == cnt[i]){
                ans = i;
                break;
            }
        }

        System.out.print(ans);
    }
}