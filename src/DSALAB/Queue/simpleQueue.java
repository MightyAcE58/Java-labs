package DSALAB.Queue;
import java.util.*;

// ticket booking reception
public class simpleQueue {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a;
        System.out.println("Enter the size of the Queue");
        int len = sc.nextInt();
        a= new int[len];
        int head =0;
        int tail=0;
        while(true){
            System.out.println("Operation available for Queue: ");
            System.out.println(" 1. Enqueue \n 2. de-queue \n 3. Display");
            int input = sc.nextInt();

            switch (input){
                case 1:
                    if (tail == a.length){
                        System.out.println("Queue overflow");
                        break;
                    }
                    System.out.println("Enter the Value:");
                    int in = sc.nextInt();
                    a[tail]= in;
                    tail++;
                    System.out.println(Arrays.toString(a));
                    break;
                case 2:
                    if (head == tail){
                        System.out.println();
                        System.out.println("Queue overflow");
                        break;
                    }
                    a[head]= 0;
                    head++;
                    System.out.println(Arrays.toString(a));
                    break;
                case 3:
//                    if (tail == a.length){
//                        System.out.println("Queue overflow");
//                        break;
//                    }
//                    System.out.println("Enter the value: ");
//                    int en = sc.nextInt();
//                    sc.nextLine();
//                    a[tail]= en;
//                    tail++;
//                    System.out.println(Arrays.toString(a));
//                    break;\
                    for (int i = head; i < tail; i++){
                        System.out.print(a[i] + " ");
                        System.out.println();

                    }
            }

        }



    }
}
