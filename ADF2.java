import java.sql.*;
import java.util.Scanner;

public class ADF2 {
    //1.1.Add student records
    public static void ex1_1() {
        Students students = new Students("", "", "", "");
        Scanner scanner = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/adf2?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
             Statement statement = conn.createStatement();
        ) {
            System.out.println("Enter your student ID: ");
            String id = scanner.nextLine();
            students.setId(id);
            System.out.println("Enter your student name:");
            String name = scanner.nextLine();
            students.setName(name);
            System.out.println("Enter your student of address:");
            String address = scanner.nextLine();
            students.setAddress(address);
            System.out.println("Enter your student of phone:");
            String phone = scanner.nextLine();
            students.setPhone(phone);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //1.2. Display student records
    public static void ex1_2() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/adf2?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select * from student";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()){
                String StudentID = rset.getString("StudentID");
                String StudentName = rset.getString("StudentName");
                String Address = rset.getString("Address");
                String Phone = rset.getString("Phone");

                System.out.println(StudentID + ", " + StudentName + ", " + Address + ", " + Phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //1.3.Save
    public static void ex1_3() {
        Students Students = new Students("", "", "", "");

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/adf2?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate("INSERT INTO student VALUES ('" + Students.getId() + "', '" + Students.getName() + "', '" + Students.getAddress() + "', '" + Students.getPhone() + "' )" );
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
