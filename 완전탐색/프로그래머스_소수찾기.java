import java.util.*;

class Solution {
    boolean[] visited;
    Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        // visited 배열 생성하기
        int len = numbers.length();
        visited = new boolean[len];

        // dfs 보내기
        dfs("", numbers);

        // 소수 판별부
        int answer = 0;
        for(int num : numberSet){
            if(isPrime(num)) answer++;
        }

        return answer;
    }

    public void dfs(String current, String numbers){
        // result
        if(!current.equals("")){
            numberSet.add(Integer.parseInt(current));
        }

        // recursion
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }

    // 소수 판별 함수
    public boolean isPrime(int num){
        int cnt = 0;
        if(num < 2) return false;

        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
