class Solution {
    int[][] cost;
    int[][] hint;
    int answer = Integer.MAX_VALUE;
    int n;
    
    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        
        this.n = cost.length;
        
        simulate(0, 0, new int[n]);
        
        return answer;
    }
    
    void simulate(int depth, int sum, int[] myHint) {
        if (depth == n) {
            answer = Math.min(answer, sum);
            return;
        }
        
        int currHint = myHint[depth];
        if (currHint >= n) currHint = n - 1;
        int currCost = cost[depth][currHint];
        
        // 해당 스테이지에서 힌트권 구매X
        simulate(depth + 1, sum + currCost, myHint);
        
        // 구매 O
        if (depth == n - 1) return;
        
        int[] newHint = myHint.clone();
        for (int i = 1; i < hint[depth].length; i++) {
            newHint[hint[depth][i] - 1]++;
        }
        simulate(depth + 1, sum + currCost + hint[depth][0], newHint);
    }
}