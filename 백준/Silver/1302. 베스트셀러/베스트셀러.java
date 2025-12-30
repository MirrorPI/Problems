import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<String, Integer> books;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        books = new HashMap<>();
        for(int i=0; i<N; i++){
            String book = br.readLine();
            books.put(book, books.getOrDefault(book, 0) + 1);
        }

        String best = null;
        int max = 0;
        for(Map.Entry<String, Integer> book : books.entrySet()){
            String name = book.getKey();
            int cnt = book.getValue();
            if(cnt > max) {
                max = cnt;
                best = name;
            } else if(cnt == max) {
                if(best == null || name.compareTo(best) < 0) {
                    best = name;
                }
            }
        }
        System.out.print(best);
    }
}