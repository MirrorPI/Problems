import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S; //정수의 수, 목표 합.
	static int[] arr;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		for(int i=0; i<N; i++) { //input 확인용.
//			System.out.print(arr[i] + " ");
//		}
		solve(-1, 0);
		if(S == 0) cnt--;
		System.out.print(cnt);
		
		br.close();
	}
	private static void solve(int here, int sum) {
		if(sum == S) {
			cnt++;
		}
		for(int next = here+1; next<N; next++) {
			solve(next, sum + arr[next]);
		}
	}
}
