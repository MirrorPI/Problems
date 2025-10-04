import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = br.readLine().split("-");

        int ans = 0;
        for(int i=0; i<minus.length; i++){
            String[] plus = minus[i].split("\\+");
            //+ 자체로 정규표현식에 대한 기호이기 때문에 리터럴 자체로 "+" 를 쓰려면 \\+ 나 [+]로 escape 해야한다.
            int temp = 0;
            for(int j=0; j<plus.length; j++){
                temp += Integer.parseInt(plus[j]);
            }
            if(i==0){
                ans += temp;
            } else {
                ans -= temp;
            }
        }
        System.out.print(ans);
    }
}