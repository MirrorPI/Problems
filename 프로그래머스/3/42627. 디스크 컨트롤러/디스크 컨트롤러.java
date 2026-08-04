import java.util.*;

class Solution {
    
    class Job {
        int number;
        int requestTime;
        int duration;
        
        Job(int number, int requestTime, int duration) {
            this.number = number;
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }
    
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        int jobCount = jobs.length;
        for(int i=0; i<jobCount; i++) {
            jobList.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        Collections.sort(jobList, (j1, j2) -> {
            return Integer.compare(j1.requestTime, j2.requestTime);
        });
        
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> {
            if(j1.duration == j2.duration) {
                if(j1.requestTime == j2.requestTime) {
                    return Integer.compare(j1.number, j2.number);
                }
                return Integer.compare(j1.requestTime, j2.requestTime);
            }
            return Integer.compare(j1.duration, j2.duration);
        });
        
        int waitingIndex = 0;
        int currTime = 0;
        int totalReturnTime = 0;
        int completedJobCount = 0;
        
        
        while(completedJobCount < jobCount) {
            if(pq.isEmpty()) {
                currTime = Math.max(currTime, jobList.get(waitingIndex).requestTime);
            }
            for(int i=waitingIndex; i<jobCount; i++) {
                Job job = jobList.get(i);
                if(currTime >= job.requestTime) {
                    pq.add(job);
                    waitingIndex++;
                } else {
                    break;
                }
            }

            
            Job currJob = pq.poll();
            int finishTime = currTime;
            if(currTime < currJob.requestTime) {
                currTime = currJob.requestTime;
            }
            currTime += currJob.duration;
            totalReturnTime += currTime - currJob.requestTime;
            completedJobCount++;
        }
        
        return totalReturnTime / jobCount;
    }
}