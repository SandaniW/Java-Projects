import java.util.Objects;
import java.util.Scanner;
public class ScannerTest {

    public static void main(String[]args){
        String name;
        String howAmI;
        String hasError="true";
        Scanner scan = new Scanner(System.in);
        System.out.print("What's your name: ");
        name = scan.nextLine();
        System.out.println("Hello, "+name);
        while(Objects.equals(hasError,"true")) {
            System.out.print("How are you doing? (bad,ok,good)");
            howAmI = scan.nextLine();
            if ((Objects.equals(howAmI, "bad"))) {
                System.out.println("Hope you feel better");
                hasError="false";

            } else if ((Objects.equals(howAmI, "ok"))) {
                System.out.println("That's good");
                hasError="false";

            } else if (Objects.equals(howAmI, "good")) {
                System.out.println("That's great to hear");
                hasError="false";

            } else {
                System.out.println("Input error try again");

            }

        }
    }
}
