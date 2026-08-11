import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // deque 생성
        // Array's consisted of [alphabet, priority]
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            deque.offer(new int[]{i, priorities[i]});
        }

        while(!deque.isEmpty()){
            // max priority btn remaining nums
            int max = 0;
            for(int[] curr : deque){
                int cNum = curr[1];
                max = Math.max(max, cNum);
            }

            int[] curr = deque.pollFirst();

            // check if it's max
            if(curr[1]==max){
                answer++;
                if(curr[0]==location) return answer;
            }
            else{
                deque.offerLast(curr);
            }
        }
        return answer;
    }
}
