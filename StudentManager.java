import java.util.*;

class Student {
    int roll;
    String name;
    double marks;

    Student(int r, String n, double m) {
        roll = r;
        name = n;
        marks = m;
    }

    public String toString() {
        return roll + " - " + name + " - " + marks;
    }
}

public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter Roll, Name, Marks: ");
                int r = sc.nextInt();
                String n = sc.next();
                double m = sc.nextDouble();
                list.add(new Student(r, n, m));
            } 
            else if (ch == 2) {
                System.out.println("\nAll Students:");
                for (Student s : list)
                    System.out.println(s);
            } 
            else if (ch == 3) {
                System.out.print("Enter Roll to search: ");
                int r = sc.nextInt();
                boolean found = false;
                for (Student s : list) {
                    if (s.roll == r) {
                        System.out.println("Found: " + s);
                        found = true;
                    }
                }
                if (!found)
                    System.out.println("No student found.");
            } 
            else {
                System.out.println("Exiting...");
                break;
            }
        }
        sc.close();
    }
}
