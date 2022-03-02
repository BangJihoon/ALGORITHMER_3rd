package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class ClassSort {
    public static void main(String[] args) {
        Student[] arr = new Student[5];
        String[] name = {"Bang","Ann","Choi","Lee","Dong"};
        for(int i=0;i<5;i++)
            arr[i] = new Student(name[i],i+1);
        System.out.println("--- Comparable 사용 이름순 정렬 ---");
        Arrays.sort(arr);
        for (Student student : arr)
            System.out.println("student.name = " + student.name + "\tstudent.sno = "+ student.sno);

        System.out.println("--- Comparator 사용 번호순 정렬 ---");
        //Arrays.sort(arr, (o1, o2) -> o1.sno - o2.sno);
        Arrays.sort(arr, Comparator.comparingInt(Student::getSno));
        for (Student student : arr)
            System.out.println("student.name = " + student.name + "\tstudent.sno = "+ student.sno);
    }
    
}
class Student implements Comparable<Student>{
    String name;
    int sno;
    public Student(String name, int sno) {
        this.name = name;
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public int getSno() {
        return sno;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name); // 오름차순 비교
    }
}
