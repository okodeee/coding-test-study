import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> lines = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines.add(new int[] {a, b});
        }

        Collections.sort(lines, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        int maxLen = 0;
        int currentStart = lines.get(0)[0];
        int currentEnd = lines.get(0)[1];

        for (int i = 1; i < n; i++) {
            int nextStart = lines.get(i)[0];
            int nextEnd = lines.get(i)[1];

            // 구간이 겹치거나 이어지는 경우
            if (nextStart <= currentEnd) {
                currentEnd = Math.max(currentEnd, nextEnd);
            
            // 구간이 끊긴 경우
            } else {
                maxLen = Math.max(maxLen, currentEnd - currentStart);
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }
        
        // 마지막으로 남아있던 구간
        maxLen = Math.max(maxLen, currentEnd - currentStart);

        System.out.println(maxLen);
    }
}