import java.util.*;

class Solution {
    int n;
    int[][] dice;
    int maxWins = 0;
    int[] answer;
    
    public int[] solution(int[][] dice) {
        this.n = dice.length;
        this.dice = dice;
        this.answer = new int[n / 2];
        
        selectDice(0, 0, new int[n / 2]);
        
        // 주사위 번호는 1부터 시작 (인덱스 0 → 주사위 1)
        for (int i = 0; i < answer.length; i++) {
            answer[i] += 1;
        }
        
        return answer;
    }
    
    // A의 주사위 조합 선택 (인덱스만 저장)
    void selectDice(int start, int depth, int[] selectedA) {
        if (depth == n / 2) {
            // B의 주사위 인덱스 계산
            int[] selectedB = new int[n / 2];
            boolean[] isSelectedA = new boolean[n];
            for (int idx : selectedA) {
                isSelectedA[idx] = true;
            }
    
            int bIdx = 0;
            for (int i = 0; i < n; i++) {
                if (!isSelectedA[i]) {
                    selectedB[bIdx++] = i;
                }
            }
            
            // A의 모든 합 경우의 수 계산
            List<Integer> sumsA = new ArrayList<>();
            calculateAllSums(selectedA, 0, 0, sumsA);
    
            // B의 모든 합 경우의 수 계산
            List<Integer> sumsB = new ArrayList<>();
            calculateAllSums(selectedB, 0, 0, sumsB);
    
            // B를 정렬 (이분 탐색 준비)
            Collections.sort(sumsB);
    
            // 승패 계산 (이분 탐색으로 최적화)
            int wins = 0;
            for (int sumA : sumsA) {
                // sumA보다 작은 sumB의 개수를 이분 탐색으로 찾기
                wins += lowerBound(sumsB, sumA);
            }
    
            // 최대 승수 갱신
            if (wins > maxWins) {
                maxWins = wins;
                answer = selectedA.clone();
            }
    
            return;
        }
    
        for (int i = start; i < n; i++) {
            selectedA[depth] = i;  // 주사위 번호만 저장
            selectDice(i + 1, depth + 1, selectedA);
        }
    }
    
    // sumA보다 작은 원소의 개수 반환
    int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
    
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
    
        return left;
    }
    
    // 재귀로 모든 주사위 합 계산
    void calculateAllSums(int[] selectedDice, int depth, int currentSum, List<Integer> sums) {
        if (depth == selectedDice.length) {
            sums.add(currentSum);
            return;
        }
    
        for (int i = 0; i < 6; i++) {
            calculateAllSums(selectedDice, depth + 1, currentSum + dice[selectedDice[depth]][i], sums);
        }
    }
}