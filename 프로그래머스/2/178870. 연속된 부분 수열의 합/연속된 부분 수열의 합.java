class Solution {
    public int[] solution(int[] sequence, int k) {
        int length = sequence.length;
        int[] answer = new int[] { 0, length - 1 };
        
        int left = 0;
        int right = 0;
        
        int sum = sequence[0];
        
        while (left <= right && right < length) {
            if (sum == k) {
                if (answer[1] - answer[0] > right - left) {
                    answer = new int[]{ left, right };
                }
                sum -= sequence[left++];  // 왼쪽 줄이기
            } else if (sum > k) {
                sum -= sequence[left++];
            } else {
                if (right + 1 >= length) break;
                
                sum += sequence[++right];
            }
        }
        
        return answer;
    }
}