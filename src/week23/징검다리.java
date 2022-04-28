package week23;

import java.util.Arrays;
import java.util.Collections;

public class 징검다리 {
    public static void main(String[] args) {
        int distance=25;
        int[] rocks={2,14,11,21,17};
        int n = 2;
        System.out.println(solution(distance,rocks,n));
    }
    /*
    n개를 제외했을때 사이거리가 최소가되는 최댓값은
    그냥 거리값이 제일 적은것들부터 n개를 제외하고나서 가지는 최솟값이 최대값이 된다.
     */
    public static int solution(int distance, int[] rocks, int n) {
        // input 돌 위치값 정렬
        int len = rocks.length;
        Arrays.sort(rocks);
        int l = 1;
        int r = distance;
        int mid,prev,cnt,res=0;
        while(l<=r) {
            mid = (r + l) / 2;
            cnt = 0;
            prev = 0;
            for (int rock : rocks) {
                if (rock - prev < mid) cnt++; // 제거가능한 돌 count (=을 포함하면 왜 안되지?)
                else prev = rock;             // 제거 불가능한 지점을 기준으로 다시 체크
            }
            if (distance - prev < mid) cnt++; // 제거되지않은 마지막 돌과 끝지점 사이 거리도 체크후 count

            if (cnt <= n) { // 제거가능한 돌수가 적으면, 기준길이를 늘려야 하므로 Left 재조정,  같은 경우를 포함시켜 만족하는 최댓값을 기록
                l = mid + 1;
                res = Math.max(res, mid);
            } else          // 제거 가능한 돌수가 더 많으면, 길이를 줄이도록 Right 조정
                r = mid - 1;
        }
        return res;
    }
}
