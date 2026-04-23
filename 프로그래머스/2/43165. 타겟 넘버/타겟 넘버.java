class Solution {
    int answer = 0;
    int length;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        length = numbers.length;
        
        dfs(0, 0);
        
        return answer;
    }
    
    void dfs(int depth, int sum) {
        if (depth == length) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum - numbers[depth]);
    }
}