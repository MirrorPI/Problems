import java.io.*;
import java.util.*;

public class Main {

    static int N; //빌딩의 수(1~50)
    static int[] height; //빌딩의 높이(1~1,000,000,000)

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        height = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }
    public static void solve() {
        int max = 0;
        for(int i=0; i<N; i++){ //i를 기준으로 오른쪽 방향 증가
            double maxSlope = -Double.MAX_VALUE;
            int cnt = 0;
            for(int j=i+1; j<N; j++){
                double slope = getSlope(i, j);
                if(maxSlope < slope) {
                    maxSlope = slope;
                    cnt++;
                }
            }
            maxSlope = -Double.MAX_VALUE;
            for(int j=i-1; j>-1; j--){ //i를 기준으로 왼쪽으로 증가하는 거 찾기
                double slope = -getSlope(i, j); //좌표평편 뒤집어서 증가(양수)로 생각.
                if(maxSlope < slope) {
                    maxSlope = slope;
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.print(max);
    }
    public static double getSlope(int i, int j) {
        return (double)(height[j]-height[i])/(j-i);
    }
}