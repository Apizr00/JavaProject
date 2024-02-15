package Lesson8.Assignment1.Question15;

public class MP3Player implements MusicPlayer {

    private String currentTrack;

    public MP3Player(String currentTrack) {

        this.currentTrack = currentTrack;
    }

    @Override
    public void play() {

        System.out.println("Playing: " + currentTrack);
    }

    @Override
    public void pause() {

        System.out.println("Pausing: " + currentTrack);
    }

    @Override
    public void next() {

        System.out.println("Playing next track");
        // Implement logic to switch to the next track
    }

    @Override
    public void previous() {

        System.out.println("Playing previous track");
        // Implement logic to switch to the previous track
    }
}
