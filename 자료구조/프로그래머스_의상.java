import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int row = clothes.length;
        int col = clothes[0].length;
        Map<String, Integer> comb = new HashMap<>();

        for(String[] cloth : clothes){
            String category = cloth[1];
            comb.put(category, comb.getOrDefault(category, 0) + 1);
        }

        int answer = 1;
        for(int count : comb.values()){
            answer *= (count + 1);
        }

        answer --;

        return answer;
    }
}
