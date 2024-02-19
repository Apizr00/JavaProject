package Lesson9.Assignment1.Question12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class SimpleCalendarApp extends JFrame {

    private JLabel monthLabel;
    private JPanel calendarPanel;
    private int currentMonth, currentYear;

    public SimpleCalendarApp() {

        setTitle("Simple Calendar");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get current month and year
        Calendar now = Calendar.getInstance();
        currentMonth = now.get(Calendar.MONTH);
        currentYear = now.get(Calendar.YEAR);

        // Initialize components
        monthLabel = new JLabel();
        calendarPanel = new JPanel(new GridLayout(0, 7));

        // Create header buttons
        JButton prevButton = new JButton("<< Prev");
        JButton nextButton = new JButton("Next >>");

        // Add action listeners to buttons
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMonth--;
                if (currentMonth < 0) {
                    currentMonth = 11;
                    currentYear--;
                }
                updateCalendar();
            }
        });

        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                currentMonth++;
                if (currentMonth > 11) {

                    currentMonth = 0;
                    currentYear++;
                }

                updateCalendar();
            }
        });

        // Add components to content pane
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(monthLabel, BorderLayout.NORTH);
        container.add(calendarPanel, BorderLayout.CENTER);
        container.add(prevButton, BorderLayout.WEST);
        container.add(nextButton, BorderLayout.EAST);

        // Update calendar display
        updateCalendar();
    }

    private void updateCalendar() {

        monthLabel.setText(getMonthName(currentMonth) + " " + currentYear);
        calendarPanel.removeAll();

        // Get calendar instance and set to the first day of the month
        Calendar cal = Calendar.getInstance();
        cal.set(currentYear, currentMonth, 1);

        // Get the number of days in the month
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Get the day of the week for the first day of the month
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // Add empty labels for preceding days
        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel());
        }

        // Add day labels
        for (int day = 1; day <= daysInMonth; day++) {
            JLabel dayLabel = new JLabel(String.valueOf(day));
            calendarPanel.add(dayLabel);
        }

        // Repaint the calendar panel
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private String getMonthName(int month) {

        String[] monthNames = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        return monthNames[month];
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new SimpleCalendarApp().setVisible(true);
            }
        });
    }
}
