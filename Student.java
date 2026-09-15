public class Student {

    int id;
    String name;
    String branch;
    double marks;

    public Student(int id, String name, String branch, double marks) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %-5d | Name: %-15s | Branch: %-10s | Marks: %.2f",
                id, name, branch, marks
        );
    }
}