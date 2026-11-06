package OOPSLAB.Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class swing extends JFrame implements ActionListener {

    JTextField name, contact;
    JComboBox<String> dept, doctor, time;
    JRadioButton inPerson, online;
    JButton book, cancel;
    JTable table;
    DefaultTableModel model;

    swing() {

        setTitle("Hospital Appointment Booking");
        setSize(800, 500);
        setLayout(new FlowLayout());

        add(new JLabel("Patient Name:"));
        name = new JTextField(12);
        add(name);

        add(new JLabel("Contact:"));
        contact = new JTextField(10);
        add(contact);

        add(new JLabel("Department:"));
        dept = new JComboBox<>(new String[]{
                "Cardiology",
                "Dermatology",
                "Orthopedics"
        });
        add(dept);

        add(new JLabel("Doctor:"));
        doctor = new JComboBox<>(new String[]{
                "Dr. Sharma",
                "Dr. Patel",
                "Dr. Khan"
        });
        add(doctor);

        add(new JLabel("Time:"));
        time = new JComboBox<>(new String[]{
                "10:00 AM",
                "12:00 PM",
                "3:00 PM",
                "5:00 PM"
        });
        add(time);

        add(new JLabel("Type:"));

        inPerson = new JRadioButton("In-person", true);
        online = new JRadioButton("Online");

        ButtonGroup group = new ButtonGroup();
        group.add(inPerson);
        group.add(online);

        add(inPerson);
        add(online);

        book = new JButton("Book Appointment");
        cancel = new JButton("Cancel Appointment");

        book.addActionListener(this);
        cancel.addActionListener(this);

        add(book);
        add(cancel);

        model = new DefaultTableModel(
                new String[]{
                        "Name",
                        "Contact",
                        "Department",
                        "Doctor",
                        "Time",
                        "Type"
                }, 0
        );

        table = new JTable(model);
        add(new JScrollPane(table));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == book) {

            if (name.getText().isEmpty() ||
                    contact.getText().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter patient name and contact number!"
                );

                return;
            }

            String selectedTime =
                    time.getSelectedItem().toString();


            for (int i = 0; i < model.getRowCount(); i++) {

                if (model.getValueAt(i, 4)
                        .equals(selectedTime)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Slot already booked!"
                    );

                    return;
                }
            }

            String type;

            if (inPerson.isSelected())
                type = "In-person";
            else
                type = "Online";


            model.addRow(new Object[]{
                    name.getText(),
                    contact.getText(),
                    dept.getSelectedItem(),
                    doctor.getSelectedItem(),
                    selectedTime,
                    type
            });

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment booked successfully!"
            );
        }


        if (e.getSource() == cancel) {

            int row = table.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Select an appointment to cancel."
                );

            } else {

                model.removeRow(row);

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment cancelled."
                );
            }
        }
    }

    public static void main(String[] args) {
        new swing();
    }
}