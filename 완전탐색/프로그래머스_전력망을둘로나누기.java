import java.util.*;

class Solution {
    List<Integer>[] graph;

    public int solution(int n, int[][] wires) {

        int diff = Integer.MAX_VALUE;

        graph = new LinkedList[n+1];

        // 인접 리스트 만들기
        for(int i=1; i<=n; i++){
            graph[i] = new LinkedList<>();
        }

        // 양방향 그래프 생성
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 간선 별로 끊고 합 구하기
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];

            // 방문 여부 check 배열
            boolean[] visited = new boolean[n+1];
            // 완탐을 통해서 끊고 합 구하기
            int group1 = dfs(v1, v2, visited);

            // diff 찾기
            int group2 = n - group1;

            int currDiff = Math.abs(group1 - group2);
            diff = Math.min(diff, currDiff);
        }

        return diff;
    }

    public int dfs(int v1, int v2, boolean[] visited){
            int count = 1;
            visited[v1] = true;

            for(int next : graph[v1]){
                if(visited[next] || next==v2) continue;

                count+=dfs(next, v2, visited);
            }
            return count;
        }
}
