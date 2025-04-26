import java.io.*;
import java.util.*;
//1 3 5 6 10
//1 3/ 5 6 10
//1 3/ 5 6/ 10

// 2 2 1 4  차이가 큰 거 부터 k-1 개를 자르면 된다
// 2개의 차이가 가장 크다는 것은 그 두개를 포함한 그룹은 그거의 비용 이상이 들기 때문.
public class Main {

    static int N, K; //원생 수(1~300,000), 나눌 그룹 수
    static int[] height; //원생들 키(1~1,000,000,000)
    static int[] diff;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        height = new int[N];
        diff = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<N; i++){
            diff[i] = height[i] - height[i-1];
        }
        Arrays.sort(diff);
        for(int i=1; i<=N-K; i++){
            ans += diff[i];
        }
        System.out.print(ans);
        br.close();
    }
}