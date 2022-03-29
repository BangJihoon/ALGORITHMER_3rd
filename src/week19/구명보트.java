package week19;

import java.util.*;

/*
- 무게범위 40-240kg
- 1< n < 50,000 명
- 문제 : 제한무게가 존재하는 2명씩 탈수있는 보트에
        input된 사람들을 모두 실는 최소로 보트의 수를 구하는 문제
- 제한 : 제한무게보다 큰사람은 input되지 않음
* */
public class 구명보트 {
    public static void main(String[] args) {
        //int[] people = {70, 50, 80, 50};
        int[] people = {10,10,10,10};
        int limit = 10;
        System.out.println(solution(people,limit));
    }
/*정확성  테스트
테스트 1 〉	통과 (1.85ms, 75.5MB)
테스트 2 〉	통과 (1.51ms, 79.2MB)
테스트 3 〉	통과 (1.98ms, 75.8MB)
테스트 4 〉	통과 (1.83ms, 77.1MB)
테스트 5 〉	통과 (0.93ms, 76.2MB)
테스트 6 〉	통과 (0.69ms, 77.9MB)
테스트 7 〉	통과 (0.72ms, 77.2MB)
테스트 8 〉	통과 (0.35ms, 70.6MB)
테스트 9 〉	통과 (0.41ms, 74.6MB)
테스트 10 〉	통과 (1.11ms, 79.6MB)
테스트 11 〉	통과 (1.13ms, 69MB)
테스트 12 〉	통과 (1.02ms, 72.5MB)
테스트 13 〉	통과 (1.18ms, 76.1MB)
테스트 14 〉	통과 (0.93ms, 75.6MB)
테스트 15 〉	통과 (0.42ms, 75.9MB)
효율성  테스트
테스트 1 〉	통과 (10.99ms, 54.8MB)
테스트 2 〉	통과 (11.82ms, 55.8MB)
테스트 3 〉	통과 (11.11ms, 53.8MB)
테스트 4 〉	통과 (7.63ms, 54.4MB)
테스트 5 〉	통과 (8.68ms, 53.4MB)
*/
    public static int solution(int[] people, int limit) {
        Arrays.sort(people); // 배열 정렬
        int result=0;
        int idx=0;
        for (int i = people.length-1; i >= idx; i--) {
            if(limit - people[i] >= people[idx])
                idx++;
            result++;
        }
        return result;
    }
    // 데크 사용
/*
정확성  테스트
테스트 1 〉	통과 (4.98ms, 52.7MB)
테스트 2 〉	통과 (3.15ms, 53MB)
테스트 3 〉	통과 (3.46ms, 54MB)
테스트 4 〉	통과 (3.75ms, 52.9MB)
테스트 5 〉	통과 (2.85ms, 53.1MB)
테스트 6 〉	통과 (2.59ms, 52.8MB)
테스트 7 〉	통과 (2.38ms, 53.2MB)
테스트 8 〉	통과 (0.56ms, 52.5MB)
테스트 9 〉	통과 (0.93ms, 52.5MB)
테스트 10 〉	통과 (3.83ms, 53.5MB)
테스트 11 〉	통과 (3.44ms, 54.4MB)
테스트 12 〉	통과 (2.67ms, 53.5MB)
테스트 13 〉	통과 (3.93ms, 52.8MB)
테스트 14 〉	통과 (3.61ms, 52.9MB)
테스트 15 〉	통과 (0.94ms, 52.3MB)
효율성  테스트
테스트 1 〉	통과 (21.12ms, 56.2MB)
테스트 2 〉	통과 (19.57ms, 54.1MB)
테스트 3 〉	통과 (22.14ms, 54.2MB)
테스트 4 〉	통과 (20.64ms, 55.2MB)
테스트 5 〉	통과 (23.05ms, 55.8MB)
*/
    public static int solution2(int[] people, int limit) {
        Arrays.sort(people); // 배열 정렬
        int result=0;
        int idx=0;
        for (int i = people.length-1; i >= idx; i--) {
            if(limit - people[i] >= people[idx])
                idx++;
            result++;
        }
        return result;
    }
}
