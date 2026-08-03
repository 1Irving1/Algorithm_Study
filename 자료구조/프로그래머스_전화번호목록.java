import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> nums = new HashSet<>();
        for(String num : phone_book){
            nums.add(num);
        }

        //
        for(String num : phone_book){
            for(int i=1; i<num.length(); i++){
                if(nums.contains(num.substring(0, i))){
                    return false;
                }

            }

        }


        return answer;
    }
}
