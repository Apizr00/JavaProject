package Lesson9.Assignment1.Question8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer extends JFrame {

    private JLabel imageLabel;
    private JButton prevButton, nextButton;
    private int currentIndex;
    private File[] imageFiles;

    public ImageViewer() {

        setTitle("Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");

        prevButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                showImage(--currentIndex);
            }
        });

        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                showImage(++currentIndex);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");

        openMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                openImage();
            }
        });

        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        currentIndex = 0;
    }

    private void openImage() {

        JFileChooser fileChooser = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(imageFilter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();
            File folder = selectedFile.getParentFile();
            imageFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg")
                    || name.toLowerCase().endsWith(".jpeg")
                    || name.toLowerCase().endsWith(".png")
                    || name.toLowerCase().endsWith(".gif"));

            for (int i = 0; i < imageFiles.length; i++) {

                if (selectedFile.equals(imageFiles[i])) {

                    currentIndex = i;
                    break;
                }
            }

            showImage(currentIndex);
        }
    }

    private void showImage(int index) {

        if (index < 0) {

            currentIndex = imageFiles.length - 1;
        } else if (index >= imageFiles.length) {
            currentIndex = 0;
        }

        ImageIcon imageIcon = new ImageIcon(imageFiles[currentIndex].getPath());
        Image scaledImage = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
                Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);

        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new ImageViewer().setVisible(true);
            }
        });
    }
}
