import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int cap = Integer.parseInt(st.nextToken());

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int max = 0;  // 가장 먼 거리 (마지막에 가면 안 돌아옴)

        for (int i = 0; i < num; i++) {
            int position = Integer.parseInt(st.nextToken());
            max = Math.max(max, Math.abs(position));

            if (position > 0) {
                pos.add(position);
            } else {
                neg.add(Math.abs(position));  // 절댓값으로
            }
        }

        // 내림차순 정렬 (먼 곳부터)
        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg, Collections.reverseOrder());

        int result = 0;

        // 음수 위치 처리
        for (int i = 0; i < neg.size(); i += cap) {
            result += neg.get(i) * 2;
        }

        // 양수 위치 처리
        for (int i = 0; i < pos.size(); i += cap) {
            result += pos.get(i) * 2;
        }

        // 가장 먼 곳은 마지막에 가므로 돌아올 필요 없음
        result -= max;

        System.out.println(result);
    }
}