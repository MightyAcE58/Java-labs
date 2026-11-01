package DSALAB.Linklist;

class DoublyCircular {

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    void insert(int data) {
        Node n = new Node(data);

        if (head == null) {
            head = n;
            n.next = n;
            n.prev = n;
            return;
        }

        Node last = head.prev;

        n.next = head;
        n.prev = last;

        last.next = n;
        head.prev = n;
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
        DoublyCircular list = new DoublyCircular();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();
    }
}