package Lesson8.Assignment1.Question9;

class SMSSender implements MessageSender {

    @Override
    public void sendMessage(String message) {

        System.out.println("Sending SMS: " + message);

    }
}
