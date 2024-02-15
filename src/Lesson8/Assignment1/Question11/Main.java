package Lesson8.Assignment1.Question11;

public class Main {
    public static void main(String[] args) {

        TVRemote tvRemote = new TVRemote();
        tvRemote.powerOn();
        tvRemote.volumeUp();
        tvRemote.volumeDown();
        tvRemote.powerOff();

        StereoRemote stereoRemote = new StereoRemote();
        stereoRemote.powerOn();
        stereoRemote.volumeUp();
        stereoRemote.volumeDown();
        stereoRemote.powerOff();

    }
}
