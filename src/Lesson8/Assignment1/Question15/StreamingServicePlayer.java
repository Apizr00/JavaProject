package Lesson8.Assignment1.Question15;

public class StreamingServicePlayer implements MusicPlayer {

    private String currentTrack;

    public StreamingServicePlayer(String currentTrack) {

        this.currentTrack = currentTrack;
    }

    @Override
    public void play() {

        System.out.println("Streaming: " + currentTrack);
    }

    @Override
    public void pause() {

        System.out.println("Pausing: " + currentTrack);
    }

    @Override
    public void next() {

        System.out.println("Playing next track from streaming service");
        // Implement logic to switch to the next track from the streaming service
    }

    @Override
    public void previous() {

        System.out.println("Playing previous track from streaming service");
        // Implement logic to switch to the previous track from the streaming service
    }
}