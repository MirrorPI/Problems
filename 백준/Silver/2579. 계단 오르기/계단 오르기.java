import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;  //계단의 수
	static int[] p; //각 계단의 점수
	static int[] max; //각 계단에 도달했을 때 최대 점수.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		p = new int[N+1]; //시작점은 0점.
		max = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			p[i] = Integer.parseInt(br.readLine());
		}
		if(N >= 1) {
			max[1] = p[1];
		}
		if(N >= 2){
			max[2] = max[1] + p[2];
		}
		if(N>=3) {
			for(int i=3; i<=N; i++) {
				max[i] = Math.max(max[i-2], max[i-3] + p[i-1]) + p[i];
			}
		}
		// N개의 배열 중 임의의 위치로 도달하기 위해서는 2칸 전에서 2칸 이동하는 경우 또는 한칸 이동인데 한칸 이동은 그 전 이동이 한칸이동이면 안됨 그래서 3칸전에서 
		//2칸 이동 한칸이동을 한 세트 움직임으로 봐야함.
//		for(int i=0; i<=N; i++) {
//			System.out.print(max[i] + " ");
//		}
		System.out.print(max[N]);
	}
}
