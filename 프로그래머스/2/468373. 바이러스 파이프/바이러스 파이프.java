import java.util.*;

class Solution {
    int k;
    int answer = 0;
    List<Integer>[] pipe1;
    List<Integer>[] pipe2;
    List<Integer>[] pipe3;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.k = k;
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        
        pipe1 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            pipe1[i] = new ArrayList<>();
        }
        pipe2 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            pipe2[i] = new ArrayList<>();
        }
        pipe3 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            pipe3[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            if (edge[2] == 1) {
                pipe1[edge[0]].add(edge[1]);
                pipe1[edge[1]].add(edge[0]);
            } else if (edge[2] == 2) {
                pipe2[edge[0]].add(edge[1]);
                pipe2[edge[1]].add(edge[0]);
            } else if (edge[2] == 3) {
                pipe3[edge[0]].add(edge[1]);
                pipe3[edge[1]].add(edge[0]);
            }
        }
        
        dfs(0, infected);
        
        return answer;
    }
    
    void dfs(int depth, boolean[] infected) {
        if (depth == k) {
            int cnt = 0;
            
            for (boolean node : infected) {
                if (node) cnt++;
            }
            
            answer = Math.max(answer, cnt);
            
            return; 
        }
        
        for (int type = 1; type <= 3; type++) {
            Queue<Integer> q = new LinkedList<>();
            
            boolean[] newInfected = infected.clone();
            for (int i = 0; i < newInfected.length; i++) {
                if (newInfected[i]) {
                    q.offer(i);
                }
            }
            
            while(!q.isEmpty()) {
                int node = q.poll();
                
                if (type == 1) {    // type 1
                    for (int next : pipe1[node]) {
                        if (!newInfected[next]) {
                            newInfected[next] = true;
                            q.offer(next);
                        }
                    }
                } else if (type == 2) { // type 2
                    for (int next : pipe2[node]) {
                        if (!newInfected[next]) {
                            newInfected[next] = true;
                            q.offer(next);
                        }
                    }
                } else if (type == 3) { // type 3
                    for (int next : pipe3[node]) {
                        if (!newInfected[next]) {
                            newInfected[next] = true;
                            q.offer(next);
                        }
                    }
                }
                
            }
            
            dfs(depth + 1, newInfected);
        }
    }
}