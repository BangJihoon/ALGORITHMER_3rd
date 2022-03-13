package week16;
import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,7},{2,6}};
        System.out.println(solution(jobs));
    }
    // SJF 로 구현되야 함
    public static int solution(int[][] jobs) {        // 요청시간, 수행시간
        Arrays.sort(jobs,(Comparator.comparingInt(o -> o[0]))); // 요청시간별로 정렬

        Queue<Job> index = new PriorityQueue<>(); // 배열의 index 기록

        return 1;

    }

}
class Job implements Comparable{
    int start;
    int runtime;

    @Override
    public int compareTo(Object o) {
        Job j = (Job)o;
        return runtime - j.runtime;
    }
}
