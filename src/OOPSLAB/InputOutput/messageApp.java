package OOPSLAB.InputOutput;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class messageApp {

    public static void main(String[] args) {


        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));


        try (FileWriter writer =
                     new FileWriter("C:\\\\Users\\\\CSE\\\\Desktop\\\\Java labs\\\\src\\\\OOPSLAB\\\\InputOutput\\\\input.txt", true)) {


            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            System.out.println("=== Chat Message Logger ===");
            System.out.println("Type your messages below.");
            System.out.println("Type 'exit' to stop chatting.\n");

            String message;

            while (true) {

                System.out.print("You: ");
                message = reader.readLine();


                if (message.equalsIgnoreCase("exit")) {
                    break;
                }


                String timestamp =
                        LocalDateTime.now().format(formatter);


                writer.write("[" + timestamp + "] " + message);
                writer.write(System.lineSeparator());

                writer.flush();
            }

            System.out.println("\nChat messages saved to input.txt");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

