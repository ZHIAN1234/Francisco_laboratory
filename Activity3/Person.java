package Activity3;

import java.util.Scanner;

public class Person {
    private String name;
    private int id;

public Person (String name, int id) {
    this.name = name;
    this.id = id;

}

public void displayInfo() {
    System.out.println("Name: " + name);
    System.out.println("ID: " + id);

    }
}

 class SchoolTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        Student student = new Student("Ria", 2023, "3rd");
        Teacher teacher = new Teacher("Jorgina", 143, "Integral Calculus");
        Staff staff = new Staff("Jethro", 998, "IT" );
    

    System.out.println("Student Information: ");
    student.displayInfo();
    System.out.println();

    System.out.println("Teacher: ");
    teacher.displayInfo();
    System.out.println();

    System.out.println("Staff: ");
    staff.displayInfo();
    System.out.println();

    scan.close();

    }
}
