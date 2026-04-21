import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // <의상의 종류, 항목 수>
        Map<String, Integer> cnt = new HashMap<>();
        
        for (String[] cloth : clothes) {
            cnt.put(cloth[1], cnt.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        for (String key : cnt.keySet()) {
            answer *= cnt.get(key) + 1;
        }
        
        return answer - 1;  // 아무것도 안 입은 상태 제외
    }
}