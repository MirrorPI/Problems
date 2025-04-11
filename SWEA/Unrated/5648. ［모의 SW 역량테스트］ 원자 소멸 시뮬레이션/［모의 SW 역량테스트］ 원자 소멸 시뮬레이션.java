import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int N; //원자의 수(1~1,000)
	static List<int[]> points; //x, y, d, k 를 저장할 예정
	//0 1 2 3 상하좌우 -> 일반적인 좌표평면 기준 y증가, y감소, x감소, x증가
	static int totalE;
	static boolean[] collapse;
	static int[][] timeTable;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            points = new ArrayList<>();
            totalE = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int d = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                points.add(new int[] {x, y, d, k});
            }
             
            
             
            while(!points.isEmpty()) {
                for(int i=points.size()-1; i>=0; i--) {
                    int dir = points.get(i)[2];
                    if(dir == 0) {
                        points.get(i)[1] += 1;
                    } else if(dir == 1) {
                        points.get(i)[1] -= 1;
                    } else if(dir == 2) {
                        points.get(i)[0] -= 1;
                    } else {
                        points.get(i)[0] += 1;
                    }
                    if(points.get(i)[0] < -2000 || points.get(i)[0] > 2000 || points.get(i)[1] < -2000 || points.get(i)[1] > 2000) {
                        points.remove(i);
                    }
                }
                if(points.size() < 2) break;
                
                Collections.sort(points, (p1, p2) -> {
                	if(p1[0] == p2[0]) return Integer.compare(p1[1], p2[1]);
                	
                	return Integer.compare(p1[0], p2[0]);
                }); 
                Set<Integer> toRemove = new HashSet<>();
               
                for(int i=0; i<points.size()-1; i++) {
                    if(points.get(i)[0] == points.get(i+1)[0] && points.get(i)[1] == points.get(i+1)[1]) {
                        toRemove.add(i);
                        toRemove.add(i+1);
                    }
                    //System.out.print(points.get(i)[3] + " ");
                }
                ArrayList<Integer> tr = new ArrayList<>(toRemove);
                tr.sort(Collections.reverseOrder());
               // System.out.println(toRemove);
                for(int idx : tr) {
                	
                    totalE += points.get(idx)[3];
                    points.remove(idx);
                }
                //System.out.println();
            }
            sb.append("#").append(t).append(" ").append(totalE).append("\n");
        }
         
        System.out.print(sb);
        br.close();
	}
}
