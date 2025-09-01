import java.io.*;

public class Main {

	static int N; 
	static long[][] O; //O로 끝남(L포함, 비포함)
	static long[] L; //L로 끝남
	static long[][][] A; //A로 끝남, AA로 끝남(L포함 비포함)
	static long[] dp;
	static int mod = 1_000_000;
	//개근상을 받으 수 없는 사람 - 지각 두 번 이상, 결석 세 번 연속
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		O = new long[1001][2];
		L = new long[1001];
		A = new long[1001][2][2];
		dp = new long[1001];
		
					//(마지막이 O 인데 L 없고, 없고 구분), (마지막이 L), 마지막이 A인데 (A로 끝남(L포함A로끝, L포함AA로끝)AA로끝)
		//dp[1] =	3 ;//  (1)   +   (1)   +   (1); 	 //(O) (L) (A)
		//dp[2] = 8 ;//(2+1) + (1+1) + (1+(1+0)+1); //(OO LO AO) (OL AL) (OA LA AA)
		//dp[3] = 19;//(4+4) + (2+2) + (2+(3+1)+1); //(OOO LOO AOO OLO ALO OAO LAO AAO) (OOL AOL OAL AAL) (OOA LOA AOA OLA ALA OAA LAA) 
		//dp[4] = 43;//(7+12) + (4+3) + (4+(8+3)+2);
		//dp[5] = 1;//(13+30) + (7+6) + (7+(19+8)+4);
		
		O[1][0] = 1; O[1][1] = 0;  //(O끝 L없음),(O끝 L 있음)
		L[1] = 1; //L끝
		A[1][0][0] = 1; A[1][0][1] = 0; A[1][1][1] = 0; A[1][1][0] = 0; //(A끝 L없음), (A끝 L있음), (AA끝 L있음), (AA끝 L없음)
		
		O[2][0] = O[1][0] + A[1][0][0] + A[1][1][0];
		O[2][1] = O[1][1] + L[1] + A[1][0][1] + A[1][1][1];
		L[2] = O[1][0] + A[1][0][0] + A[1][1][0];
		A[2][0][0] = O[1][0];
		A[2][0][1] = O[1][1] + L[1];
		A[2][1][0] = A[1][0][0];
		A[2][1][1] = A[1][0][1];
		
		for(int i=1; i<N; i++) {
			O[i+1][0] = (O[i][0] + A[i][0][0] + A[i][1][0])%mod;
			O[i+1][1] = (O[i][1] + L[i] + A[i][0][1] + A[i][1][1])%mod;
			L[i+1] = (O[i][0] + A[i][0][0] + A[i][1][0])%mod;
			A[i+1][0][0] = (O[i][0])%mod;
			A[i+1][0][1] = (O[i][1] + L[i])%mod;
			A[i+1][1][0] = (A[i][0][0])%mod;
			A[i+1][1][1] = (A[i][0][1])%mod;
		}
		for(int i=1; i<=N; i++) {
			dp[i] = (O[i][0]%mod + O[i][1]%mod + L[i]%mod + A[i][0][0]%mod + A[i][0][1]%mod + A[i][1][0]%mod + A[i][1][1]%mod)%mod;
		}
		System.out.print(dp[N]);
	}
}