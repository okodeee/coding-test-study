import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            st.push(input.charAt(i));

            if (st.size() >= 4) {
                char fourth = st.pop();
                char third = st.pop();
                char second = st.pop();
                char first = st.pop();

                if (first == 'P' && second == 'P' && third == 'A' && fourth == 'P') {
                    st.push('P');
                } else {
                    st.push(first);
                    st.push(second);
                    st.push(third);
                    st.push(fourth);
                }
            }
        }

        if (st.size() == 1 && st.peek() == 'P') {
            System.out.println("PPAP");
            return;
        }

        System.out.println("NP");
    }
}
