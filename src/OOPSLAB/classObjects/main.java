package OOPSLAB.classObjects;

import java.util.*;

class Student {
    String name;
    int rollNo;
    int[] marks = new int[5];

    void getDetails() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        name = sc.nextLine();

        System.out.print("Enter roll number: ");
        rollNo = sc.nextInt();

        System.out.println("Enter marks for 5 subjects out of Hundred :");

        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    void displayDetails() {
        int total = 0;

        for (int i = 0; i < 5; i++) {
            total = total + marks[i];
        }

        System.out.println("\nStudent Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Total Marks: " + total + "/500");
    }
}

public class main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.getDetails();
        s1.displayDetails();
    }
}