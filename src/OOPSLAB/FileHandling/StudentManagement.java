package OOPSLAB.FileHandling;

import java.io.*;
import java.util.Scanner;

public class StudentManagement {


        static String fileName = "C:\\Users\\CSE\\Desktop\\Java labs\\src\\OOPSLAB\\FileHandling\\results";

        static void addResult(String name, int marks) {
            try {
                FileWriter fw = new FileWriter(fileName, true);

                fw.write(name + "," + marks + "\n");

                fw.close();

                System.out.println("Result added successfully.");

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


        static void displayResults() {
            try {
                BufferedReader br =
                        new BufferedReader(new FileReader(fileName));

                String line;

                System.out.println("\n--- All Results ---");

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    System.out.println(
                            "Name: " + data[0] +
                                    ", Marks: " + data[1]);
                }

                br.close();

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        static void searchResult(String searchName) {
            try {
                BufferedReader br =
                        new BufferedReader(new FileReader(fileName));

                String line;
                boolean found = false;

                while ((line = br.readLine()) != null) {

                    String[] data = line.split(",");

                    if (data[0].equalsIgnoreCase(searchName)) {

                        System.out.println(
                                "Student Found: " +
                                        data[0] +
                                        ", Marks: " +
                                        data[1]);

                        found = true;
                        break;
                    }
                }

                br.close();

                if (!found) {
                    System.out.println("Student not found.");
                }

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n--- Online Exam Result Management System ---");
                System.out.println("1. Add Result");
                System.out.println("2. Display All Results");
                System.out.println("3. Search Student");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter marks: ");
                        int marks = sc.nextInt();

                        addResult(name, marks);
                        break;

                    case 2:
                        displayResults();
                        break;

                    case 3:
                        System.out.print("Enter student name to search: ");
                        String searchName = sc.nextLine();

                        searchResult(searchName);
                        break;

                    case 4:
                        System.out.println("Program ended.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
