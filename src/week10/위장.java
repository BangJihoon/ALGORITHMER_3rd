package week10;

import java.util.Arrays;
import java.util.HashMap;
/*정확성  테스트
테스트 1 〉	통과 (0.78ms, 76.7MB)
테스트 2 〉	통과 (0.56ms, 77.2MB)
테스트 3 〉	통과 (0.78ms, 73.2MB)
테스트 4 〉	통과 (0.52ms, 79.1MB)
테스트 5 〉	통과 (0.71ms, 78.9MB)
테스트 6 〉	통과 (0.47ms, 73.8MB)
테스트 7 〉	통과 (0.57ms, 76.8MB)
테스트 8 〉	통과 (0.73ms, 77.1MB)
테스트 9 〉	통과 (0.77ms, 77.9MB)
테스트 10 〉	통과 (0.55ms, 72.9MB)
테스트 11 〉	통과 (0.71ms, 86.8MB)
테스트 12 〉	통과 (0.63ms, 74MB)
테스트 13 〉	통과 (0.51ms, 70MB)
테스트 14 〉	통과 (0.57ms, 78MB)
테스트 15 〉	통과 (0.74ms, 82.3MB)
테스트 16 〉	통과 (0.50ms, 67.6MB)
테스트 17 〉	통과 (0.88ms, 72.6MB)
테스트 18 〉	통과 (0.73ms, 65.3MB)
테스트 19 〉	통과 (0.54ms, 78.2MB)
테스트 20 〉	통과 (0.52ms, 78.4MB)
테스트 21 〉	통과 (0.76ms, 71.9MB)
테스트 22 〉	통과 (0.55ms, 73.1MB)
테스트 23 〉	통과 (0.56ms, 76.2MB)
테스트 24 〉	통과 (0.74ms, 71.7MB)
테스트 25 〉	통과 (0.55ms, 71.2MB)
테스트 26 〉	통과 (0.48ms, 69.8MB)
테스트 27 〉	통과 (0.98ms, 71.2MB)
테스트 28 〉	통과 (0.61ms, 82.1MB)
*/
// 종류별로 옷의 수를 저장하여 안고르는 경우를 포함해서 경우의 수를 구함, 모두 안골라입은 1가지의 경우만 빼서 반환
public class 위장 {
	public static void main(String[] args) {
		String [][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}
	public static int solution(String[][] clothes) {
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		Arrays.stream(clothes).forEach(c -> map.put(c[1], map.getOrDefault(c[1], 0)+1));
		int res=1;
		for(int i : map.values())
			res *= i+1;
		return res-1;
	}
}
