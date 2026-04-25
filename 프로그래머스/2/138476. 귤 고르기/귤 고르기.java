import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> cnt = new HashMap<>();
        
        for (int t : tangerine) {
            cnt.put(t, cnt.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> num = new ArrayList<>();
        for (int c : cnt.keySet()) {
            num.add(cnt.get(c));
        }
        
        Collections.sort(num, Collections.reverseOrder());
        
        int answer = 0;
        for (int i = 0; i < num.size(); i++) {
            if (k - num.get(i) <= 0) {
                answer++;
                break;
            }
            
            answer++;
            k -= num.get(i);
        }
        
        return answer;
    }
}