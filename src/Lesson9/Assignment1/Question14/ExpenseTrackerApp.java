package Lesson9.Assignment1.Question14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExpenseTrackerApp extends JFrame {

    private ArrayList<Expense> expenses;
    private JList<Expense> expenseList;
    private DefaultListModel<Expense> listModel;

    private JTextField descriptionField;
    private JTextField amountField;

    public ExpenseTrackerApp() {

        expenses = new ArrayList<>();
        listModel = new DefaultListModel<>();

        expenseList = new JList<>(listModel);
        expenseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(expenseList);

        descriptionField = new JTextField(20);
        amountField = new JTextField(10);

        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                addExpense();
            }
        });

        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                editExpense();
            }
        });

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                deleteExpense();
            }
        });

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(listScrollPane, BorderLayout.CENTER);
        container.add(inputPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Expense Tracker");

        setVisible(true);
    }

    private void addExpense() {

        String description = descriptionField.getText();
        String amountText = amountField.getText();

        if (!description.isEmpty() && !amountText.isEmpty()) {

            double amount = Double.parseDouble(amountText);
            Expense expense = new Expense(description, amount);

            expenses.add(expense);
            listModel.addElement(expense);

            clearFields();

        } else {

            JOptionPane.showMessageDialog(this, "Please enter both description and amount.");
        }
    }

    private void editExpense() {

        int selectedIndex = expenseList.getSelectedIndex();

        if (selectedIndex != -1) {

            Expense selectedExpense = listModel.getElementAt(selectedIndex);

            String newDescription = JOptionPane.showInputDialog("Enter new description:",
                    selectedExpense.getDescription());
            String newAmountText = JOptionPane.showInputDialog("Enter new amount:", selectedExpense.getAmount());

            if (newDescription != null && newAmountText != null) {

                double newAmount = Double.parseDouble(newAmountText);

                selectedExpense.setDescription(newDescription);
                selectedExpense.setAmount(newAmount);

                listModel.setElementAt(selectedExpense, selectedIndex);

                clearFields();
            }
        } else {

            JOptionPane.showMessageDialog(this, "Please select an expense to edit.");
        }
    }

    private void deleteExpense() {

        int selectedIndex = expenseList.getSelectedIndex();

        if (selectedIndex != -1) {

            expenses.remove(selectedIndex);
            listModel.remove(selectedIndex);

        } else {

            JOptionPane.showMessageDialog(this, "Please select an expense to delete.");
        }
    }

    private void clearFields() {

        descriptionField.setText("");
        amountField.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new ExpenseTrackerApp());
    }
}

class Expense {

    private String description;
    private double amount;

    public Expense(String description, double amount) {

        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {

        return description;
    }

    public double getAmount() {

        return amount;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    @Override
    public String toString() {

        return description + " - RM" + amount;
    }
}
