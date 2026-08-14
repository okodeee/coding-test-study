import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 10000;

    public static int M;
    public static int root;
    public static int[] deg = new int[MAX_N + 1];
    public static ArrayList<Integer>[] graph = new ArrayList[MAX_N + 1];
    public static boolean[] used = new boolean[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static boolean isTree = true;

    public static void dfs(int x) {
        for(int i = 0; i < graph[x].size(); i++) {
            int y = graph[x].get(i);

            if(visited[y]) 
                continue;
            
            visited[y] = true;
            dfs(y);
        }
    
        return;
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= MAX_N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[u].add(v);

            // 해당 번호가 그래프에 있는 정점 번호인지 판단
            used[u] = used[v] = true;

            // 정점 별 들어오는 간선의 개수를 저장
            deg[v]++;
        }

        // 루트 노드 찾기
        for(int i = 1; i <= MAX_N; i++) {
            if(used[i] && deg[i] == 0) {
                // 이미 선정된 루트가 있다면 
                // 루트가 여러 개인 것이므로 트리 X
                if (root != 0) {
                    isTree = false;
                    System.out.println(0);
                    return;
                }
                root = i;
            }
        }

        // 루트 노드가 없으면 트리가 아닙니다.
        if(root == 0) {
            isTree = false;
            System.out.println(0);
            return;
        }
        
        // 루트 노드를 제외한 노드는 모두 들어오는 간선이 1개씩 있음
        // 그렇지 않으면 트리 X
        for(int i = 1; i <= MAX_N; i++) {
            if(used[i] && i != root && deg[i] != 1) {
                isTree = false;
                System.out.println(0);
                return;
            }
        }

        if (isTree && root != 0) {
            // root 정점으로부터 모든 정점을 갈 수 있는지 판단
            visited[root] = true;
            dfs(root);
        }

         // root 정점으로부터 탐색해 도달하지 못하는 정점이 있으면 트리 X
        for(int i = 1; i <= MAX_N; i++) {
            if(used[i] && !visited[i]) {
                isTree = false;
                System.out.println(0);
                return;
            }
        }

        if(isTree) System.out.print(1);
        else System.out.print(0);
    }
}