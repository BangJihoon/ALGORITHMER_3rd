package week18;
/*
정확성  테스트
테스트 1 〉	통과 (0.13ms, 89.8MB)
테스트 2 〉	통과 (0.04ms, 72.3MB)
테스트 3 〉	통과 (0.04ms, 80.6MB)
테스트 4 〉	통과 (0.07ms, 75.8MB)
테스트 5 〉	통과 (0.05ms, 74.6MB)
테스트 6 〉	통과 (0.04ms, 74.5MB)
테스트 7 〉	통과 (0.05ms, 74.8MB)
테스트 8 〉	통과 (0.04ms, 76.7MB)
테스트 9 〉	통과 (0.04ms, 75.6MB)
테스트 10 〉	통과 (0.05ms, 75MB)
테스트 11 〉	통과 (0.04ms, 74.1MB)
테스트 12 〉	통과 (0.05ms, 84MB)
테스트 13 〉	통과 (0.09ms, 78.6MB)
테스트 14 〉	통과 (0.06ms, 71MB)
테스트 15 〉	통과 (0.07ms, 74.6MB)
테스트 16 〉	통과 (0.07ms, 79MB)
테스트 17 〉	통과 (0.05ms, 72.9MB)
테스트 18 〉	통과 (0.07ms, 74.5MB)
테스트 19 〉	통과 (0.04ms, 76.7MB)
테스트 20 〉	통과 (0.08ms, 73.2MB)
테스트 21 〉	통과 (0.04ms, 80.8MB)
테스트 22 〉	통과 (0.05ms, 78.5MB)
테스트 23 〉	통과 (0.08ms, 74.5MB)
테스트 24 〉	통과 (0.06ms, 79.5MB)
테스트 25 〉	통과 (0.06ms, 74.7MB)
테스트 26 〉	통과 (0.08ms, 76.5MB)
테스트 27 〉	통과 (0.07ms, 76.1MB)
*/
/*
문제 이해:
좌우 커서의 이동도 count를 해준다.  : 첫번쨰 알파벳, 두번쨰 알파벳, 세번째 알파벳
위아래 움직임은 알파벳을 한칸씩 위아래로 움직이는 연산이다. A-B-C ...

여기서 알파벳은 A에서 시작해서 한칸씩움직이기 때문에 이동을 구하는게 어렵지않지만,
커서는 뒤로 순회할지 앞으로 순회할지에 대한 선택이므로 처음에 구해야한다...
* */
public class 조이스틱 {
    public static void main(String[] args) {
        String name ="JAZ";
        System.out.println(solution(name));
        //System.out.println(Character.getNumericValue('Z'));
    }
    //  A = 10, Z =35
    public static int solution(String name) {
        return AlphaMove(name) + CurserMove(name);
    }
    public static int AlphaMove(String name){
        int min=0, val;
        for(char ch : name.toCharArray()){
            val = Character.getNumericValue(ch);
            min += Math.min(36 -val , val-10);
        }
        System.out.println("alp = " + min);
        return min;
    }
    // 2번부터 A의 연속지점을 찾아 최소이동을 저장한다
    public static int CurserMove(String name){
        int len = name.length();
        int min = len-1;
        for (int i = 0; i < name.length(); i++) {
            int next=i+1; // A의 연속지점을 기록할 변수
            while(next < len && name.charAt(next) =='A') next++;
            min = Math.min(min, Math.min((i * 2) + len - next, (len - next)*2+i));
        }
        System.out.println("cur : " + min);
        return min;
    }
}
