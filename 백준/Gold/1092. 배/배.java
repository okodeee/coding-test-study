import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크레인 무게 제한 입력
        int N = Integer.parseInt(br.readLine());
        Integer[] craneLimits = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            craneLimits[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(craneLimits, Collections.reverseOrder());

        // 박스 무게 입력
        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        boxes.sort(Collections.reverseOrder());

        // 옮길 수 없는 박스가 있는지 체크
        if (craneLimits[0] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;

        while (!boxes.isEmpty()) {
            int craneIdx = 0;

            for (int i = 0; i < boxes.size() && craneIdx < N; ) {
                if (craneLimits[craneIdx] >= boxes.get(i)) {
                    boxes.remove(i);  // 박스 옮김
                    craneIdx++;       // 다음 크레인
                } else {
                    i++;
                }
            }

            time++;
        }

        System.out.println(time);
    }
}
