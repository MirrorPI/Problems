import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<int[]> innerSquareSize = new ArrayList<>();
        for(int i=1; i*i<=yellow; i++) {

            if(yellow%i != 0) continue;
            
            innerSquareSize.add(new int[] {yellow/i, i});
        }
        
        for(int[] arr : innerSquareSize) {
            int w = arr[0];
            int h = arr[1];
            
            if((w+2) * 2 + h * 2 == brown) {
                return new int[] {w+2, h+2};
            }
        }
        
        return new int[] {-1, -1};
    }
}