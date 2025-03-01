import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int[] h;
	static int N;
	static int result = 0;
	static int start = 0;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			h = new int[N];
			result = 0;
			start = 0;
			
			for(int j=0; j<N; j++) {
				h[j] = sc.nextInt();
			}
//			for(int j=0; j<N; j++) {
//				System.out.print(h[j] + " ");
//			}

			
			
			
			//System.out.println(idx);
			while(true) {
				find();
				if(start == N-1) break;
			}
			sb.append("#").append(i+1).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
		
		
		
	}
	public static boolean incre(int start) {
		if(h[start] < h[start+1]) {
			return true;
		} else {
			return false;
		}

	}
	public static boolean decre(int start) {
		if(h[start] > h[start+1]) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void find() {

		int cntIn = 0;
		while(true) {
			if(start ==  N-1) {
				break;
			}
			if(incre(start)) {
				start++;
				cntIn++;
			} else {
				break;
			}

		}
		
		int cntDe = 0;
		
		while(true) {
			if(start == N-1) {
				break;
			}
			if(decre(start)) {
				start++;
				cntDe++;
			} else {
				break;
			}
		}
		result += cntIn * cntDe;
	}
}


/*
1
9
1 4 6 5 3 7 9 2 8
*/