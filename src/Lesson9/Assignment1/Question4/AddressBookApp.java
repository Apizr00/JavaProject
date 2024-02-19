package Lesson9.Assignment1.Question4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AddressBookApp extends JFrame {

    private Map<String, String> contacts;

    private JTextField nameField;
    private JTextField phoneField;
    private JTextArea displayArea;

    public AddressBookApp() {

        super("Address Book");

        contacts = new HashMap<>();

        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        JButton addButton = new JButton("Add Contact");
        JButton editButton = new JButton("Edit Contact");
        JButton deleteButton = new JButton("Delete Contact");

        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                addContact();
            }
        });

        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                editContact();
            }
        });

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                deleteContact();
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);

        JPanel controlPanel = new JPanel(new GridLayout(1, 2));
        controlPanel.add(deleteButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        setLayout(new FlowLayout());
        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addContact() {

        String name = nameField.getText();
        String phone = phoneField.getText();

        if (!name.isEmpty() && !phone.isEmpty()) {

            contacts.put(name, phone);
            updateDisplay();
            clearFields();

        } else {

            JOptionPane.showMessageDialog(this, "Name and phone fields cannot be empty.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editContact() {

        String name = nameField.getText();
        String phone = phoneField.getText();

        if (!name.isEmpty() && !phone.isEmpty()) {

            if (contacts.containsKey(name)) {

                contacts.put(name, phone);
                updateDisplay();
                clearFields();

            } else {

                JOptionPane.showMessageDialog(this, "Contact not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(this, "Name and phone fields cannot be empty.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteContact() {

        String name = nameField.getText();

        if (!name.isEmpty()) {

            if (contacts.containsKey(name)) {

                contacts.remove(name);
                updateDisplay();
                clearFields();

            } else {

                JOptionPane.showMessageDialog(this, "Contact not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(this, "Name field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDisplay() {

        displayArea.setText("");

        for (Map.Entry<String, String> entry : contacts.entrySet()) {

            displayArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

    private void clearFields() {

        nameField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new AddressBookApp();
            }
        });
    }
}
