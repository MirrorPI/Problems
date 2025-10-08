import java.io.*;
import java.util.*;

public class Main {

    static int n; //선물의 개수 (1~100,000)
    static int b; //예산 (1~10^9)
    static int a; //반값할인 가능한 선물 개수 (0~n)
    static int[] present; //선물의 가격 (2~10^9), 2의 배수
    static long[] totalPrice; //i+1 번째까지 선물의 총 가격.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        present = new int[n];
        totalPrice = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            present[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(present);

        int basket = 0; //장바구니에 들어있는 선물의 개수
        int saleNum = 0; //할인한 선물의 개수
        for(int i=0; i<n; i++){
            totalPrice[i] = (i == 0 ? present[0] : totalPrice[i-1] + present[i]);
            if (totalPrice[i] <= b) basket = i + 1;
            else break;
        }
        if(basket == n || a == 0) {
            System.out.print(basket);
            return;
        }
//        for(int i=0; i<3; i++){
//            System.out.println(totalPrice[i] + " " + basket);
//        }
        for(int i=0; i<basket; i++){
            if(saleNum == a) break;
            totalPrice[basket-1] -= present[basket-1-i]/2;
            saleNum++;
        }
        while(true){
            if(basket == n) break;

            if(saleNum == a){
                totalPrice[basket] = totalPrice[basket-1] + present[basket-saleNum]/2 + present[basket]/2;
                if(totalPrice[basket] <= b) {
                    basket++;
                } else {
                    break;
                }
            } else {
                if(basket == 0){
                    totalPrice[basket] = present[basket]/2;
                } else {
                    totalPrice[basket] = totalPrice[basket-1] + present[basket]/2;
                }
                if(totalPrice[basket] <= b){
                    basket++;
                    saleNum++;
                } else {
                    break;
                }
            }
        }
        System.out.print(basket);
    }
}