import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int K = scanner.nextInt();
        int M = scanner.nextInt();
        // Please write your code here.
        
        HashMap<Long, Integer> cnt = new HashMap<>();

        for (int i = 0; i < S.length() - K; i++) {
            String curr = S.substring(i, i + K); 
            long p = Long.parseLong(curr, 2);
            cnt.put(p, cnt.getOrDefault(p, 0) + 1);
        }

        for (int value : cnt.values()) {
            if (value >= M) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}