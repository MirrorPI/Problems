import java.io.*;
import java.util.*;

public class Main {

    static boolean[] selfNum;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        selfNum = new boolean[10001];
        for(int i=1; i<10000; i++){
            int dn = 0;
            if(i<10) {
                dn = i + i;
            } else if(i<100) {
                dn = i + i/10 + i%10;
            } else if(i<1000) {
                dn = i + i/100 + (i%100)/10 + i%10;
            } else {
                dn = i + i/1000 + (i%1000)/100 + (i%100)/10 + i%10;
            }
            if(dn > 10000) continue;
            selfNum[dn] = true;
        }
        for(int i=1; i<10000; i++){
            if(!selfNum[i]) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}