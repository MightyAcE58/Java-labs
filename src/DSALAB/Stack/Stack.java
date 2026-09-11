package DSALAB.Stack;
import java.util.Arrays;
public class Stack {

    static class Function {

        int[] arr;
        int top;

        Function(int size) {
            arr = new int[size];
            top = -1;
        }

        void push(int value) {

            if (top == arr.length - 1) {
                System.out.println("Stack overflow");
                return;
            }

            top++;
            arr[top] = value;
        }

        int pop() {

            if (top == -1) {
                System.out.println("Stack is empty");
                return -1;
            }

            int value = arr[top];
            top--;

            return value;
        }
        int peak(){
            if (top==-1){
                System.out.println("Stack underflow");
                return -1;
            }
            return arr[top];
        }

        void isEmpty(){
            if (top==-1){
                System.out.println("Stack is Empty");

            }
            System.out.println("Stack have Element");
        }

        void display() {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {

        Function s = new Function(5);

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        s.display();
        System.out.println("Pop example");
        System.out.println(s.pop());
        System.out.println("Peak example");
        System.out.println(s.peak());
        s.isEmpty();
    }
}