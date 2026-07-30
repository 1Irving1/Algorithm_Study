import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        int answer = 0;
        int limit = nums.length / 2;

        for(int i=0; i<nums.length; i++){
            numbers.add(nums[i]);
        }

        int size = numbers.size();

        answer = limit > size ? size : limit;
        return answer;
    }
}
