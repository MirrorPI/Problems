import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K; //물품의 수(1~100), 버틸 수 있는 무게(1~100,000)
	static int[] W, V; //물건의 무게(1~100,000), 물건의 가치(0~1000)
	static int[] bag; //bag[현재 무게] = 최대 가치
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N+1];
		V = new int[N+1];
		bag = new int[K+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int w=K; w>0; w--) {
				if(w >= W[i]) {
					bag[w] = Math.max(bag[w],bag[w - W[i]] + V[i]);	
				}
			}
		}
		System.out.print(bag[K]);
		br.close();
	}
}
