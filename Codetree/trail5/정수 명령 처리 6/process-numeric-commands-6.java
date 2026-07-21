import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = Integer.parseInt(br.readLine().trim());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());            
            String command = st.nextToken();
            
            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    maxPriorityQueue.add(value);
                    break;
                    
                case "pop":
                    if (!maxPriorityQueue.isEmpty()) {
                        sb.append(maxPriorityQueue.poll()).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                    
                case "size":
                    sb.append(maxPriorityQueue.size()).append("\n");
                    break;
                    
                case "empty":
                    if (maxPriorityQueue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                    
                case "top":
                    if (!maxPriorityQueue.isEmpty()) {
                        sb.append(maxPriorityQueue.peek()).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
            }
        }
        
        System.out.print(sb.toString());
    }
}
