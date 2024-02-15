package Lesson8.Assignment1.Question15;

public class Main {
    public static void main(String[] args) {

        MP3Player mp3Player = new MP3Player("Song 1");
        mp3Player.play();
        mp3Player.pause();
        mp3Player.next();
        mp3Player.previous();

        StreamingServicePlayer streamingPlayer = new StreamingServicePlayer("Track A");
        streamingPlayer.play();
        streamingPlayer.pause();
        streamingPlayer.next();
        streamingPlayer.previous();
    }
}