package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Student{
    private int ID;
    private double GPA = -1;
    private String name;
    void setGPA(double GPA){
        this.GPA = GPA;
    }
    void setName(String name){
        this.name = name;
    }
    void setID(int ID){
        this.ID = ID;
    }
    int getID(){
        return ID;
    }
    double getGPA(){
        return GPA;
    }
    String getName(){
        return name;
    }
    Student(String name, double GPA, int ID){
        setID(ID);
        setName(name);
        setGPA(GPA);
    }
    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", GPA=" + GPA +
                ", name='" + name + '\'' +
                '}';
    }
}
class SortingStudentsByGPA implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getGPA() < student2.getGPA())
            return 1;
        if (student2.getGPA() < student1.getGPA())
            return -1;
        return 0;
    }
}
public class Main{
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList();
        Student student1 = new Student("Alex",2.8,5);
        Student student2 = new Student("Max",3.6,4);
        Student student3 = new Student("Sasha",4.3,1);
        Student student4 = new Student("Jeff",5,2);
        Student student5 = new Student("Jack",3.1,3);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        ArrayList IDNum = new ArrayList();
        students.forEach(student -> IDNum.add(student.getID()));
        Collections.sort(IDNum);
        System.out.println(IDNum);
        Collections.sort(students, new SortingStudentsByGPA());
        students.forEach(student -> System.out.println(student));
    }
}