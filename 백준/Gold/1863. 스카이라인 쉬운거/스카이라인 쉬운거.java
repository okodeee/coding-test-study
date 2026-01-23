import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> height = new Stack<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!height.isEmpty() && height.peek() > y) {
                height.pop();
                result++;
            }

            if (!height.isEmpty() && height.peek() == y || y == 0) continue;

            height.push(y);
        }

        while (!height.isEmpty()) {
            height.pop();
            result++;
        }

        System.out.println(result);
    }
}
