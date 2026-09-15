import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n========================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Fast Search using HashMap");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Delete Student");
            System.out.println("7. Undo Last Deletion");
            System.out.println("8. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    Student student =
                            new Student(id, name, branch, marks);

                    manager.addStudent(student);
                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    manager.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int fastId = sc.nextInt();

                    manager.fastSearch(fastId);
                    break;

                case 5:
                    manager.sortStudents();
                    manager.displayStudents();
                    break;

                case 6:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    manager.deleteStudent(deleteId);
                    break;

                case 7:
                    manager.undo();
                    break;

                case 8:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}