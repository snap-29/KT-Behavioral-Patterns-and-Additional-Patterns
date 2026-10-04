package org.example;

import java.util.ArrayList;
import java.util.List;

interface TemperatureObserver {

    void temperatureChanged(int temperature);
}

class ServerMonitor implements TemperatureObserver {

    @Override
    public void temperatureChanged(int temperature) {

        System.out.println(
                "Монитор сервера: температура "
                        + temperature
                        + "°C"
        );
    }
}

class EmergencySystem
        implements TemperatureObserver {

    @Override
    public void temperatureChanged(int temperature) {

        if (temperature >= 80) {
            System.out.println(
                    "ТРЕВОГА! Температура слишком высокая!"
            );
        }
    }
}

class Server {

    private int temperature;

    private final List<TemperatureObserver>
            observers = new ArrayList<>();

    public void subscribe(
            TemperatureObserver observer
    ) {
        observers.add(observer);
    }

    public void setTemperature(int temperature) {

        this.temperature = temperature;

        notifyObservers();
    }

    private void notifyObservers() {

        for (TemperatureObserver observer :
                observers) {

            observer.temperatureChanged(temperature);
        }
    }
}

public class ObserverExample {

    public static void main(String[] args) {

        Server server = new Server();

        server.subscribe(
                new ServerMonitor()
        );

        server.subscribe(
                new EmergencySystem()
        );

        server.setTemperature(55);

        System.out.println();

        server.setTemperature(85);
    }
}