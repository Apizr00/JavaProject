package Lesson9.Assignment1.Question6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileExplorer extends JFrame {

    private JList<String> fileList;
    private DefaultListModel<String> listModel;

    public FileExplorer() {
        setTitle("File Explorer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        // Create components
        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(fileList);
        JButton openButton = new JButton("Open");
        JButton deleteButton = new JButton("Delete");

        // Set layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set actions
        openButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                openSelectedFile();
            }
        });

        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                deleteSelectedFile();
            }
        });

        // Set default directory
        updateFileList(System.getProperty("user.home"));
    }

    private void updateFileList(String directoryPath) {

        listModel.clear();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {

                listModel.addElement(file.getName());
            }
        }
    }

    private void openSelectedFile() {

        String selectedFileName = fileList.getSelectedValue();

        if (selectedFileName != null) {

            String currentDirectory = System.getProperty("user.home");
            String filePath = currentDirectory + File.separator + selectedFileName;

            // You can implement logic to open the file or perform specific actions here
            JOptionPane.showMessageDialog(this, "Opening file: " + filePath);
        }
    }

    private void deleteSelectedFile() {

        String selectedFileName = fileList.getSelectedValue();

        if (selectedFileName != null) {

            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this file?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {

                String currentDirectory = System.getProperty("user.home");
                String filePath = currentDirectory + File.separator + selectedFileName;

                File fileToDelete = new File(filePath);

                if (fileToDelete.delete()) {

                    updateFileList(currentDirectory);
                    JOptionPane.showMessageDialog(this, "File deleted successfully.");

                } else {

                    JOptionPane.showMessageDialog(this, "Unable to delete the file.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new FileExplorer().setVisible(true);
            }
        });
    }
}
