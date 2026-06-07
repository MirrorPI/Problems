import java.util.*;

class Solution {
    
    class Num {
        int num;
        boolean isActive;
        
        Num(int num) {
           this.num = num;
            this.isActive = true;
        }
        void disable() {
            this.isActive = false;
        }
    }
    
    public int[] solution(String[] operations) {
        PriorityQueue<Num> minPq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1.num, n2.num);
        });
        PriorityQueue<Num> maxPq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n2.num, n1.num);
        });
        
        
        for(String s : operations) {
            StringTokenizer st = new StringTokenizer(s);
            char cmd = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            
            if(cmd == 'I') {
                Num n = new Num(num);
                minPq.add(n);
                maxPq.add(n);
            } else {
                if(num == 1) {
                    while(!maxPq.isEmpty()) {
                        Num n = maxPq.poll();
                        if(n.isActive) {
                            n.disable();
                            break;
                        }
                    }
                    
                    
                } else if(num == -1) {
                    while(!minPq.isEmpty()) {
                        Num n = minPq.poll();
                        if(n.isActive) {
                            n.disable();
                            break;
                        }
                    }
                }
            }
        }
        int max = 0;
        int min = 0;
        while(!maxPq.isEmpty()) {
            Num n = maxPq.poll();
            if(n.isActive) {
                max = n.num;
                break;
            }
        }
        while(!minPq.isEmpty()) {
            Num n = minPq.poll();
            if(n.isActive) {
                min = n.num;
                break;
            }
        }
        int[] answer = {max, min};
        
        return answer;
    }
}