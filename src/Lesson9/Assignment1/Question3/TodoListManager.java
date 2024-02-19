package Lesson9.Assignment1.Question3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListManager extends JFrame {

    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField taskInput;

    public TodoListManager() {

        setTitle("ToDo List Manager");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton completeButton = new JButton("Mark Completed");
        JButton deleteButton = new JButton("Delete Task");

        // Layout
        setLayout(new BorderLayout());
        add(new JScrollPane(todoList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(completeButton);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Add Task Button Action
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                addTask();
            }
        });

        // Mark Completed Button Action
        completeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                markCompleted();
            }
        });

        // Delete Task Button Action
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                deleteTask();
            }
        });
    }

    private void addTask() {

        String task = taskInput.getText().trim();

        if (!task.isEmpty()) {

            todoListModel.addElement(task);
            taskInput.setText("");
        }
    }

    private void markCompleted() {

        int selectedIndex = todoList.getSelectedIndex();

        if (selectedIndex != -1) {

            String task = todoListModel.getElementAt(selectedIndex);
            todoListModel.remove(selectedIndex);
            todoListModel.addElement("[Completed] " + task);
        }
    }

    private void deleteTask() {

        int selectedIndex = todoList.getSelectedIndex();

        if (selectedIndex != -1) {

            todoListModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new TodoListManager().setVisible(true);
            }
        });
    }
}
