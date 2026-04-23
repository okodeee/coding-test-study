import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        int[][] distance = new int[N][M];
        distance[0][0] = 1;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        
        visited[0][0] = true;
        q.offer(new int[] { 0, 0 });
        
        int[] dx = new int[] { 0, 0, -1, 1 };
        int[] dy = new int[] { -1, 1, 0, 0 };
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || maps[nx][ny] == 0) continue;
                distance[nx][ny] = distance[curr[0]][curr[1]] + 1;
                visited[nx][ny] = true;
                q.offer(new int[] { nx, ny });
            }
        }
        
        if (!visited[N - 1][M - 1]) return -1;
        
        return distance[N - 1][M - 1];
    }
}