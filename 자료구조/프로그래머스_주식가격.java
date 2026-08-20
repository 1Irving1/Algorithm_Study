import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        int time = 0;
        // 0번 인덱스 삽입
        stack.push(0);

        for(int i=1; i<prices.length; i++){
            time++;
            // while 같은 거 사용해서 stack.peek보다 작은 놈 있으면 계속 answer 계산해서 넣어주기
            while(!stack.isEmpty() && prices[stack.peek()]>prices[i]){
                int curr = stack.pop();
                answer[curr] = time - curr;
            }

            stack.push(time);
        }

        // stack에 남은 애들 계산
        while(!stack.isEmpty()){
            int curr = stack.pop();
            answer[curr] = time - curr;
        }

        return answer;
    }
}
