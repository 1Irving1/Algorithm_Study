class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        // total의 약수 중에서 정답이 나온다
        // w와 h 모두 약수여야 한다. 가로의 길이가 세로의 길이보다 같거나 크다
        for(int h=3; h<=total/2; h++){
            //h는 세로, w는 가로
            int w = total / h;

            // w나 h가 약수가 아니라면 continue
            if(total%h != 0) continue;

            // 약수라면 검증 시작
            if(((w-2) * (h-2) == yellow) && w * h==total){
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }

        return answer;
    }
}
