package week19;

import java.util.Arrays;

/*
문제 : n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
제한 :   1. 다리를 여러 번 건너더라도, 연결만 되어 있으면 됩니다.
        2. 1 <= n <= 100
        3. costs의 길이는 ((n-1) * n) / 2이하
        4. cost는 from , to , cost 순서
        5. 같은 연결은 한번만 주어짐
        6. 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다.  이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
풀이 : 크루스칼 알고리즘으로 노드의 최단경로를 구한다.
        1. 최소비용으로 정렬하고
        2. 연결여부를 체크해줄 배열을 선언 및 자기자신 index로 초기화한다.
        3. 반복문을 돌며 초기상태(자기자신)인지 체크후 최소비용이니 연결해준다.
        4. 초기상태가 아니라면, 어딘가에 연결되어있으므로, 재귀적으로 연결의 끝지점인 자기자신이 나오게 되는데 (반드시 존재한다).
           이때, 나온값이 처음에 연결여부를 물었던 시작점과 같은지를 체크하여 연결하지않고 지나간다.(같은 경로 값은 들어오지않으므로, 한번 연결되고나서 다른 값으로 변경되도 상관없다.)
 */
public class 섬연결하기 {
    static int [] island;
    public static void main(String[] args) {
        int n = 4;
        int[][] cost = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, cost));
    }
/*
정확성  테스트
테스트 1 〉	통과 (0.58ms, 68.4MB)
테스트 2 〉	통과 (0.49ms, 82MB)
테스트 3 〉	통과 (0.51ms, 74MB)
테스트 4 〉	통과 (0.64ms, 75MB)
테스트 5 〉	통과 (0.56ms, 72.8MB)
테스트 6 〉	통과 (0.94ms, 84.3MB)
테스트 7 〉	통과 (0.87ms, 75.1MB)
테스트 8 〉	통과 (0.60ms, 72.2MB)
*/
    public static int solution(int n, int[][] costs) {
        Arrays.sort(costs,(o1,o2)->o1[2]-o2[2]); // 비용이 적은 순서로 정렬
        island = new int [n]; // 각 노드별 최소경로 정보 저장
        for (int i = 0; i < island.length; i++) island[i] = i; // 0~n까지 저장

        int res = 0;
        for(int i = 0; i < costs.length; i++) {
            int a = isConnect(costs[i][0]);
            int b = isConnect(costs[i][1]);
            if(a != b ){ // 연결이 안되어 있으면
                island[a] = b;      // 연결
                res += costs[i][2]; // 비용 계산
            }
        }
        return res;
    }
    // 연결설정 체크
    public static int isConnect(int a){
        if(island[a] == a) // 초기상태인지
            return a;
        else
            return isConnect(island[a]); // 결국 연결이 없는 끝지점 (자기자신값을 가지는 노드) 값을 반환해줌
    }
}
/*
풀이가 일반적이지 못하다.
섬의 input값이 a <b 순서로 들어와야 이와같이 단방향 검사가 가능하다.
* */
