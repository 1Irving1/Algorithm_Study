import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        stack.push(number.charAt(0));

        // k개를 모두 채웠는지 확인하는 코드
        int count = 0;
        for(int i=1; i<number.length(); i++){
            char current = number.charAt(i);

            if(count==k){
                stack.offerLast(current);
                continue;
            }

            // 만약 peek 했을 때 가장 위에 있는 놈보다 크면 pop하고 새로운 놈 push
            while(!stack.isEmpty() && stack.peekLast()<current && count < k){
                stack.pollLast();
                count++;
            }
            stack.offerLast(current);
        }

        while(count<k){
            stack.pollLast();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }

        String result = sb.toString();

        // System.out.println(result);

        return result;
    }
}
