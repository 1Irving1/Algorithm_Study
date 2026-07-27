class Solution {
    public int solution(int[][] sizes) {
        //크기 정렬
        for(int i=0; i<sizes.length; i++){
            //크기 비교
            if(sizes[i][0] > sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        // 각 열에서 가장 큰 값 찾기
        int max_0 = 0;
        int max_1 = 0;
        for(int i=0; i<sizes.length; i++){
            int curr_0 = sizes[i][0];
            int curr_1 = sizes[i][1];

            if(curr_0>max_0) max_0 = curr_0;
            if(curr_1>max_1) max_1 = curr_1;
        }

        // 결과값 도출
        int answer = max_0 * max_1;
        System.out.println(answer);

        return answer;
    }
}
