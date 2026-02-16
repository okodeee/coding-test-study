import java.io.*;
import java.util.*;

public class Main {
    static class Building {
        int num;
        int height;
        int visible;
        int closest;

        Building(int n, int h) {
            this.num = n;
            this.height = h;
            this.visible = 0;
            this.closest = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Building[] buildings = new Building[N + 1];
        for (int i = 1; i <= N; i++) {
            buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
        }

        Stack<Building> stack = new Stack<>();

        // 왼쪽에서 볼 수 있는 건물 수 세기
        for (int i = 1; i <= N; i++) {
            Building curr = buildings[i];  // 현재 빌딩 높이

            // 볼 수 없는 건물 빼기
            while (!stack.isEmpty() && stack.peek().height <= curr.height) {
                stack.pop();
            }

            curr.visible += stack.size();
            if (curr.visible != 0) {
                curr.closest = stack.peek().num;    // 가장 가까운 건물
            }
            stack.push(curr);
        }

        // 오른쪽에서 볼 수 있는 건물 수 세기
        stack.clear();
        for (int i = N; i > 0; i--) {
            Building curr = buildings[i];  // 현재 빌딩 높이

            // 볼 수 없는 건물 빼기
            while (!stack.isEmpty() && stack.peek().height <= curr.height) {
                stack.pop();
            }

            curr.visible += stack.size();
            if (!stack.isEmpty() && curr.closest == 0) {
                curr.closest = stack.peek().num;
            } else if (!stack.isEmpty() && Math.abs(i - curr.closest) > Math.abs(i - stack.peek().num)) {
                curr.closest = stack.peek().num;    // 가장 가까운 건물
            }
            stack.push(curr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            Building b = buildings[i];

            sb.append(b.visible);

            if (b.closest != 0) {
                sb.append(' ').append(b.closest);
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}