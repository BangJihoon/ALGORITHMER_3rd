package week13;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
/*
// 내 코드
* 정확성  테스트
테스트 1 〉	통과 (4.65ms, 76.7MB)
테스트 2 〉	통과 (4.71ms, 77.5MB)
테스트 3 〉	통과 (3.97ms, 77.9MB)
테스트 4 〉	통과 (5.89ms, 85.7MB)
테스트 5 〉	통과 (6.51ms, 79.1MB)
테스트 6 〉	통과 (7.20ms, 73.4MB)
테스트 7 〉	통과 (2.70ms, 74.1MB)
테스트 8 〉	통과 (2.24ms, 78.9MB)
테스트 9 〉	통과 (5.78ms, 71.5MB)
테스트 10 〉	통과 (3.97ms, 75.5MB)
테스트 11 〉	통과 (6.04ms, 79.4MB)
테스트 12 〉	통과 (3.86ms, 76.6MB)
테스트 13 〉	통과 (5.18ms, 80.4MB)
테스트 14 〉	통과 (6.29ms, 80MB)
테스트 15 〉	통과 (5.22ms, 78.2MB)
* */
public class HIndex {
    public static int solution(int[] citations) {
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new); //정렬을 위해서는 boxing 필요
        Arrays.sort(tmp, Comparator.reverseOrder());
        int hindex = citations.length;
        while(hindex>=0) { //hindex의 값의 범위는 0 ~ 발표한 논문수 사이이다.
            int cnt = 0;
            for (Integer integer : tmp) {
                if (integer >= hindex) // h번 이상 인용되었으면 count
                    cnt++;
                else break; // 아닌 순간에는 내림으로 정렬되어 있으므로 뒤는 더 볼 필요 없다.
            }
            if (hindex <= cnt) // h이상 인용된 논문이 h이상 이면
                return hindex;
            hindex--;
        }
        return 0;
    }
/*
// 1등 코드
* 정확성  테스트
테스트 1 〉	통과 (0.56ms, 77.1MB)
테스트 2 〉	통과 (0.65ms, 75.9MB)
테스트 3 〉	통과 (0.58ms, 72.4MB)
테스트 4 〉	통과 (0.53ms, 76.5MB)
테스트 5 〉	통과 (0.59ms, 73.8MB)
테스트 6 〉	통과 (0.63ms, 73.1MB)
테스트 7 〉	통과 (0.44ms, 74.3MB)
테스트 8 〉	통과 (0.33ms, 75.9MB)
테스트 9 〉	통과 (0.54ms, 75.9MB)
테스트 10 〉	통과 (0.48ms, 81.3MB)
테스트 11 〉	통과 (0.67ms, 82.4MB)
테스트 12 〉	통과 (0.40ms, 71.4MB)
테스트 13 〉	통과 (0.66ms, 83.5MB)
테스트 14 〉	통과 (0.64ms, 75.8MB)
테스트 15 〉	통과 (0.65ms, 74.5MB)
테스트 16 〉	통과 (0.35ms, 75.2MB)
* */
    public static int solution2(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for(int i = citations.length-1; i >= 0; i--){
            int min = Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }
        return max;
    }
    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5};
        int[] citations = {5,5,5,5,5};
        System.out.println(solution2(citations));
    }
}
