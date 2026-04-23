import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        Queue<Integer> next = new LinkedList<>();
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                visited[i] = true;
                next.offer(i);
            
                while (!next.isEmpty()) {
                    int curr = next.poll();
                    
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && computers[curr][j] == 1) {
                            visited[j] = true;
                            next.offer(j);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}