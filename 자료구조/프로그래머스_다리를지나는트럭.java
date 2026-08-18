import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights){
        Deque<int[]> deque = new ArrayDeque<>();

        int time = 1; // 현재 경과시간
        int currWeight = truck_weights[0]; // 현재 다리 위의 무게
        deque.offerLast(new int[]{truck_weights[0], time});

        int index = 1;

        while(!deque.isEmpty()){
            time++;

            // truck이 다리를 다 건넌 경우 deque에서 제외
            int[] sample = deque.peekFirst();
            if(time - sample[1]==bridge_length){
                deque.pollFirst();
                currWeight-=sample[0];
            }

            // truck이 올라갈 수 있으면 올라가기
            if(index < truck_weights.length){
                int nextWeight = truck_weights[index];
                if(currWeight + nextWeight <= weight){
                    deque.offerLast(new int[]{truck_weights[index], time});
                    currWeight+=nextWeight;
                    index++;
                }
            }
        }
        return time;
    }
}
