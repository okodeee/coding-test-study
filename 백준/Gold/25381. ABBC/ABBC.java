import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        // B의 인덱스들을 저장할 큐 (A와 짝지을 용도, C와 짝지을 용도)
        Deque<Integer> bIdxs = new ArrayDeque<>();
        boolean[] used = new boolean[n];
        int result = 0;

        // 모든 B의 위치를 저장
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') bIdxs.add(i);
        }

        // B-C 매칭 (C 입장에서는 앞에 있는 B가 필요)
        // 앞에서부터 순회하며 C를 만나면, 사용 가능한 가장 앞의 B를 매칭
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'C') {
                // C보다 앞에 있는 B가 있는지 확인
                while (!bIdxs.isEmpty() && bIdxs.peekFirst() < i) {
                    int bPos = bIdxs.pollFirst();
                    used[bPos] = true;
                    used[i] = true;
                    result++;
                    break; // 매칭 성공 시 다음 C로
                }
            }
        }

        // A-B 매칭 (A 입장에서는 뒤에 있는 B가 필요)
        // 뒤에서부터 순회하며 A를 만나면, 남은 B 중 가장 뒤에 있는 B를 매칭
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'A' && !used[i]) {
                // A보다 뒤에 있는 B가 남아있는지 확인
                while (!bIdxs.isEmpty() && bIdxs.peekLast() > i) {
                    int bPos = bIdxs.pollLast();
                    if (!used[bPos]) {
                        used[bPos] = true;
                        used[i] = true;
                        result++;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
