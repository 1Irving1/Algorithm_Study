import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> people = new HashMap<>();

        String answer = "";

        for(String person : participant){
            people.put(person, people.getOrDefault(person, 0) + 1);
        }

        // 완주한 선수 빼기
        for(String person : completion){
            people.put(person, people.get(person) - 1);
        }

        // people에서 value 값이 1이면 그놈을 answer로 두고 return
        for(String person : people.keySet()){
            if(people.get(person) == 1){
                answer = person;
                break;
            }
        }

        return answer;
    }
}
