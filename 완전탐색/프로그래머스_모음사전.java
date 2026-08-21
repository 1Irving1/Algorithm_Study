class Solution {
    private char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private int count = 0;
    private int answer = 0;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    public boolean dfs(String curr, String target) {
        // Base Case: 목표 단어를 찾은 경우
        if (curr.equals(target)) {
            answer = count;
            return true; // 상위 호출들에 찾았음을 전달하여 조기 종료
        }

        // 최대 길이 5에 도달한 경우
        if (curr.length() == 5) {
            return false;
        }

        // Recursion
        for (char v : vowels) {
            count++;
            if (dfs(curr + v, target)) {
                return true;
            }
        }

        return false;
    }
}
