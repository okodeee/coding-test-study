import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String temp = str.substring(0, 1);

        // 사전 반대순으로 temp 구성
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);       // 현재 처리할 문자
            char previous = temp.charAt(i - 1); // temp의 마지막 문자

            if (previous < current) {   // 현재 문자가 이전 문자보다 크면 앞에 추가
                temp = current + temp;
            } else {    // 현재 문자가 이전 문자보다 작거나 같으면 뒤에 추가
                temp = temp + current;
            }
        }

        // 뒤집어서 사전순으로 만들기
        StringBuilder ans = new StringBuilder(temp);
        ans.reverse();

        System.out.println(ans);
    }
}