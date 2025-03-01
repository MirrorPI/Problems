import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T =Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());  //4~16
			int[][] synergy = new int[N][N]; //1~20000
			int m = (int)(Math.pow(2,N));
			int[] ingredients = new int[m];  //주어진 모든 조합 비트.
			for(int j=0; j<m; j++) {
				ingredients[j] = j+1;
			}
			int[] ingredientsA = new int[N/2]; //A가 쓸 재료
			int[] ingredientsB = new int[N/2]; //B가 쓸 재료
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<N; k++) {
					synergy[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for(int j=0; j<N; j++) {   //입력 확인용 코드.
//				for(int k=0; k<N; k++) {
//					System.out.print(synergy[j][k] + " ");
//				}
//				System.out.println();
//			}
			int result = selectAndSynergySum(N, synergy,  ingredients, ingredientsA, ingredientsB);
			
			sb.append("#").append(i+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	private static int selectAndSynergySum(int N, int[][] synergy, int[] ingredients, int[] ingredientsA, int[] ingredientsB){
		int flag = 1;
		int minDifference =  987_654_321;
		for(int i=0; i<ingredients.length; i++) {
			int countA = 0;
			
			
			List<Integer> indexA = new ArrayList<>();
			List<Integer> indexB = new ArrayList<>();
			for(int j=0; j<N; j++) {
				if((i+1 & flag << j) == flag << j) { //재료 선택, 조합, 비트마스킹
					countA++;
					indexA.add(j);
				} else {
					indexB.add(j);
				}
			}
			if(countA == N/2) {
				
				int sumA = 0;
				int sumB = 0;
				int difference = 0;
//				indexA.forEach(o -> System.out.print(o + " "));
//				System.out.println();
//				indexB.forEach(o -> System.out.print(o + " "));
//				System.out.println("\n------------------------------");
				for(int j=0; j<N/2; j++) {
					ingredientsA[j] = indexA.get(j);
					ingredientsB[j] = indexB.get(j);
				}
				
				for(int j=0; j<N/2; j++) {
					for(int k=0; k<N/2; k++) {
						sumA = sumA + synergy[ingredientsA[k]][ingredientsA[j]];
						sumB = sumB + synergy[ingredientsB[k]][ingredientsB[j]];
					}
				}
				difference = Math.abs(sumA - sumB);
				if(difference < minDifference) {
					minDifference = difference;
				}
			}
		}
		
		return minDifference;
	}
}
