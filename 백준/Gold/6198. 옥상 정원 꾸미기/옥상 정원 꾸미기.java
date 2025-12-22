import java.io.*;
import java.util.*;


public class Main {
    static class Building {
        int num;
        int height;

        Building(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Building> st = new Stack<>();
        long result = 0;
        for (int i = 0; i < N; i++) {
            int currHeight = Integer.parseInt(br.readLine());
            while (!st.isEmpty() && st.peek().height <= currHeight) {
                Building prev = st.pop();
                result += i - prev.num - 1;
            }

            st.push(new Building(i, currHeight));
        }

        while (!st.isEmpty()) {
            Building prev = st.pop();
            result += N - prev.num - 1;
        }

        System.out.println(result);
    }
}