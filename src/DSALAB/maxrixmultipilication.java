package DSALAB;

import java.util.Scanner;

public class maxrixmultipilication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the rows and columns of first matrix:");
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();

        System.out.println("Enter the rows and columns of second matrix:");
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        if (c1 != r2) {
            System.out.println("Columns of first matrix must be equal to rows of second matrix.");
            scanner.close();
            return;
        }

        int[][] first = new int[r1][c1];
        int[][] second = new int[r2][c2];
        int[][] result = new int[r1][c2];

        System.out.println("Enter the elements of the first matrix:");

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.printf("Enter element a[%d][%d]: ", i+1, j+1);
                first[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of the second matrix:");

        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.printf("Enter element b[%d][%d]: ", i+1, j+1);
                second[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < c1; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        System.out.println("\nResult Matrix:");

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}