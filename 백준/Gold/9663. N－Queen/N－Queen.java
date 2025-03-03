import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] board;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N]; //board[x] = y; x번째 줄 y번째 퀸을 둠.
		
		solve(0);
		System.out.print(cnt);
		
		br.close();
	}
	public static void solve(int x) {
		if(x == N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) { //어디 y에 둘지 0 부터 돌면서 확인.
			board[x] = i;
			
			if(check(x)) {
				solve(x+1); //다음 줄 둘 y 가 있는지 확인 아니면 solve(x+1) 종료 후 solve(x) 내 반복문 i++ 되면서 y값 변경 후 solve(x+1) 호출하고 확인을 반복. 
			}
		}
	}
	public static boolean check(int x) { //새로들어온 x번째 줄에 둘 곳이 있는지 확인. x = 0은 무조건 true;
		for(int i=0; i<x; i++) {
			if(board[x] == board[i] || x - i == Math.abs(board[x] - board[i])) {
				return false;
			}
		}
		
		return true;
	}
}
