import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxGold = 0;

        // 1. 마름모의 크기 K를 0부터 2 * (n - 1)까지 순회
        // 모든 구석의 금까지 다 포함할 수 있도록 2 * (n - 1)까지 탐색
        for (int k = 0; k <= 2 * (n - 1); k++) {
            int cost = k * k + (k + 1) * (k + 1); // 마름모 채굴 비용

            // 2. 격자 내의 모든 점 (r, c)를 마름모의 중심으로 설정
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int goldCount = 0;

                    // 3. 중심점 (r, c)로부터 맨해튼 거리가 K 이하인 격자점을 탐색
                    // 격자를 벗어나는 영역까지 효율적으로 검사하기 위해 
                    // 중심점 행(r) 기준 위아래 범위를 k만큼 지정하여 탐색
                    for (int dr = -k; dr <= k; dr++) {
                        int maxDc = k - Math.abs(dr); // 행의 차이에 따른 열의 최대 이동 거리
                        for (int dc = -maxDc; dc <= maxDc; dc++) {
                            int nr = r + dr;
                            int nc = c + dc;

                            // 격자 내부에 있고 금이 존재하는 경우 count 증가
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                if (grid[nr][nc] == 1) {
                                    goldCount++;
                                }
                            }
                        }
                    }

                    // 4. 이익이 0 이상(손해를 보지 않는 경우)일 때 최대 금 개수를 갱신
                    if (goldCount * m >= cost) {
                        maxGold = Math.max(maxGold, goldCount);
                    }
                }
            }
        }

        System.out.println(maxGold);
    }
}
