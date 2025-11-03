import java.io.*;
import java.util.*;

public class Main {

    static String roomNum;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = new int[10];
        roomNum = br.readLine();
        for(int i=0; i<roomNum.length(); i++){
            int num = roomNum.charAt(i) - '0';
            if(num == 6 || num == 9){
                nums[6]++;
            } else {
                nums[num]++;
            }
        }

        nums[6] = (nums[6] + 1)/2;

        int ans = 0;
        for(int i=0; i<10; i++){
            ans = Math.max(ans, nums[i]);
        }
        System.out.print(ans);
    }
}