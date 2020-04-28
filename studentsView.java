import java.util.Scanner;

public class studentsView {
    public static void main(String[] args) {
        int i = 1;
        while(i > 0) {
            System.out.println("1.Add student records\n" +
                    "2. Display student recods\n" +
                    "3. Save\n" +
                    "4. Exit");
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1:
                    System.out.println("Add student records:");
                    ADF2.ex1_1();
                    break;
                case 2:
                    System.out.println("Display student records");
                    ADF2.ex1_2();
                    break;
                case 3:
                    System.out.println("Save");
                    ADF2.ex1_3();
                    break;
                case 4:
                    System.out.println("End");
                    i = -1;break;
                default:
                    System.out.println("nothing");break;
            }
        }
    }
}
