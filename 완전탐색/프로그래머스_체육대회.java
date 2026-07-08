class Solution {

    static int max = -1;
    static int person, kind;
    static boolean[] visited;

    public int solution(int[][] ability) {
        person = ability.length;
        kind = ability[0].length;

        visited = new boolean[person];

        dfs(ability, 0, 0);

        return max;
    }

    public void dfs(int[][] ability, int cnt, int sum){
        // base case
        if(cnt==kind){
            max = Math.max(max, sum);
            return;
        }

        //recursion
        for(int i=0; i<person; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(ability, cnt+1, sum+ability[i][cnt]);
                visited[i] = false;
            }
        }
    }
}
