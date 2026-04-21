import java.util.*;

class Solution {
    int[] method2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
    int[] method3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    public int[] solution(int[] answers) {
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (i % 5 + 1 == answers[i]) score1++;
            
            if (method2[i % 8] == answers[i]) score2++;
            
            if (method3[i % 10] == answers[i]) score3++;
        }
        
        int max = 0;
        max = Math.max(max, score1);
        max = Math.max(max, score2);
        max = Math.max(max, score3);
        
        List<Integer> l = new ArrayList<>();
        if (max == score1) l.add(1);
        if (max == score2) l.add(2);
        if (max == score3) l.add(3);
        
        int[] answer = new int[l.size()];

        for (int i = 0; i < l.size(); i++) {
            answer[i] = l.get(i);
        }

        return answer;
        
    }
}