package org.example;

class GameSettingsMemento {

    private final int volume;
    private final String difficulty;

    public GameSettingsMemento(
            int volume,
            String difficulty
    ) {
        this.volume = volume;
        this.difficulty = difficulty;
    }

    public int getVolume() {
        return volume;
    }

    public String getDifficulty() {
        return difficulty;
    }
}

class GameSettings {

    private int volume;
    private String difficulty;

    public GameSettings(
            int volume,
            String difficulty
    ) {
        this.volume = volume;
        this.difficulty = difficulty;
    }

    public void show() {

        System.out.println(
                "Громкость: " + volume +
                        ", сложность: " + difficulty
        );
    }

    public void change(
            int volume,
            String difficulty
    ) {

        this.volume = volume;
        this.difficulty = difficulty;

        System.out.println(
                "Настройки изменены"
        );

        show();
    }

    public GameSettingsMemento save() {

        System.out.println(
                "Настройки сохранены"
        );

        return new GameSettingsMemento(
                volume,
                difficulty
        );
    }

    public void restore(
            GameSettingsMemento memento
    ) {

        volume = memento.getVolume();
        difficulty = memento.getDifficulty();

        System.out.println(
                "Настройки восстановлены"
        );

        show();
    }
}

class SettingsHistory {

    private GameSettingsMemento backup;

    public void save(
            GameSettingsMemento memento
    ) {
        backup = memento;
    }

    public GameSettingsMemento getBackup() {
        return backup;
    }
}

public class MementoExample {

    public static void main(String[] args) {

        GameSettings settings =
                new GameSettings(
                        70,
                        "Средняя"
                );

        System.out.println("Исходные настройки:");
        settings.show();

        SettingsHistory history =
                new SettingsHistory();

        history.save(settings.save());

        System.out.println();

        settings.change(
                100,
                "Очень сложная"
        );

        System.out.println();

        settings.restore(
                history.getBackup()
        );
    }
}