import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>();
        for(int i=0; i<gems.length; i++) {
            gemTypes.add(gems[i]);
        }
        
        int gemTypeCount = gemTypes.size();
        int start = 0;
        int end = 0;
        Map<String, Integer> gemCounts = new HashMap<>();
        gemCounts.put(gems[0], 1);
        
        
        int minStart = Integer.MAX_VALUE;
        int minEnd = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;
        while(start <= end) {
            if(gemCounts.size() == gemTypeCount && minLength > end - start + 1) {
                minEnd = end + 1;
                minStart = start + 1;
                minLength = end - start + 1;
            }

            if(gemCounts.size() == gemTypeCount) {
                String startGem = gems[start];
                
                if(gemCounts.get(startGem) == 1) {
                    gemCounts.remove(startGem);
                } else {
                    gemCounts.put(startGem, gemCounts.get(startGem) - 1);
                }
                
                start += 1;
            } else {
                if(end + 1 >= gems.length) break;
                
                end += 1;
                gemCounts.put(gems[end], gemCounts.getOrDefault(gems[end], 0) + 1);
            }

        }
        return new int[] {minStart, minEnd};
    }
}