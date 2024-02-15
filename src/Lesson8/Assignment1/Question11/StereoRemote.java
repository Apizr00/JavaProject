package Lesson8.Assignment1.Question11;

class StereoRemote implements RemoteControl {

    private boolean isPowerOn;
    private int volume;

    @Override
    public void powerOn() {

        isPowerOn = true;
        System.out.println("Stereo is powered on.");
    }

    @Override
    public void powerOff() {

        isPowerOn = false;
        System.out.println("Stereo is powered off.");
    }

    @Override
    public void volumeUp() {

        if (isPowerOn) {

            volume++;
            System.out.println("Stereo Volume Up: " + volume);

        } else {

            System.out.println("Turn on the Stereo first.");
        }
    }

    @Override
    public void volumeDown() {

        if (isPowerOn) {

            volume--;
            System.out.println("Stereo Volume Down: " + volume);

        } else {

            System.out.println("Turn on the Stereo first.");
        }
    }
}