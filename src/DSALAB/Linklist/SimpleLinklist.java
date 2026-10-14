package DSALAB.Linklist;

import java.util.Scanner;

public class SimpleLinklist {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head = null;


    void printList() {
        System.out.print("Current List: ");

        for (Node c = head; c != null; c = c.next) {
            System.out.print(c.data + " -> ");
        }

        System.out.println("null");
    }


    void insertAtStart(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }


    void insertAtEnd(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node c = head;

        while (c.next != null) {
            c = c.next;
        }

        c.next = new Node(data);
    }

    void insertAtMiddle(int data, int pos) {
        if (pos <= 0) {
            insertAtStart(data);
            return;
        }

        if (head == null) {
            insertAtEnd(data);
            return;
        }

        Node c = head;

        for (int i = 0; c != null && i < pos - 1; i++) {
            c = c.next;
        }

        if (c == null) {
            insertAtEnd(data);
        } else {
            Node n = new Node(data);
            n.next = c.next;
            c.next = n;
        }
    }

    void deleteFromStart() {
        if (head != null) {
            head = head.next;
        }
    }

    void deleteFromEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node c = head;

        while (c.next.next != null) {
            c = c.next;
        }

        c.next = null;
    }


    void deleteFromMiddle(int pos) {
        if (head == null) {
            return;
        }

        if (pos <= 0) {
            deleteFromStart();
            return;
        }

        Node c = head;

        for (int i = 0; c != null && i < pos - 1; i++) {
            c = c.next;
        }

        if (c != null && c.next != null) {
            c.next = c.next.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SimpleLinklist list = new SimpleLinklist();


        System.out.print("How many initial elements (at end)? ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            list.insertAtEnd(sc.nextInt());
        }

        list.printList();


        System.out.print("\nEnter value for START: ");
        list.insertAtStart(sc.nextInt());
        list.printList();


        System.out.print("\nEnter value for MIDDLE: ");
        int val = sc.nextInt();

        System.out.print("Enter 0-indexed position: ");
        int pos = sc.nextInt();

        list.insertAtMiddle(val, pos);
        list.printList();


        System.out.println("\n--- Deletions ---");
        System.out.println("1. Start");
        System.out.println("2. End");
        System.out.println("3. Middle");

        System.out.print("Choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            list.deleteFromStart();
        }
        else if (choice == 2) {
            list.deleteFromEnd();
        }
        else if (choice == 3) {
            System.out.print("Enter index to delete: ");
            int deletePos = sc.nextInt();

            list.deleteFromMiddle(deletePos);
        }
        else {
            System.out.println("Invalid choice.");
        }

        list.printList();

        sc.close();
    }
}
