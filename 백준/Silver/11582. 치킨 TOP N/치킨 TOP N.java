import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> newChicken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> chicken = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			chicken.add(Integer.parseInt(st.nextToken()));
		}
		int k = Integer.parseInt(br.readLine());
		
		ksort(N, 2, k, chicken);
		
		for(int i=0; i<N; i++) {
			sb.append(newChicken.get(i)).append(" ");
		}
		System.out.print(sb);
	}
	
	private static void ksort(int N, int n, int k, ArrayList<Integer> chicken) {
		if(N/n < k) return; 
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		newChicken = new ArrayList<>();
		for(int i=0; i<N/n; i++) {
			list.add(new ArrayList<>());
			for(int j=0; j<n; j++) {
				list.get(i).add(chicken.get(i*n + j));
				//System.out.print(chicken.get(i*n + j)); //테스트 
			}
			//System.out.println(); //테스트 
		}
		
		for(int i=0; i<N/n; i++) {
			Collections.sort(list.get(i));
			for(int j=0; j<n; j++) {
				newChicken.add(list.get(i).get(j));
				//System.out.print(list.get(i).get(j)); //테스트 
			}
			//System.out.println(); //테스트 
		}
		

		ksort(N, n*2 ,  k, newChicken);
		
	}
}
