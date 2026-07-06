import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int len = a.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++) {
            sb.append(a.charAt(i)).append('\n');
        }
        
        System.out.print(sb);
    }
}