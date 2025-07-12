import java.util.*;
import java.io.*;

public class Main {

	static int[][] sudoku = new int[10][10];
	static boolean[][] existH = new boolean[10][10]; // r번째 줄에 j 숫자가 있나 없나
	static boolean[][] existV = new boolean[10][10]; // c번째 줄에 j 숫자가 있나 없나
	static boolean[][] existB = new boolean[10][10]; // n번째 블럭에 j 숫자가 있나 없나 
	static StringBuilder sb = new StringBuilder();
	static boolean goodjob = false;
	
	static ArrayList<int[]> blank = new ArrayList<>(); //채워야할 빈칸의 좌표
 	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int i=1; i<=9; i++) {
			String line = br.readLine();
			for(int j=1; j<=9; j++) {
				int a = line.charAt(j-1) - '0';
				sudoku[i][j] = a;
				if(a == 0) {
					blank.add(new int[] {i, j});
					continue;
				}
				existH[i][a] = true;
				existV[j][a] = true;
				existB[block(i, j)][a] = true;
			}
		}
		
//		for(int i=1; i<=9; i++) {
//			for(int j=1; j<=9; j++) {
//				System.out.print(sudoku[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		solve(0);
		System.out.print(sb);
		br.close();
		
	}
	private static void solve(int idx) {
		if(idx == blank.size()) {
			for(int i=1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			goodjob = true;
			return;
		}
		
		int nowX = blank.get(idx)[0];
		int nowY = blank.get(idx)[1];
		for(int i=1; i<=9; i++) {
			if(!existH[nowX][i] && !existV[nowY][i] && !existB[block(nowX, nowY)][i] && !goodjob) {
				sudoku[nowX][nowY] = i;
				existH[nowX][i] = true;
				existV[nowY][i] = true;
				existB[block(nowX, nowY)][i] = true;
				solve(idx + 1);
				sudoku[nowX][nowY] = 0;
				existH[nowX][i] = false;
				existV[nowY][i] = false;
				existB[block(nowX, nowY)][i] = false;
			}
		}
	}
	private static int block(int x, int y) { //1 2 3 4 5 6 7 8 9, 좌표가 주어지면 몇번째 블럭인지 반환
		x -= 1;
		y -= 1;
		return (x/3) * 3 + y/3 + 1;
	}
}
