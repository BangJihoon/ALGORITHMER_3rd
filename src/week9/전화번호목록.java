package week9;

import java.util.Arrays;
import java.util.HashSet;
public class 전화번호목록 {
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
	public static boolean solution(String[] phoneBook) {
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
