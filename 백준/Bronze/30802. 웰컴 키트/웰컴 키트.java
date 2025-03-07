import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N; //참가자의 수 1~1,000,000,000
	static int T; //같은 사이즈를 한번에 T장만큼 구매가능. 
	static int[] num = new int[6];
	static int P; //펜 한번에 P개만큼 구매가능. 
	static int minT; //티셔츠 구매시, 최대 묶음 수.
	static int maxP; //펜 묶음 구매시 최대 묶음 수.
	static int numP; //펜 낱개 구매 수.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		for(int i=0; i<6; i++) {
			if(T==1) {
				minT += num[i];
			} else {
				if(num[i] == 0) {
					continue;
				} else if(num[i] > T){
					if(num[i]%T == 0) {
						minT += num[i]/T;
					} else {
						minT += num[i]/T + 1;
					}
					
				} else {
					minT += 1;
				}
			}
		}
		if(N < P) {
			maxP = 0;
			numP = N;
		} else if(N == P) {
			maxP = 1;
			numP = 0;
		} else {
			maxP = N/P;
			numP = N%P;
		}
		sb.append(minT).append("\n").append(maxP).append(" ").append(numP);
		System.out.print(sb);
	}
}
