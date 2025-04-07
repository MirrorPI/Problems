import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M; //물건의 종류(1~100), 최대 무게(1~10,000)
	static ArrayList<Integer> V, C; //무게, 만족도
	static int[] bag; //bag[최대 무게가 w일 때] = 최대 만족도 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = new ArrayList<>();
		C = new ArrayList<>();
		bag = new int[M+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken()); //같은 물건의 개수 
			int pack = 1; // 여러 개의 물건을 하나의 묶음으로 생각.
			int sum = 0;
			boolean packagingEnd = false;
			while(true) {
				V.add(v * pack);
				C.add(c * pack);
				sum += pack;
				pack *= 2;
				
				if(packagingEnd) break;
				
				if(k - sum - pack <= 0) {
					pack = k - sum; // 묶음 내 물건의 개수가 총 개수를 넘어갈 거 같으면 나머지를 하나의 묶음으로 처리 
					packagingEnd = true;
				}
				//n개의 물건을 한개씩 생각하면 시간복잡도가 너무 올라감 -> n이라는 숫자는 1 2 4 8 ... 2^k 의 구성으로 만들 수 있어서 묶음으로 만들어서 계산.
				//냅색 알고리즘은 모든 물건을 고려하기 때문에 묶음 내 물건의 개수의 총 합이 원래 개수 k를 넘기면 안됨.
			}
		}
		for(int i=0; i<V.size(); i++) {
			for(int w=M; w>0; w--) {
				if(w >= V.get(i)) {
					bag[w] = Math.max(bag[w], bag[w - V.get(i)] + C.get(i));
				}
			}
		}
		System.out.print(bag[M]);
		br.close();
	}
}
