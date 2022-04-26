package week23;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        System.out.println(solution(n,times));
    }
    public static long solution(int n, int[] times) {
        Arrays.sort(times); // 오름차순 정렬
        long r = (long) times[times.length-1] * n; // overflow 주의, 최대 10억명 x 10억분 => long형으로 받아야함
        long l = 1; //  0이라도 상관은 없지만.. 문제에서 1명이상 심사시간 1분이상인 심사관에게 받음
        long mid;
        long person,result=0;
        while(l<=r){
            mid = (l+r)/2; // 기준 초
            person = 0; // 입국심사 수 count
            for (int time : times)
                person += mid/time;
            if(person>=n){
                r=mid-1;
                result = mid;
            }
            else
                l=mid+1;
        }
        return result;
    }
}

