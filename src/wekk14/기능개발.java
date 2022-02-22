package wekk14;

import java.util.*;
/*
정확성  테스트
테스트 1 〉	통과 (0.39ms, 76.1MB)
테스트 2 〉	통과 (0.66ms, 73.2MB)
테스트 3 〉	통과 (0.49ms, 70.9MB)
테스트 4 〉	통과 (0.40ms, 76.6MB)
테스트 5 〉	통과 (0.59ms, 72.6MB)
테스트 6 〉	통과 (0.39ms, 78.9MB)
테스트 7 〉	통과 (0.48ms, 72.7MB)
테스트 8 〉	통과 (0.63ms, 82.6MB)
테스트 9 〉	통과 (0.62ms, 81.8MB)
테스트 10 〉	통과 (0.49ms, 75.6MB)
테스트 11 〉	통과 (0.41ms, 84.8MB)
* */
public class 기능개발 {
    public static int[] solution(int[] p, int[] s) {
        // 일률 저장
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<p.length;i++)
            q.add((int) Math.ceil((100.0 - p[i]) / s[i]));
        // 결과 저장
        List<Integer> res = new ArrayList<>();
        int cnt=0,top=q.peek();
        for (Integer i : q) {
            if(top>=i)
                cnt++;
            else{
                res.add(cnt); // 결과저장
                top = i; // 새로운 top
                cnt=1;
            }
        }
        res.add(cnt); // 마지막 원소 추가
        // 결과 반환할 자료형으로 변환 (list -> array)
        int[] answer = new int[res.size()];
        for(int i=0;i<res.size();i++)
            answer[i] = res.get(i);

        return answer;
        //return res.stream().mapToInt(i->i).toArray(); // 결과 List 배열로 변환 (간소화시키지만, 느림)
    }
    public static void main(String[] args) {
        int[] p = {95, 90, 99, 99, 80, 99};
        int[] s = {1,1,1,1,1,1};
        int[] res = solution(p,s);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
