import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	static int N; //재료 갯수
	//static int sumPoint; // 점수 합 저장
	//static int sumCal; // 칼로리 합 저장
	static int maxPoint; // 최대 점수
	static int maxCal; // 최대 칼로리
	static int[][] info; //점수, 칼로리 정보 저장.
	static boolean[] visited; //방문 기록
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sumPoint = 0;
			int sumCal = 0;
			maxPoint = 0;
			N = Integer.parseInt(st.nextToken()); // 재료의 갯수
			visited = new boolean[N]; //방문 기록.
			maxCal = Integer.parseInt(st.nextToken()); //최대 칼로리
			info = new int[N][2]; //[0] 점수, [1] 칼로리
			
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				info[j][0] = Integer.parseInt(st.nextToken()); //점수 저장
				info[j][1] = Integer.parseInt(st.nextToken()); //칼로리 저장
				
				//System.out.println(info[j][0] + " " + info[j][1]); //저장 확인 -> good!
			}
			bestHamburger(0, sumPoint, sumCal);
			sb.append("#").append(i+1).append(" ").append(maxPoint).append("\n");
			
		}
		System.out.println(sb);

	}
	
	public static void bestHamburger(int index, int sumPoint, int sumCal) {
//		if(index == N) {//마지막 재료까지 탐색하면 종료.
//			//maxPoint = Math.max(maxPoint, sumPoint);
//			return;
//		}
		
//		if(sumCal + info[index][1]> maxCal) { //다음 재료 칼로리합이 최대 넘기면 종료.
//			return;
//		}
//		if(sumCal > maxCal) { //다음 재료 칼로리합이 최대 넘기면 종료.
//			maxPoint = Math.max(maxPoint, sumPoint);
//			return;
//		}
		
		for(int i=index; i<N; i++) {
//			sumCal += info[i][1]; //칼로리
			
			if(sumCal + info[i][1] <= maxCal) {
				//sumPoint += info[i][0]; //점수
				//System.out.println(sumCal + " " + sumPoint);
				maxPoint = Math.max(maxPoint, sumPoint + info[i][0]);
				bestHamburger(i+1, sumPoint+ info[i][0], sumCal  + info[i][1]);
			}
			
		}
	}
}
