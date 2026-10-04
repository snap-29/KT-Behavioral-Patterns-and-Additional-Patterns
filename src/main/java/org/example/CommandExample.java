package org.example;

interface MusicCommand {

    void execute();
}

class MusicPlayer {

    public void play() {
        System.out.println(
                "Музыка запущена"
        );
    }

    public void pause() {
        System.out.println(
                "Музыка поставлена на паузу"
        );
    }

    public void nextTrack() {
        System.out.println(
                "Переключение на следующий трек"
        );
    }
}

class PlayCommand implements MusicCommand {

    private final MusicPlayer player;

    public PlayCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}

class PauseCommand implements MusicCommand {

    private final MusicPlayer player;

    public PauseCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.pause();
    }
}

class NextTrackCommand
        implements MusicCommand {

    private final MusicPlayer player;

    public NextTrackCommand(
            MusicPlayer player
    ) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.nextTrack();
    }
}

class MusicPanel {

    private MusicCommand command;

    public void setCommand(
            MusicCommand command
    ) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandExample {

    public static void main(String[] args) {

        MusicPlayer player =
                new MusicPlayer();

        MusicPanel panel =
                new MusicPanel();

        panel.setCommand(
                new PlayCommand(player)
        );
        panel.pressButton();

        panel.setCommand(
                new NextTrackCommand(player)
        );
        panel.pressButton();

        panel.setCommand(
                new PauseCommand(player)
        );
        panel.pressButton();
    }
}