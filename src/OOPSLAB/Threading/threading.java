package OOPSLAB.Threading;

class TicketBooking {
    boolean booked = false;

    synchronized void bookTicket(String user) {
        if (!booked) {
            System.out.println(user + " is booking the seat...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            booked = true;
            System.out.println(user + " successfully booked the seat.");
        } else {
            System.out.println(user + " failed. Seat already booked.");
        }
    }
}

class User extends Thread {
    TicketBooking ticket;
    String user;

    User(TicketBooking ticket, String user) {
        this.ticket = ticket;
        this.user = user;
    }

    public void run() {
        ticket.bookTicket(user);
    }
}

public class threading {
    public static void main(String[] args) {
        TicketBooking ticket = new TicketBooking();

        User u1 = new User(ticket, "User 1");
        User u2 = new User(ticket, "User 2");
        User u3 = new User(ticket, "User 3");

        u1.start();
        u2.start();
        u3.start();
    }
}