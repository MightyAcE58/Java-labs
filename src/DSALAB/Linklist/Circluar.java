package DSALAB.Linklist;

class CircularLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    void insert(int data) {
        Node n = new Node(data);

        if (head == null) {
            head = n;
            n.next = head;
            return;
        }

        Node temp = head;

        while (temp.next != head)
            temp = temp.next;

        temp.next = n;
        n.next = head;
    }

    void display() {
        if (head == null)
            return;

        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();
    }
}