//1. 엘리베이터와 거리가 짧은 방.
//2. 거리가 같으면 아래층.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W, N; //호텔의 층수, 각 층의 방 수, 몇번째 손님. 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int floor = N%H;
			int room = N/H + 1;
			if(floor == 0) {
				floor = H;
			}
			if(H == 1) {
				room = N;
			}
			if(N%H == 0) {
				room = N/H;
			}
			if(room <10) {
				sb.append(floor).append("0").append(room);
			}else {
				sb.append(floor).append(room);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
