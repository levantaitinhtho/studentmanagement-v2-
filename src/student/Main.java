package student;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        ArrayList<Student> studentList = studentManagement.getList();
        Scanner input = new Scanner(System.in);
        int choose;
        do {
            showMenu();
            System.out.println("Enter Choose Of You");
            choose = Integer.parseInt(input.nextLine());
            switch (choose){
                case 1:
                    Student std = getInfor();
                    studentManagement.addStudent(std);
                    break;
                case 2:
                    System.out.println("Enter The Student ID You Want To Delete");
                    long inputID = Long.parseLong(input.nextLine());
                    Student student = studentManagement.searchByID(inputID);
                    if(student==null){
                        break;
                    }
                    studentManagement.deleteStudent(student);
                    System.out.println("Successful Implementation");
                    break;
                case 3:
                    System.out.println("Enter The Student ID You Want To Search");
                    int search = Integer.parseInt(input.nextLine());
                    for(Student student1 : studentList){
                        if(student1 == studentManagement.searchByID(search)){
                            show(student1);
                        }else{
                            System.out.println("Not Found ID");
                        }
                    }
                    break;
                case 4:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student student, Student t1) {
                            if(student.calcualteAverageScore()> t1.calcualteAverageScore()){
                                return -1;
                            }else if(student.calcualteAverageScore()<t1.calcualteAverageScore()){
                                return 1;
                            }else{
                                return 0;
                            }
                        }
                    });
                    for(Student student1 : studentList){
                        System.out.println("After Sort");
                        show(student1);
                    }
                    break;
                case 5:
                    System.out.println("Enter Student Name You Want To Search");
                    String inputName = input.nextLine();
                    for(Student student2 : studentList){
                        if(student2 == studentManagement.searchByName(inputName)){
                            show(student2);
                        }else{
                            System.out.println("Not Found Name");
                        }
                    }
                    break;
                case 6:
                    for(Student student3 :studentList){
                        show(student3);
                    }
                    break;
                case 7:
                    System.out.println("GoodBye ~~");
                    return;
                default:
                    System.err.println("Enter Again");
            }

        }while (choose !=7);
    }
    public static void showMenu(){
        System.out.println("1.Add Student");
        System.out.println("2.Remove Student");
        System.out.println("3.Search For Student Based On ID");
        System.out.println("4.Sort Student Based On Score ");
        System.out.println("5.Search Student Based On Name");
        System.out.println("6.Display All Student");
        System.out.println("7.Exits");
    }
    public static Student getInfor(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID: ");
        int ID = Integer.parseInt(input.nextLine());
        System.out.println("Enter Name: ");
        String name = input.nextLine();
        System.out.println("Enter Major: ");
        String major = input.nextLine();
        System.out.println("Enter Theory Score: ");
        float theoryScore = Float.parseFloat(input.nextLine());
        System.out.println("Enter Practice Score: ");
        float practiceScore = Float.parseFloat(input.nextLine());
        return new  Student(ID,name,major,theoryScore,practiceScore);
    }
    public static void show(Student student){
        System.out.println(student.toString());
    }
}
