import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] indegree;
    static List<Integer>[] children;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        children = new ArrayList[N+1];
        indegree = new int[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = st.nextToken();
        }
        Arrays.sort(names);
        // 정렬된 순서대로 1번부터 N번까지 ID 부여
        Map<String, Integer> map = new HashMap<>();
        String[] idToName = new String[N + 1];
        for (int i = 0; i < N; i++) {
            map.put(names[i], i + 1);
            idToName[i + 1] = names[i];
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = map.get(st.nextToken());
            int y = map.get(st.nextToken());
            indegree[x]++;
            graph[y].add(x);
        }

        List<Integer> rootList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                rootList.add(i);
            } 
        }

        while (!q.isEmpty()) {
            int e = q.poll();

            for (int next : graph[e]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    children[e].add(next);
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rootList.size()).append("\n");     
        
        for (int i = 0; i < rootList.size(); i++) {
            sb.append(idToName[rootList.get(i)]).append(" ");
        }
        sb.append("\n");

        for (int i = 1; i <= N; i++) {
            sb.append(idToName[i]).append(" ").append(children[i].size());
            
            Collections.sort(children[i]);
            for (int child : children[i]) {
                sb.append(" ").append(idToName[child]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}