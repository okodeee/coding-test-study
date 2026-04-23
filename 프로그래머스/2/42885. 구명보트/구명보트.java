import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int heaviest = people.length - 1;
        int lightest = 0;
        
        int answer = 0;
        while (heaviest > lightest) {
            // 가벼운 사람도 같이 탐
            if (people[heaviest] + people[lightest] <= limit) lightest++;

            answer++;
            heaviest--;
        }
        
        if (heaviest == lightest) answer++;
        
        return answer;
    }
}