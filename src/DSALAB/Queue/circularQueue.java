package DSALAB.Queue;

import java.util.*;

public class circularQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the playlist size: ");
        int length = sc.nextInt();
        sc.nextLine();

        String[] song = new String[length];

        int front = -1;
        int rear = -1;

        while (true) {

            System.out.println("\nEnter the operation:");
            System.out.println("1. Insert Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    if ((rear + 1) % length == front) {
                        System.out.println("Playlist is full!");
                    } else {

                        System.out.print("Enter song name: ");
                        String songName = sc.nextLine();
                        
                        if (front == -1) {
                            front = 0;
                        }

                        rear = (rear + 1) % length;

                        song[rear] = songName;

                        System.out.println(songName + " added to playlist.");
                    }
                    break;

                case 2:

                    if (front == -1) {
                        System.out.println("Playlist is empty!");
                    } else {

                        System.out.println(song[front] + " removed from playlist.");

                        if (front == rear) {
                            front = -1;
                            rear = -1;
                        } else {
                            front = (front + 1) % length;
                        }
                    }
                    break;

                case 3:

                    if (front == -1) {
                        System.out.println("Playlist is empty!");
                    } else {

                        System.out.println("Current Playlist:");

                        int i = front;

                        while (true) {
                            System.out.println(song[i]);

                            if (i == rear) {
                                break;
                            }
                            i = (i + 1) % length;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting playlist...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
