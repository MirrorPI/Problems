import java.io.*;
import java.util.*;

public class Main {

    static String isbn;
    final static int[] oneThree = {1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1};
    static int ans;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isbn = br.readLine();
        for(int i=0; i<10; i++) {
            int sum = 0;
            ans = i;
            for(int j=0; j<13; j++){
                if(isbn.charAt(j) == '*') {
                    sum += ans * oneThree[j];
                } else {
                    sum += (isbn.charAt(j) - '0') * oneThree[j];
                }
            }
            if(sum % 10 == 0){
                break;
            }
        }
        System.out.print(ans);
    }
}