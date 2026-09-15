import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class StudentManager {

    // ArrayList to store students
    private ArrayList<Student> students = new ArrayList<>();

    // Stack for undo operations
    private Stack<Student> deletedStudents = new Stack<>();

    // Queue for pending requests
    private Queue<Student> pendingStudents = new LinkedList<>();

    // HashMap for fast ID lookup
    private HashMap<Integer, Student> studentMap = new HashMap<>();


    // Add Student
    public void addStudent(Student student) {

        students.add(student);

        studentMap.put(student.id, student);

        System.out.println("Student added successfully.");
    }


    // Display Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n========== STUDENT LIST ==========");

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("==================================");
    }


    // Search Student using Linear Search
    public void searchStudent(int id) {

        Student student = Algorithms.linearSearch(students, id);

        if (student != null) {
            System.out.println("\nStudent Found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }


    // Search using HashMap
    public void fastSearch(int id) {

        Student student = studentMap.get(id);

        if (student != null) {
            System.out.println("\nStudent Found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }


    // Sort Students
    public void sortStudents() {

        Algorithms.bubbleSort(students);

        System.out.println("Students sorted by marks.");
    }


    // Delete Student
    public void deleteStudent(int id) {

        Student student = Algorithms.linearSearch(students, id);

        if (student != null) {

            students.remove(student);

            studentMap.remove(id);

            // Push deleted student into Stack
            deletedStudents.push(student);

            System.out.println("Student deleted successfully.");

        } else {

            System.out.println("Student not found.");
        }
    }


    // Undo Delete
    public void undo() {

        if (deletedStudents.isEmpty()) {

            System.out.println("Nothing to undo.");
            return;
        }

        Student student = deletedStudents.pop();

        students.add(student);

        studentMap.put(student.id, student);

        System.out.println("Last deletion undone.");
    }


    // Add student to Queue
    public void addToQueue(Student student) {

        pendingStudents.add(student);

        System.out.println("Student added to pending queue.");
    }


    // Process Queue
    public void processQueue() {

        if (pendingStudents.isEmpty()) {

            System.out.println("Queue is empty.");
            return;
        }

        Student student = pendingStudents.poll();

        System.out.println("Processing student:");
        System.out.println(student);
    }
}