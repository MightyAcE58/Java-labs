package DSALAB;
import java.util.*;

public class numbertostring {
    public static void main(String[] args){
        Scanner nums = new Scanner(System.in);

        System.out.println("Enter a Number (1-100): ");
        int num  = nums.nextInt();
        String[] ones = {
                "", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {
                "", "", "Twenty", "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        if (num < 1 || num > 100) {
            System.out.println("Please enter a number between 1 and 100.");
        } else if (num == 100) {
            System.out.println("One Hundred");
        } else if (num < 20) {
            System.out.println(ones[num]);
        } else {
            int t = num / 10;
            int o = num % 10;

            if (o == 0) {
                System.out.println(tens[t]);
            } else {
                System.out.println(tens[t] + " " + ones[o]);
            }
        }
    nums.close();
    }
}
