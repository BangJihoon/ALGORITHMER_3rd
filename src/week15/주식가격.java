package week15;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] solution = solution2(prices);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    /*
    정확성  테스트
    테스트 1 〉	통과 (0.16ms, 77.5MB)
    테스트 2 〉	통과 (0.34ms, 81.6MB)
    테스트 3 〉	통과 (1.65ms, 83.4MB)
    테스트 4 〉	통과 (1.39ms, 79.1MB)
    테스트 5 〉	통과 (1.85ms, 80MB)
    테스트 6 〉	통과 (0.20ms, 75.3MB)
    테스트 7 〉	통과 (0.87ms, 71.8MB)
    테스트 8 〉	통과 (0.99ms, 78MB)
    테스트 9 〉	통과 (0.21ms, 73.5MB)
    테스트 10 〉	통과 (1.64ms, 68.9MB)
    효율성  테스트
    테스트 1 〉	통과 (77.02ms, 73.2MB)
    테스트 2 〉	통과 (28.31ms, 63.4MB)
    테스트 3 〉	통과 (39.27ms, 76.3MB)
    테스트 4 〉	통과 (32.34ms, 71.2MB)
    테스트 5 〉	통과 (25.90ms, 66.7MB)
    */
    public static int[] solution(int[] prices) {
        // 스텍을 이용해 O(n)순회
        int[] res = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {// 가격이 떨어졌다면,
                res[st.peek()] = i - st.peek(); // 숫자를 기록한다.
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            res[st.peek()] = prices.length - 1 - st.peek();
            st.pop();
        }
        return res;
    }
/*
정확성  테스트
테스트 1 〉	통과 (0.02ms, 72.1MB)
테스트 2 〉	통과 (0.03ms, 73MB)
테스트 3 〉	통과 (0.21ms, 74.8MB)
테스트 4 〉	통과 (0.15ms, 75.4MB)
테스트 5 〉	통과 (0.28ms, 70.9MB)
테스트 6 〉	통과 (0.03ms, 71.5MB)
테스트 7 〉	통과 (0.13ms, 83.9MB)
테스트 8 〉	통과 (0.16ms, 77.5MB)
테스트 9 〉	통과 (1.22ms, 75.2MB)
테스트 10 〉	통과 (0.25ms, 81.2MB)
효율성  테스트
테스트 1 〉	통과 (14.54ms, 68.7MB)
테스트 2 〉	통과 (10.54ms, 63.6MB)
테스트 3 〉	통과 (25.09ms, 73.1MB)
테스트 4 〉	통과 (15.85ms, 70.1MB)
테스트 5 〉	통과 (11.09ms, 66.3MB)
*/
    public static int[] solution2(int[] prices) {
        // 완전탐색은 n2 순회
        int[] res = new int[prices.length];
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++) {
                res[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return res;
    }
}