package OOPSLAB;

import java.util.Scanner;

class Student {
     String name;
     int rollNo;

    public void inputStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextInt();
    }

    public void showStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number : " + rollNo);
    }
}

class MCAStudent extends Student {
    int semester;
    double cgpa;

    public void inputMCAStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Semester : ");
        semester = sc.nextInt();
        System.out.print("Enter CGPA : ");
        cgpa = sc.nextDouble();
    }

    public void showMCAStudent() {
        System.out.println("Semester : " + semester);
        System.out.println("CGPA : " + cgpa);
    }
}

public class Main {
    public static void main(String[] args) {
        MCAStudent s = new MCAStudent();

        s.inputStudent();
        s.inputMCAStudent();

        System.out.println("\nStudent Details:");
        s.showStudent();
        s.showMCAStudent();
    }
}
