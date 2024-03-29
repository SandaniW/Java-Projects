import java.util.Scanner;

public class Demo {

    public static void main(String[]args){
        String option= "";
        Student student = new Student();
        Scanner scan = new Scanner(System.in);
        while(!option.equals("3")) {
            System.out.println("1 -> To input student data");
            System.out.println("2 -> To view student data and grade");
            System.out.println("3 -> To exit");
            System.out.print("Enter the number: ");
            option = scan.nextLine();
            switch (option) {
                case "1": {
                    student.numberOfStudents();
                    break;
                }
                case "2": {
                    student.showDetails();
                }
            }
        }
        System.out.println("End");


    }

}
