import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N; //지방의 수, 3~10,000
	static int[] budget; //각 지방의 예산요쳥, 1~100,000
	static int total; //국가예산 총액, N~1,000,000,000
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		budget = new int[N];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, budget[i]);
		}
		//Arrays.sort(budget);
		total = Integer.parseInt(br.readLine());
		solve(0, max, total);
		System.out.print(result);
	}
	public static void solve(int start, int end, int target) {
		if(start > end) return;
		
		int mid = (start + end)/2;
		int sum = 0;
		for(int i=0; i<N; i++) {
			if(budget[i] > mid){
				sum += mid;
			} else {
				sum += budget[i];
			}
		}
		if(sum <= target) {
			result = mid;
			solve(mid+1 , end, target);
			return;
		} else {
			solve(start, mid-1, target);
		}
	}
}
