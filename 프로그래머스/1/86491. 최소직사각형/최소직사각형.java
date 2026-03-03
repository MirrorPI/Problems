class Solution {
    public int solution(int[][] sizes) {
        int num = sizes.length;
        for(int i=0; i<num; i++){
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        int widthMax = 0;
        int heightMax = 0;
        for(int i=0; i<num; i++){
            widthMax = Math.max(widthMax, sizes[i][0]);
            heightMax = Math.max(heightMax, sizes[i][1]);
        }
        int answer = widthMax * heightMax;
        return answer;
    }
}