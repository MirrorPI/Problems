import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T; 
	static int[] pay = new int[4]; //각 1일, 한달, 세달, 1년 이용 가격
	static int[] plan = new int[13]; //12개월 이용계획;	
	static int[] total = new int[13]; //total[n] = n월까지 최소 비용;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 T = Integer.parseInt(br.readLine());
		 for(int t=1; t<=T; t++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 for(int i=0; i<4; i++) {
				 pay[i] = Integer.parseInt(st.nextToken());
			 }
			 st = new StringTokenizer(br.readLine());
			 for(int i=1; i<=12; i++) {
				 plan[i] = Integer.parseInt(st.nextToken());
			 }
			 
			 total[1] = Math.min(plan[1] * pay[0], pay[1]); // 1월까지 최소비용은 1일씩 비용을 내는 경우 or 1달 비용을 내는 경우
			 total[2] = total[1] + Math.min(plan[2] * pay[0], pay[1]); //1월까지 최소비용 + (하루치 계산 or 한달치 계산)
			 total[3] = Math.min(total[2] + Math.min(plan[3]*pay[0], pay[1]), pay[2]); //(2월까지 최소비용 + 하루치 계산 or 한달치 계산) or 3개월치 계산
			 for(int i=4; i<=12; i++) {
				 total[i] = Math.min(
						 		total[i-1] + Math.min(plan[i] * pay[0], pay[1])
						 		, total[i-3] + pay[2]);
			 }
			 if(total[12] > pay[3]) {
				 ans = pay[3];
			 } else {
				 ans = total[12];
			 }
			 sb.append("#").append(t).append(" ").append(ans).append("\n");
		 }
		 
		 System.out.print(sb);
		 br.close();
	}
}
