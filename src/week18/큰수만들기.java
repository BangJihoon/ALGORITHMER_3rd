package week18;

import java.util.Iterator;
import java.util.Stack;
/*
정확성  테스트
테스트 1 〉	통과 (0.31ms, 75.2MB)
테스트 2 〉	통과 (0.29ms, 74.4MB)
테스트 3 〉	통과 (0.50ms, 76.7MB)
테스트 4 〉	통과 (1.43ms, 73.1MB)
테스트 5 〉	통과 (2.53ms, 80.1MB)
테스트 6 〉	통과 (8.14ms, 71.7MB)
테스트 7 〉	통과 (14.43ms, 74.5MB)
테스트 8 〉	통과 (17.99ms, 83.6MB)
테스트 9 〉	통과 (45.06ms, 84.2MB)
테스트 10 〉	통과 (87.72ms, 101MB)
테스트 11 〉	통과 (0.27ms, 67.5MB)
테스트 12 〉	통과 (0.26ms, 69.7MB)
*/
public class 큰수만들기 {
    public static void main(String[] args) {
        //ans = 999999955285407310941966307933122347117
        String number="6617423282157290684025607883097699259905250470744165128706131448395502185407310941966307933122347117";
        int k=61;
        System.out.println(solution(number,k));
    }
    // 차례대로 현재수보다 다음수가 크면 현재숫자를 제거하도록 구현
    public static String solution(String number, int k) {
        char[] res = new char[number.length() -k];
        Stack<Character> st = new Stack<>();
        for (char c: number.toCharArray()) {
            // 비어 있으면 push, 안비어있으면 peek와 현재값을 비교해서 peek값이 작으면
            while(!st.isEmpty() && st.peek() < c && k > 0 ){
                st.pop(); // 제일 앞을 제거하고 넣음
                k--;
            }
            st.push(c);
        }
        for (int i = 0; i < res.length; i++)
             res[i] = st.get(i);
        return new String(res);
    }
}
