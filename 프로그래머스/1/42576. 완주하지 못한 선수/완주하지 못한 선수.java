import java.io.*;
import java.util.*;

class Solution {
    
    static HashMap<String, Integer> participants;
    static String answer;
    
    public String solution(String[] participant, String[] completion) {
        participants = new HashMap<>();
        for(String p : participant) {
            //key 있으면 value를 +1, 없으면 value에 1 
            participants.put(p, participants.getOrDefault(p, 0) + 1);
        }
        for(String c : completion) {
            //참가자 명단에 완주자 있으면 value에 -1
            if(participants.containsKey(c)) {
                participants.put(c, participants.get(c) - 1);
            }
        }
        for(String p : participant) {
            //참가자 중에 완주자 처리 후 인원이 남아 있으면 완주하지 못한 선수
            if(participants.get(p) != 0){
                answer = p;
                break;
            } 
        }

        return answer;
    }
}