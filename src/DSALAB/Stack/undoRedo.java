package DSALAB.Stack;
import java.util.*;

public class undoRedo {
    static void main(String[] args) {
        String[] undo;
        String[] redo;
        int undoTop=-1;
        int input;
        int redoTop=-1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the stack length: ");
        int stackLen = sc.nextInt();
        sc.nextLine();

        undo = new String[stackLen];
        redo = new String[stackLen];

        while (true){
            System.out.println("Select the operation need to perform:");
            System.out.println(" 1. Insert \n 2. Undo \n 3. Redo");
            input = sc.nextInt();
            sc.nextLine();
            switch (input){
                case 1:
                    if (undoTop == undo.length-1){
                        System.out.println("Stack over flow");
                        break;
                    }
                    System.out.println("Enter the Word need to insert");
                    String wordInput = sc.nextLine();
                    undoTop++;
                    undo[undoTop]= wordInput;
                    System.out.println(Arrays.toString(undo));
                    break;
                case 2:
                    if (undoTop < 0){
                        System.out.println("Insert a Value, nothing left to Undo");
                        break;
                    }
                    redoTop++;
                    redo[redoTop] = undo[undoTop];
                    undo[undoTop]=null;
                    undoTop--;
                    System.out.println(Arrays.toString(undo));
                    break;
                case 3:
                    if(redoTop<0||redoTop == redo.length+1){
                        System.out.println("invalid operation");
                        break;
                    }
                    undoTop++;
                    undo[undoTop]= redo[redoTop];
                    redo[redoTop]=null;
                    redoTop--;
                    System.out.println("Undo stack");
                    System.out.println(Arrays.toString(undo));
                    System.out.println("Redo Stack");
                    System.out.println(Arrays.toString(redo));
                    break;
                default:
                    System.out.println("Select the correct operation");
                    break;
            }
        }


    }
}
