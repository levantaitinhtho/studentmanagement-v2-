package student;

import bankmanagement.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> studentList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public ArrayList<Student> getList(){
        return studentList;
    }
    public void addStudent(Student student){
        studentList.add(student);
    }
    public void deleteStudent(Student student){
        studentList.remove(student);
    }
    public Student searchByID(long ID) {
        for (Student student : studentList) {
            if( student.getID() == ID) {
                return student;
            }
        }
        return null;
    }
    public Student searchByName(String name){
        for( Student student : studentList){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
}
