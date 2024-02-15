package Lesson8.Assignment1.Question9;

class EmailSender implements MessageSender {

    @Override
    public void sendMessage(String message) {

        System.out.println("Sending email: " + message);

    }
}