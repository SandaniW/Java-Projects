import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    private  String name;
    private String email;
    private  int age;
    private String address;
    private int mark;
    Scanner scan = new Scanner(System.in);
    String grade;
    int noOfStudents;
    ArrayList<Student> studentArrayList= new ArrayList<>();
    int count=0;
    int i=0;



    public Student(String name, String email, int age, String address, int mark) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.mark = mark;
    }
    public Student(){}

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void obtainDetails(){
        InputException inputException = new InputException();
        System.out.print("No of students to be entered: ");
        noOfStudents = scan.nextInt();
        if(noOfStudents>0) {
            for (count=0;count < noOfStudents; count++) {
                Student student = new Student();
                System.out.println("Enter student "+(count+1)+" details-> ");
                System.out.print("Enter student name: ");
                student.setName(scan.next());
                System.out.print("Enter student email: ");
                student.setEmail(scan.next());
                System.out.print("Enter student age: ");
                student.setAge(scan.nextInt());
                System.out.print("Enter student address: ");
                student.setAddress(scan.next());
                System.out.print("Enter student mark: ");
                inputException.marks(scan.nextInt());
                System.out.println("----------------------------------------------");
            }
        }else{
            System.out.println("Number of entries should be greater than 0");

        }

    }
    public String calculateGrade(){
        if((mark>=0)&&(mark<=100)) {
            if (mark >= 90) {
                grade = "A";
            } else if (mark >= 80) {
                grade = "B";
            } else if (mark >= 70) {
                grade = "C";
            } else if (mark >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            return grade;
        }else{
            return "Mark should be between 0 and 100";

        }


    }
    public void showDetails(){
        for(Student student: studentArrayList){
            i++;
            System.out.println("Student "+i+" details: ");
            System.out.println("Name: "+student.getName());
            System.out.println("Email: "+student.getEmail());
            System.out.println("Age: "+student.getAge());
            System.out.println("Address: "+student.getAddress());
            System.out.println("Grade: "+student.calculateGrade());
            System.out.println("----------------------------------------------------");
        }


    }


}

