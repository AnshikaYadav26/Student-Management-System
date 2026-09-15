import java.util.ArrayList;

public class Algorithms {

    // Linear Search
    public static Student linearSearch(ArrayList<Student> students, int id) {

        for (Student student : students) {

            if (student.id == id) {
                return student;
            }
        }

        return null;
    }

    // Bubble Sort - Sort by marks in descending order
    public static void bubbleSort(ArrayList<Student> students) {

        int n = students.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (students.get(j).marks < students.get(j + 1).marks) {

                    Student temp = students.get(j);

                    students.set(j,
                            students.get(j + 1));

                    students.set(j + 1, temp);
                }
            }
        }
    }
}