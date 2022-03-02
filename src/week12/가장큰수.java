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

    public static String solution(int[] numbers){
        StringBuffer sb = new StringBuffer();  // 결과를 문자열로 붙이는 경우 String보다 Sb가 성능이 더 좋습니다.

        String[] str = new String[numbers.length];  // 비교를 위해 Input 배열을 String으로 변환
        for(int i=0;i<numbers.length; i++)
            str[i] = Integer.toString(numbers[i]);

        // 핵심부분 - Comparator인터페이스를 이용해 정렬 재정의
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);  // compareTo 문자열의 아스키코드를 비교해가면서 큰수면 양수, 작은수면 음수반환
                // 내림차순을 위해서 -로 값 반전 (비교시 o2+o1 먼저 비교하는 형식으로도 내림차순 정렬가능)
            }
        });

        //  0으로만 이루어진 값의 경우 0000으로 반환하지않고, 0으로 반환하도록 한다. (이런부분은 코테에서 핵심이 아니므로 무시해도될듯)
        if(str[0].equals("0"))
            return "0";
        else {
            for(String s : str) {
                //System.out.println(s);
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
// Integer tmp[] = Arrays.stream(numbers).boxed().toArray(Integer[]::new); // int -> integer 변환