package Lesson8.Assignment1.Question9;

public class MessageSenderTest {

    public static void main(String[] args) {

        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();

        emailSender.sendMessage("Hello, this is an email message.");
        smsSender.sendMessage("Hello, this is an SMS message.");
    }
}
