package DSALAB.Stack;
import java.util.*;

public class switchStack {
    static void main() {
        Scanner sc = new Scanner(System.in);
        enum function{
            push,
            pop,
            peek,
            isempty
        }
        int[] arr;
        int top =-1;

        System.out.println("Initilise the Array length: ");
        int arrlen = sc.nextInt();

        arr = new int[arrlen];

       while (true){
           System.out.println("Available Operation: ");
           System.out.println(Arrays.toString(function.values()));
           sc.nextLine();
           System.out.println("Type the operation user need to perform: ");
           String input = sc.nextLine().trim().toLowerCase();

           function a = function.valueOf(input);
           switch (a) {
               case push:
                   if (top == arr.length - 1) {
                       System.out.println("Stack overflow");
                       return;
                   }
                   System.out.println("Enter the integer: ");
                   int value = sc.nextInt();
                   top++;
                   arr[top] = value;
                   System.out.println(Arrays.toString(arr));
                   break;

               case pop:
                   if (top == -1){
                       System.out.println("Stack Underflow");
                       break;
                   }
                   value = arr[top];
                   arr[top]=0;
                   top--;
                   System.out.println(value);
                   System.out.println(Arrays.toString(arr));
                   break;
               case peek:
                   if (top == -1){
                       System.out.println("Stack Underflow");
                       break;
                   }
                   System.out.println(arr[top]);
                   break;
               case isempty:
                   if (top == -1){
                       System.out.println("Stack is empty");
                       break;
                   }
                   System.out.println("Stack have some values");
                   break;
               case null, default:
                   System.out.println("Enter a valid argument");
                   break;
           }
       }
       }
    }