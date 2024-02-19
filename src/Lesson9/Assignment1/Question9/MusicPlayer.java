package Lesson9.Assignment1.Question9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicPlayer extends JFrame {

    private JButton playButton, pauseButton, stopButton, skipButton;
    private JSlider volumeSlider;

    public MusicPlayer() {
        setTitle("Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
        skipButton = new JButton("Skip");
        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

        // Add action listeners
        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Add your play logic here
                System.out.println("Playing music...");
            }
        });

        pauseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Add your pause logic here
                System.out.println("Pausing music...");
            }
        });

        stopButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Add your stop logic here
                System.out.println("Stopping music...");
            }
        });

        skipButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Add your skip logic here
                System.out.println("Skipping to next track...");
            }
        });

        volumeSlider.addChangeListener(e -> {

            // Add your volume control logic here
            int volume = volumeSlider.getValue();
            System.out.println("Volume changed to: " + volume);
        });

        // Create layout
        JPanel panel = new JPanel();
        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(stopButton);
        panel.add(skipButton);
        panel.add(volumeSlider);

        // Set layout manager
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(panel));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(panel));
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            MusicPlayer musicPlayer = new MusicPlayer();
            musicPlayer.setVisible(true);
        });
    }
}
