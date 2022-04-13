package week21;

/*정확성  테스트
테스트 1 〉	통과 (2.50ms, 77.2MB)
테스트 2 〉	통과 (0.16ms, 80.1MB)
테스트 3 〉	통과 (0.09ms, 75.8MB)
테스트 4 〉	통과 (27.91ms, 76.4MB)
테스트 5 〉	통과 (21.99ms, 80.1MB)
테스트 6 〉	통과 (1.08ms, 75.6MB)
테스트 7 〉	통과 (0.73ms, 72.8MB)
테스트 8 〉	통과 (32.33ms, 91.2MB)
테스트 9 〉	통과 (0.12ms, 73.7MB)
 */

import java.util.HashSet;
import java.util.Set;

public class N으로표현{
    static int answer = 9;
    public static int solution(int N, int number) {
        // 1-8번까지의 N사 용 횟수별로 만들 수 있는 모든 수를 중복없이 저장
        Set<Integer>[] set = new HashSet[9]; // 0번은 편의상 미사용
        int n = 0;
        // 초기화 (1~8까지 n의 연속수를 넣어줌 - ex) 5,55,555,5555,...
        for (int i = 1; i < 9; i++) {
            n = (n * 10) + N;
            set[i] = new HashSet<>();
            set[i].add(n);
        }
        // 이전 연산들을 이용해서 모든 경우를 만들어줌
        for (int i = 1; i <= 8; i++) { // 2번째부터 ~ 8번째까지 만들어줄꺼임 (1번은 n만 들어가므로 이미 완선된 상태)
            for (int j = 1; j < i; j++) { // 1번째(n)부터 만들어주고자하는 set배열 밑에 번호까지의 조합을 전부 add
                for (Integer a : set[j]) { // j번째와
                    for (Integer b : set[i - j]) { // i-j번째의 사칙연산의 조합을 저장
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        // 나눗셈만 연산자 우선순위를 고려해야하므로 두가지 경우로 연산
                        if (b != 0) {
                            set[i].add(a / b);
                        }
                        if (a != 0) {
                            set[i].add(b / a);
                        }
                    }
                }
            }
            if (set[i].contains(number)) {
                answer = i;
                return answer;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // 5.12.4
        // 2,11,3
        int N = 5;
        int number = 26;
        System.out.println(solution(N,number));
    }
}
