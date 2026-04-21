import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 정렬하여 내가 이미 등록된 번호의 접두어인지 확인 못하는 경우 해결
        Arrays.sort(phone_book);
        
        Map<String, Integer> subCnt = new HashMap<>();
        
        for (String phone : phone_book) {
            for (int i = 1; i <= phone.length(); i++) {
                if (subCnt.getOrDefault(phone.substring(0, i), 0) > 0) {
                    return false;
                }
            }
            
            subCnt.put(phone, 1);
        }
        
        return true;
    }
}