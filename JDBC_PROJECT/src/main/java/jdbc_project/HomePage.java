package jdbc_project;

import java.sql.SQLException;
import java.util.Scanner;

public class HomePage {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        RegistrationPage rs = new RegistrationPage();
        rs.getConnection();

        System.out.println("----- Welcome to My Application ----------");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("press 1: Registration");
            System.out.println("press 2: Login");
            System.out.println("press 3: Exit");
            System.out.println("Select choice:");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    rs.register();
                    break;
                case 2:
                    rs.login();
                    break;
                case 3:
                    System.out.println("---------successfully logged out---------");
                    System.out.println("-------THANKS FOR VISITING MY APPLICATION-------");
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            rs.getConnection().close();
        }
    }
}
