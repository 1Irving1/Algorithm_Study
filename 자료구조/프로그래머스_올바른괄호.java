import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            if(curr=='(') stack.push(curr);
            else{
                if(stack.isEmpty()) stack.push(curr);
                else if(stack.peek()=='(') stack.pop();
            }
        }

        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}
