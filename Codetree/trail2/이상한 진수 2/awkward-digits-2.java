import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '0') {
                StringBuilder sb = new StringBuilder(a);
                sb.setCharAt(i, '1');
                System.out.println(Integer.parseInt(sb.toString(), 2));
                return;
            }
        }

        System.out.println(Integer.parseInt(a, 2) - 1);
    }
}