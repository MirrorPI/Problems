import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int[] tree;
    static int max;
    static int one;
    static int two;
    static int ans;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            tree = new int[N];
            one = 0;
            two = 0;
            ans = 0;
            max = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int a = Integer.parseInt(st.nextToken());
                tree[i] = a;
                max = Math.max(max, a);
            }

            for(int i=0; i<N; i++){
                tree[i] = max - tree[i];
                if(tree[i] % 2 == 1){
                    one += 1;
                }
                two += tree[i]/2;
            }
            /// //////////////////////////////////////////////////////////////////////
//            for(int i=0; i<N; i++){
//                System.out.print(tree[i]+" ");
//            }
//            System.out.println();
//            System.out.println(one + " " + two);
            /// //////////////////////////////////////////////////////////////////////
            if(one > two){
                if(one == 1){
                    ans += 1;
                } else {
                    ans += one * 2 - 1;
                }
            } else if(two > one) {
                ans += one * 2;
                two -= one;
//                if(two == 1) {
//                    ans += 2;  // 0 2
//                } else if(two == 2){
//                    ans += 3; // 1 2 1
//                } else if(two == 3){
//                    ans += 4; //1 2 1 2
//                } else if(two == 4){
//                    ans += 6; //1 2 1 2 0 2
//                }
                if(two%3 == 1){
                    ans += (two/3) * 4 + 2;
                } else if(two%3 == 2){
                    ans += (two/3) * 4 + 3;
                } else if(two % 3 == 0){
                    ans += (two/3) * 4;
                }
            } else {
                ans += one * 2;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}




//1
//        30
//        35 8 19 40 12 17 11 29 14 21 31 39 28 33 16 19 34 12 12 10 28 40 6 19 36 19 10 2 34 22
//
//        #1 276


