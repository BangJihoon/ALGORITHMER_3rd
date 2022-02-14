package week13;

import java.util.Arrays;
import java.util.Collections;
public class HIndex {
    public static int solution(int[] citations) {
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp);
        int hindex = tmp[0], res = tmp[0];
        for (int i=0;i<tmp.length;i++) {
            // 아 풀기 싫다
        }
        return hindex;
    }
    public static void main(String[] args) {
        int[] citations = {3,5,6,8,10};
        System.out.println(solution(citations));
    }
}
