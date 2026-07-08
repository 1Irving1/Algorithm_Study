class Solution {
    public String solution(String input_string) {

        // visited가 true인 친구 중 블록이 2개 이상인지 판별 필요
        int[] cntChar = new int[26];
        boolean[] visitedChar = new boolean[26];
        boolean[] result = new boolean[26];

        char current = input_string.charAt(0);
        cntChar[current-'a'] = 1;
        visitedChar[current-'a'] = true;

        for(int i=1; i<input_string.length(); i++){
            current = input_string.charAt(i);
            char last = input_string.charAt(i-1);

            cntChar[current-'a']++;

            // last와 current가 다르면서 visited가 true
            if(visitedChar[current-'a']&&last!=current){
                result[current - 'a'] = true;
            }

            visitedChar[current-'a'] = true;
        }

        // // alphabet 개수 print
        // StringBuilder sb = new StringBuilder();
        // for(int i=0; i<26; i++){
        //     sb.append(cntChar[i]).append(" ");
        // }
        // System.out.println(sb);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(result[i]){
                sb.append((char)('a' + i));
            }
        }

        String answer = sb.toString();
        if(answer.length()==0){
            answer = "N";
        }

        System.out.println(answer);

        return answer;
    }
}
