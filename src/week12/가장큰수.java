package week12;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
/*
* 정확성  테스트
테스트 1 〉	통과 (185.11ms, 126MB)
테스트 2 〉	통과 (103.06ms, 129MB)
테스트 3 〉	통과 (230.72ms, 123MB)
테스트 4 〉	통과 (20.47ms, 84.6MB)
테스트 5 〉	통과 (177.80ms, 146MB)
테스트 6 〉	통과 (158.11ms, 136MB)
테스트 7 〉	통과 (1.39ms, 75.7MB)
테스트 8 〉	통과 (0.95ms, 75.3MB)
테스트 9 〉	통과 (0.96ms, 69.6MB)
테스트 10 〉	통과 (0.92ms, 70.3MB)
테스트 11 〉	통과 (1.24ms, 70.8MB)
테스트 12 〉	통과 (0.78ms, 78.8MB)
테스트 13 〉	통과 (0.81ms, 76.9MB)
테스트 14 〉	통과 (0.86ms, 71.9MB)
테스트 15 〉	통과 (0.87ms, 73MB)
* */
public class 가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
    public static String solution(int[] numbers) {
        // int -> String 변환
        String[] tmp = Arrays.toString(numbers).replaceAll("[^0-9 ]", "").split(" ");
        // 이어 붙인 값 비교 정렬
        Arrays.sort(tmp, (o1, o2) -> (o2.concat(o1)).compareTo(o1.concat(o2)));
        String res = Arrays.toString(tmp).replaceAll("[^0-9]","");
        // 0으로 시작 인 경우, 0 반환 ex> 000
        if(res.startsWith("0")) return "0";
        return res;
    }
}
// Integer tmp[] = Arrays.stream(numbers).boxed().toArray(Integer[]::new); // int -> integer 변환