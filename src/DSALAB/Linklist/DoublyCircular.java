package DSALAB.Linklist;

import java.util.Scanner;

class DoublyCircular {

    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;


    void insertBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;


            head.next = head;
            head.prev = head;

        } else {
            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;
            tail.next = newNode;

            head = newNode;
        }

        System.out.println("Node inserted at beginning.");
    }

    void insertEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;

            // Circular connection
            head.next = head;
            head.prev = head;

        } else {
            newNode.prev = tail;
            newNode.next = head;

            tail.next = newNode;
            head.prev = newNode;

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
        newNode.prev = temp;

        temp.next.prev = newNode;
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

            head.prev = tail;
            tail.next = head;
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

            tail.next = head;
            head.prev = tail;
        }

        System.out.println("Last node deleted.");
    }

    void displayForward() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;

        System.out.print("Forward: ");

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;

        } while (temp != head);

        System.out.println("HEAD");
    }

    void displayBackward() {

        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = tail;

        System.out.print("Backward: ");

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;

        } while (temp != tail);

        System.out.println("TAIL");
    }

    void circularTraversalForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.println("\n--- FORWARD CIRCULAR TRAVERSAL ---");
        System.out.print("Traversal: ");
        do {
            System.out.print(temp.data);

            temp = temp.next;

            if (temp != head) {
                System.out.print(" -> ");
            }

        } while (temp != head);

        System.out.println(" -> " + head.data + " (HEAD)");

        System.out.println("\nTraversal completed.");

        System.out.println(
                "Last node " + tail.data +
                        " points back to first node " + head.data + "."
        );
    }


    void circularTraversalBackward() {

        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = tail;

        System.out.println("\n--- BACKWARD CIRCULAR TRAVERSAL ---");

        System.out.print("Traversal: ");

        do {
            System.out.print(temp.data);

            temp = temp.prev;

            if (temp != tail) {
                System.out.print(" -> ");
            }

        } while (temp != tail);

        System.out.println(" -> " + tail.data + " (TAIL)");

        System.out.println("\nTraversal completed.");

        System.out.println(
                "First node " + head.data +
                        " points back to last node " + tail.data + "."
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DoublyCircular list = new DoublyCircular();

        int choice;
        int data;
        int position;

        do {

            System.out.println("\n--- DOUBLY CIRCULAR LINKED LIST ---");

            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Beginning");
            System.out.println("4. Delete from End");
            System.out.println("5. Display Forward");
            System.out.println("6. Display Backward");
            System.out.println("7. Insert at Any Position");
            System.out.println("8. Forward Circular Traversal");
            System.out.println("9. Backward Circular Traversal");
            System.out.println("10. Exit");

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

                    list.circularTraversalForward();

                    break;

                case 9:

                    list.circularTraversalBackward();

                    break;

                case 10:

                    System.out.println("Program ended.");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 10);

        sc.close();
    }
}