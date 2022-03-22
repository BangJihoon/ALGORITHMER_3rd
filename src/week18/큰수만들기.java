package week18;

import java.util.Iterator;
import java.util.Stack;

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
