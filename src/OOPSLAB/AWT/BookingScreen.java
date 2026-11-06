package OOPSLAB.AWT;

import java.awt.*;
import java.awt.event.*;

public class BookingScreen extends Frame implements ActionListener {

    TextField name, mobile, tickets;
    Choice movie;
    List show;
    Checkbox silver, gold, platinum;
    TextArea summary;
    Button book;

    BookingScreen() {
        this.setTitle("Movie Ticket Booking");
        setSize(450, 500);
        setLayout(new FlowLayout());

        add(new Label("Customer Name:"));
        name = new TextField(20);
        add(name);

        add(new Label("Mobile Number:"));
        mobile = new TextField(20);
        add(mobile);

        add(new Label("Movie:"));
        movie = new Choice();
        movie.add("Avengers");
        movie.add("Interstellar");
        movie.add("Inception");
        add(movie);

        add(new Label("Show Time:"));
        show = new List(4, false);
        show.add("Morning");
        show.add("Afternoon");
        show.add("Evening");
        show.add("Night");
        add(show);

        add(new Label("Seat Category:"));
        CheckboxGroup cg = new CheckboxGroup();
        silver = new Checkbox("Silver",cg, true);
        gold = new Checkbox("Gold", cg,false);
        platinum = new Checkbox("Platinum", cg,false);
        add(silver);
        add(gold);
        add(platinum);

        add(new Label("Tickets:"));
        tickets = new TextField(5);
        add(tickets);

        book = new Button("Book Now");
        book.addActionListener(this);
        add(book);

        summary = new TextArea(8, 40);
        add(summary);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int n = Integer.parseInt(tickets.getText());
        int price = silver.getState() ? 150 : gold.getState() ? 250 : 350;
        int total = n * price;

        summary.setText(
                "Booking Summary\n" +
                        "Name: " + name.getText() + "\n" +
                        "Mobile: " + mobile.getText() + "\n" +
                        "Movie: " + movie.getSelectedItem() + "\n" +
                        "Show: " + show.getSelectedItem() + "\n" +
                        "Tickets: " + n + "\n" +
                        "Total Price: ₹" + total
        );
    }

    public static void main(String[] args) {
        new BookingScreen();
    }
}