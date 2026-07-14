import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열을 -1로 초기화 (도달할 수 없는 상태 표시)
        int[] DP = new int[N];
        Arrays.fill(DP, -1);
        
        // 첫 번째 위치의 점프 횟수는 0
        DP[0] = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {

                // j번째 위치에 도달한 적이 없는 경우 건너뜀
                if (DP[j] == -1) continue;
                
                // j위치에서 i위치로 점프가 가능한지 확인
                if (j + nums[j] >= i) {
                    if (DP[j] + 1 > DP[i]) {
                        DP[i] = DP[j] + 1;
                    }
                }
            }
        }

        // 첫 번째 위치에서 출발하여 도달할 수 있는 최대 점프 횟수 찾기
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (DP[i] > max) {
                max = DP[i];
            }
        }
        
        System.out.println(max);
    }
}