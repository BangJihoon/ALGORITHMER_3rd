package week17;
public class 체육복 {
    // 여벌의 옷을 1개가 아닌 여러개 가지고 있을수 있다
    public static int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;
        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i>=1 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i< people.length-1 && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n,lost, reserve));
    }
    /*
    정확성  테스트
테스트 1 〉	통과 (0.01ms, 75.8MB)
테스트 2 〉	통과 (0.02ms, 77.1MB)
테스트 3 〉	통과 (0.02ms, 77.4MB)
테스트 4 〉	통과 (0.02ms, 76.6MB)
테스트 5 〉	통과 (0.02ms, 77.6MB)
테스트 6 〉	통과 (0.02ms, 76.9MB)
테스트 7 〉	통과 (0.02ms, 75.3MB)
테스트 8 〉	통과 (0.02ms, 75.5MB)
테스트 9 〉	통과 (0.02ms, 89.6MB)
테스트 10 〉	통과 (0.01ms, 74.3MB)
테스트 11 〉	통과 (0.03ms, 77.4MB)
테스트 12 〉	통과 (0.02ms, 75.2MB)
테스트 13 〉	통과 (0.03ms, 72.7MB)
테스트 14 〉	통과 (0.02ms, 84.9MB)
테스트 15 〉	통과 (0.02ms, 77.3MB)
테스트 16 〉	통과 (0.02ms, 71.7MB)
테스트 17 〉	통과 (0.02ms, 72.1MB)
테스트 18 〉	통과 (0.02ms, 72.8MB)
테스트 19 〉	통과 (0.01ms, 66.2MB)
테스트 20 〉	통과 (0.01ms, 79MB)
    * */
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n+1]; // 0번은 편의상 사용하지 않을거임
        int ans=n;
        for(int l : lost) arr[l]--;
        for(int r : reserve) arr[r]++;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==-1) { // 옷을 잃어버린 사람이면 필요한 경우
                if (arr[i-1] == 1) { // 앞사람이 여벌의 옷이 있으면 빌려줌
                    arr[i-1]--;
                    arr[i]++;
                } else if (i< arr.length -1 && arr[i+1] == 1) { // 뒷사람이 여벌의 옷이 있으면 빌려줌
                    arr[i+1]--;
                    arr[i]++;
                } else { // 위 두경우에 해당하지 않으면 , 못빌린거임
                    ans--;
                }
            }
        }
        return ans;
    }
}
