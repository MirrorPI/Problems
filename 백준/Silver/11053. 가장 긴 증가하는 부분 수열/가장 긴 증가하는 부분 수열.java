import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] A;
	static int[] len;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		len = new int[N];
		Arrays.fill(len, 1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(A[j] < A[i]) {
					len[i] = Math.max(len[i], len[j] + 1);
				}
			}	
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(max, len[i]);
		}
		System.out.print(max);
		br.close();
	}
}