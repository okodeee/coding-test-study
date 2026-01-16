import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 사대 위치
        int[] shooting = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            shooting[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(shooting);

        // 동물 위치
        List<int[]> animals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals.add(new int[] { x, y });
        }

        // 동물을 잡을 수 있는지 판별
        int result = 0;
        for (int[] position : animals) {
            int x = position[0];
            int y = position[1];

            int differenceX = L - y;
            if (differenceX < 0) continue;

            int left = 0;
            int right = M - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int gunX = shooting[mid];

                if (Math.abs(x - gunX) <= differenceX) {    // 동물 잡기
                    result++;
                    break;
                } else if (x > gunX) {
                    left = mid + 1;
                } else if (x < gunX) {
                    right = mid - 1;
                }
            }
        }

        System.out.println(result);
    }
}