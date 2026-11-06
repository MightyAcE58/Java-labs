package DSALAB.Linklist;

import java.util.Scanner;

public class Circluar {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;


    void insertBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }

        System.out.println("Node inserted at beginning.");
    }


    void insertEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        System.out.println("Node inserted at end.");
    }

    void insertAtPosition(int data, int position) {

        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertBeginning(data);
            return;
        }

        if (head == null) {
            System.out.println("Invalid position.");
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1; i++) {

            temp = temp.next;

            if (temp == head) {
                System.out.println("Invalid position.");
                return;
            }
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }

        System.out.println("Node inserted at position " + position + ".");
    }


    void deleteBeginning() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }

        System.out.println("First node deleted.");
    }


    void deleteEnd() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {

            Node temp = head;

            while (temp.next != tail) {
                temp = temp.next;
            }

            tail = temp;
            tail.next = head;
        }

        System.out.println("Last node deleted.");
    }


    void display() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        System.out.print("Circular Linked List: ");

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD");
    }


    void circularTraversal() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        System.out.println("\n--- CIRCULAR TRAVERSAL ---");

        System.out.print("HEAD -> ");

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);


        System.out.println(head.data + " -> HEAD");

        System.out.println("\nCircular connection:");
        System.out.println("Last node: " + tail.data);
        System.out.println("Last node.next: " + tail.next.data);
        System.out.println("Last node.next == HEAD: " + (tail.next == head));

        System.out.println("\nResult: The list is a CIRCULAR LINKED LIST.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Circluar list = new Circluar();

        int choice, data, position;

        do {

            System.out.println("\n--- SINGLY CIRCULAR LINKED LIST ---");

            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Display List");
            System.out.println("6. Circular Traversal");
            System.out.println("7. Insert at Any Position");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter data: ");
                    data = sc.nextInt();

                    list.insertBeginning(data);

                    break;

                case 2:

                    System.out.print("Enter data: ");
                    data = sc.nextInt();

                    list.insertEnd(data);

                    break;

                case 3:

                    list.deleteBeginning();

                    break;

                case 4:

                    list.deleteEnd();

                    break;

                case 5:

                    list.display();

                    break;

                case 6:

                    list.circularTraversal();

                    break;

                case 7:

                    System.out.print("Enter data: ");
                    data = sc.nextInt();

                    System.out.print("Enter position: ");
                    position = sc.nextInt();

                    list.insertAtPosition(data, position);

                    break;

                case 8:

                    System.out.println("Program ended.");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}