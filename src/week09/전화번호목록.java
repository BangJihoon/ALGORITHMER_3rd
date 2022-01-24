package week09;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.24ms, 72.6MB)
 * 테스트 2 〉	통과 (0.26ms, 79.3MB)
 * 테스트 3 〉	통과 (0.25ms, 78MB)
 * 테스트 4 〉	통과 (0.27ms, 73.4MB)
 * 테스트 5 〉	통과 (0.41ms, 76.8MB)
 * 테스트 6 〉	통과 (0.24ms, 77MB)
 * 테스트 7 〉	통과 (0.35ms, 82.7MB)
 * 테스트 8 〉	통과 (0.23ms, 73.5MB)
 * 테스트 9 〉	통과 (0.29ms, 77.2MB)
 * 테스트 10 〉	통과 (0.29ms, 73.4MB)
 * 테스트 11 〉	통과 (0.24ms, 86.1MB)
 * 테스트 12 〉	통과 (0.19ms, 74.9MB)
 * 테스트 13 〉	통과 (0.31ms, 71.4MB)
 * 테스트 14 〉	통과 (4.10ms, 81.3MB)
 * 테스트 15 〉	통과 (3.19ms, 86.4MB)
 * 테스트 16 〉	통과 (2.82ms, 69.9MB)
 * 테스트 17 〉	통과 (5.35ms, 73.8MB)
 * 테스트 18 〉	통과 (4.25ms, 75.4MB)
 * 테스트 19 〉	통과 (6.21ms, 83MB)
 * 테스트 20 〉	통과 (8.15ms, 89.7MB)
 *
 * 효율성  테스트
 * 테스트 1 〉	통과 (27.25ms, 59.5MB)
 * 테스트 2 〉	통과 (22.77ms, 57.3MB)
 * 테스트 3 〉	통과 (348.05ms, 97.8MB)
 * 테스트 4 〉	통과 (295.11ms, 96.3MB)
 *
 * 채점 결과
 * 정확성: 83.3
 * 효율성: 16.7
 * 합계: 100.0 / 100.0
 */

import java.util.Arrays;
import java.util.HashSet;

public class 전화번호목록 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
//--------------------------------------------------------
// HashSet으로 접근해본 문제
	/*
	정확성  테스트
	테스트 1 〉	통과 (0.51ms, 70.5MB)
	테스트 2 〉	통과 (0.71ms, 72.7MB)
	테스트 3 〉	통과 (0.54ms, 73.1MB)
	테스트 4 〉	통과 (0.60ms, 74.1MB)
	테스트 5 〉	통과 (0.46ms, 76.2MB)
	테스트 6 〉	통과 (1.11ms, 87.9MB)
	테스트 7 〉	통과 (0.47ms, 71.9MB)
	테스트 8 〉	통과 (0.49ms, 71.4MB)
	테스트 9 〉	통과 (0.51ms, 75.4MB)
	테스트 10 〉	통과 (0.60ms, 77.6MB)
	테스트 11 〉	통과 (0.48ms, 77.4MB)
	테스트 12 〉	통과 (0.47ms, 77.6MB)
	테스트 13 〉	통과 (0.79ms, 70MB)
	테스트 14 〉	통과 (2.11ms, 76.7MB)
	테스트 15 〉	통과 (2.21ms, 68.6MB)
	테스트 16 〉	통과 (4.32ms, 79.8MB)
	테스트 17 〉	통과 (5.19ms, 78.1MB)
	테스트 18 〉	통과 (5.84ms, 79.1MB)
	테스트 19 〉	통과 (5.35ms, 80.8MB)
	테스트 20 〉	통과 (4.95ms, 87.9MB)
	효율성  테스트
	테스트 1 〉	통과 (9.24ms, 57.8MB)
	테스트 2 〉	통과 (4.53ms, 58MB)
	테스트 3 〉	통과 (326.45ms, 247MB)
	테스트 4 〉	통과 (372.85ms, 204MB)
	*/
	public static boolean solution2(String[] phoneBook) {
        HashSet<String> set = new HashSet<>();
        Arrays.stream(phoneBook).forEach(s -> set.add(s));
        for(String str : set){
            for(int i = 1; i < str.length(); i++){
                if(set.contains(str.substring(0, i))){
                    return false;
                }
            }
        }
	    return true;
	}
	
	public static void main(String[] args) {
		String[] phoneBook = {"119", "97674223", "1195524421"};
		System.out.println(solution(phoneBook));
	}
}
// 자기자신을 제외시키기 위해 어두를 -1로 만들어 검사해주었지만, 좋지 않은 풀이.
