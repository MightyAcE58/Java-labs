package JavaPractice.labpractice;

import java.util.*;

class Student {
    String name;
    int roll_no;
    int[] marks = new int [5];

    void getDetails (){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the student Name: ");
        name = sc.nextLine();

        System.out.println("Enter the student Roll.no: ");
        roll_no = sc.nextInt();

        for (int i = 0; i < 5; i++){
            System.out.println("Enter the Marks "+ (i+1)  + ": ");

            marks[i] = sc.nextInt();
        }

    }

void display(){
        int total=0;
        for (int i = 0; i < 5; i++){
            total = total + marks[i];
        }
    System.out.println("\nStudent Name: " + name);
    System.out.println("Roll Number: " + roll_no);
    System.out.println("Total Marks: " + total );
}
}
public class ClassAndObject {
    static void main(String[] args) {
        Student s1 = new Student();
        s1.getDetails();
        s1.display();
    }
}
