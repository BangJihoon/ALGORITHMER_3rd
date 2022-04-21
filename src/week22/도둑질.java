package week22;

public class 도둑질 {
    public static void main(String[] args) {
        int[] money = {1,2,100,2,1,1000,1};
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        int answer;
        // 처음 집 훔치고 마지막집을 훔치지 못하는 case와 , 그렇지 않은 케이스
        int[] case1 = new int[money.length-1];
        int[] case2 = new int[money.length];
        // case1은 Dp를 위해 0,1번 값을 모두 처음집값으로 셋팅
        case1[0] = money[0];
        case1[1] = money[0];
        //case2는 처음집을 안훔치므로 0값으로 셋팅
        case2[0] = 0;
        case2[1] = money[1];
        // DP - -2번째에 지금값을 더한것과 -1번째 집까지 훔친 경우를 비교하면서 어느집을 훔치는게 제일 큰지 값 저장
        for(int i=2; i<case1.length; i++)
            case1[i] = Math.max(case1[i-2] + money[i], case1[i-1]);
        for(int i=2; i<case2.length; i++)
            case2[i] = Math.max(case2[i-2] + money[i], case2[i-1]);
        // 두 경우중 더 많이 훔치는 경우를 반환
        answer = Math.max(case1[case1.length-1], case2[case2.length-1]);

        return answer;
    }
}