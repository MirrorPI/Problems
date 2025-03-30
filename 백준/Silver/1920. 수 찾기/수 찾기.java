import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
		
	static int N; //수의 개수, 1~100,000
	static int M; //찾아야할 수의 개수, 1~100,000
	static int[] num; //-2^31~2^31-1
	static boolean find;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());	
		}
		Arrays.sort(num);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			find = false;
			int m = Integer.parseInt(st.nextToken());
			solve(0, N-1, m);
			if(find) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.print(sb);
	}
	public static void solve(int start, int end, int target) {
		if(find) return;
		if(start > end) return;
		
		int mid = (start + end)/2;
		if(num[mid] == target) {
			find = true;
			return;
		} else if(num[mid] < target) {
			solve(mid+1, end, target);
		} else {
			solve(start, mid-1, target);
		}
	}
}
