package Lesson8.Assignment1.Question11;

class TVRemote implements RemoteControl {

    private boolean isPowerOn;
    private int volume;

    @Override
    public void powerOn() {

        isPowerOn = true;
        System.out.println("TV is powered on.");
    }

    @Override
    public void powerOff() {

        isPowerOn = false;
        System.out.println("TV is powered off.");
    }

    @Override
    public void volumeUp() {

        if (isPowerOn) {

            volume++;
            System.out.println("TV Volume Up: " + volume);

        } else {

            System.out.println("Turn on the TV first.");
        }
    }

    @Override
    public void volumeDown() {

        if (isPowerOn) {

            volume--;
            System.out.println("TV Volume Down: " + volume);

        } else {

            System.out.println("Turn on the TV first.");
        }
    }
}