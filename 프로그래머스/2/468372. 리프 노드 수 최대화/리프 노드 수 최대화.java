class Solution {
    public int solution(int dist_limit, int split_limit) {
        int maxLeaf = 1;  // 초기 리프 1개 (루트의 자식)
        
        // 경로곱 2^i × 3^j ≤ split_limit을 만족하는 모든 (i, j) 시도
        for (int i = 0; Math.pow(2, i) <= split_limit; i++) {
            for (int j = 0; Math.pow(2, i) * Math.pow(3, j) <= split_limit; j++) {
                // i개의 2-블록층, j개의 3-블록층으로 트리 구성
                int leafCount = simulate(dist_limit, i, j);
                maxLeaf = Math.max(maxLeaf, leafCount);
            }
        }
        
        return maxLeaf;
    }
    
    int simulate(int dist_limit, int twoLayers, int threeLayers) {
        int frontier = 1;  // 현재 프런티어 크기 (리프 노드 수)
        int usedDist = 0;  // 사용한 분배 노드 수
        
        // 1단계: 2-블록층 처리 (위에서부터)
        for (int layer = 0; layer < twoLayers; layer++) {
            if (usedDist + frontier <= dist_limit) {
                // 완전 분배 가능
                usedDist += frontier;
                frontier *= 2;
            } else {
                // 부분 분배
                int remaining = dist_limit - usedDist;
                frontier = frontier - remaining + remaining * 2;
                return frontier;
            }
        }
        
        // 2단계: 3-블록층 처리 (아래에)
        for (int layer = 0; layer < threeLayers; layer++) {
            if (usedDist + frontier <= dist_limit) {
                // 완전 분배 가능
                usedDist += frontier;
                frontier *= 3;
            } else {
                // 부분 분배
                int remaining = dist_limit - usedDist;
                frontier = frontier - remaining + remaining * 3;
                return frontier;
            }
        }
        
        return frontier;
    }
}