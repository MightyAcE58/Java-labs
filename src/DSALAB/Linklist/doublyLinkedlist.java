package DSALAB.Linklist;
import java.util.Scanner;

public class doublyLinkedlist {

    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head, tail;

    void insertBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Node inserted at beginning.");
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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

        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode;
        }

        temp.next = newNode;

        System.out.println("Node inserted at position " + position);
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
            head.prev = null;
        }
        System.out.println("First node deleted.");
    }

    void deleteEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Last node deleted.");
    }

    void displayForward() {
        Node temp = head;

        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.print("Forward: NULL <-> ");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    void displayBackward() {
        Node temp = tail;

        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.print("Backward: NULL <-> ");

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        doublyLinkedlist list = new doublyLinkedlist();
        int choice, data, position;
        do {
            System.out.println("\n--- DOUBLY LINKED LIST ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Display Forward");
            System.out.println("6. Display Backward");
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
                    list.displayForward();
                    break;

                case 6:
                    list.displayBackward();
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