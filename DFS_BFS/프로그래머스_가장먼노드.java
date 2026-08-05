import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[] distances;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new List[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new LinkedList<>();
        }

        int r = edge.length;
        for(int i=0; i<r; i++){
            int a = edge[i][0];
            int b = edge[i][1];

            graph[a].add(b);
            graph[b].add(a);
        }

        // 1번과 나머지 노드들의 거리 찾기
        // 이게 알고리즘의 핵심
        distances = new int[n+1];
        bfs(n);

        // distances 중에서 가장 큰 숫자들끼리 세기
        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(max, distances[i]);
        }

        // 가장 큰 숫자인 애들 answer에 더하기
        for(int i=1; i<=n; i++){
            if(max==distances[i]) answer++;
        }

        System.out.println(max);

        return answer;
    }

    public void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        distances[1] = 1; // 일단 방문처리를 위해서 1로 편법적으로 설정

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int node : graph[curr]){
                if(distances[node]!=0) continue;
                distances[node] = distances[curr] + 1;
                q.offer(node);
            }
        }
    }
}
