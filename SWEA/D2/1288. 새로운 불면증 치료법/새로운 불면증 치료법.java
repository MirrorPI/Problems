import java.io.*;
import java.util.*;

public class Solution{

    static String stringN; //(1~1,000,000)
    static int integerN;
    static boolean[] zeroToNine = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            stringN = br.readLine();
            int base = Integer.parseInt(stringN);
            Arrays.fill(zeroToNine, false);
            int count = 1;
            while(true){
                for(int i=0; i<stringN.length(); i++){
                    if(zeroToNine[stringN.charAt(i) - '0']) continue;

                    zeroToNine[stringN.charAt(i) - '0'] = true;
                }
                if(zeroToNine[0] &&
                        zeroToNine[1] &&
                        zeroToNine[2] &&
                        zeroToNine[3] &&
                        zeroToNine[4] &&
                        zeroToNine[5] &&
                        zeroToNine[6] &&
                        zeroToNine[7] &&
                        zeroToNine[8] &&
                        zeroToNine[9]){
                    sb.append("#").append(t).append(" ").append(stringN).append("\n");
                    break;
                } else {
                    count += 1;
                    integerN = Integer.parseInt(stringN);
                    integerN = count * base;
                    stringN = Integer.toString(integerN);
                }
            }

        }
        System.out.print(sb);
    }

}