package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {
    public static void main(String[] args) {
        exComparator();
    }
    // 1차원 문자열 배열 정렬
    public static void StringArray1D () {
        String[] strArray = {"aa", "ac", "ab", "ad"};
        System.out.println("----String 배열 오름차순----");
        Arrays.sort(strArray);
        for (String i : strArray)
            System.out.print(i + " ");

        System.out.println("\n----String 배열 역순----");
        Arrays.sort(strArray, Comparator.reverseOrder()); // 내림차순
        for (String i : strArray)
            System.out.print(i + " ");

        System.out.println("\n----String 배열 Comparator 사용----");
        Arrays.sort(strArray, Comparator.naturalOrder());
        for (String i : strArray)
            System.out.print(i + " ");



    }
    // 1차원 int 배열 정렬
    public static void intArray1D () {
        int[] intArray = {1,3,5,7,2,4,6};
        System.out.println("----int 배열 오름차순----");
        Arrays.sort(intArray);
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println("\n----int 배열 역순----");
        // primitive Type을 Wrapper클래스로 박싱해주자.
        Integer[] tmp = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder()); // 내림차순
        for (int i : tmp) {
            System.out.print(i + " ");
        }
    }

    // N차원  배열 정렬
    public static void exComparator () {
        // 배열의 0번값을 기준으로 정렬 comparator
        Comparator<int[]> com1 = Comparator.comparingInt(o -> o[0]);
        // 배열의 1번값을 정렬하는 Comparator
        Comparator<int[]> com2 = Comparator.comparingInt(o -> o[1]);
        // 2차원배열에 물품번호, 가격이 담겨있다고 가정
        int[][] arr = {{1,5000},{2,3000},{3,7000},{4,1000}};
        System.out.println("com1로 정렬---");
        Arrays.sort(arr, com1);
        for (int[] a : arr)
            System.out.println(a[0]+" "+a[1]);
        System.out.println("com2로 정렬---");
        Arrays.sort(arr, com2);
        for (int[] a : arr)
            System.out.println(a[0]+" "+a[1]);


        String[][] exArray = {{"aa","100"}, {"ac","101"}, {"ab","102"},{"ad","103"}};
        Arrays.sort(exArray, Comparator.comparing(o -> o[0]));
        for (String[] strings : exArray) {
            System.out.println("strings = " + strings[0]+" "+strings[1]);
        }

        String a = "aaa";
        System.out.println(a.compareTo("ccc"));
    }
}

















