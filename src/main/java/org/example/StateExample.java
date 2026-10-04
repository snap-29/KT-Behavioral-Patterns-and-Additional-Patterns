package org.example;

interface TrafficLightState {

    void change(TrafficLight light);

    void show();
}

class RedState implements TrafficLightState {

    @Override
    public void change(TrafficLight light) {
        light.setState(new GreenState());
    }

    @Override
    public void show() {
        System.out.println(
                "Красный: движение запрещено"
        );
    }
}

class GreenState implements TrafficLightState {

    @Override
    public void change(TrafficLight light) {
        light.setState(new YellowState());
    }

    @Override
    public void show() {
        System.out.println(
                "Зелёный: движение разрешено"
        );
    }
}

class YellowState implements TrafficLightState {

    @Override
    public void change(TrafficLight light) {
        light.setState(new RedState());
    }

    @Override
    public void show() {
        System.out.println(
                "Жёлтый: приготовиться"
        );
    }
}

class TrafficLight {

    private TrafficLightState state;

    public TrafficLight() {
        state = new RedState();
    }

    public void setState(
            TrafficLightState state
    ) {
        this.state = state;
    }

    public void show() {
        state.show();
    }

    public void next() {
        state.change(this);
    }
}

public class StateExample {

    public static void main(String[] args) {

        TrafficLight light =
                new TrafficLight();

        light.show();

        light.next();
        light.show();

        light.next();
        light.show();

        light.next();
        light.show();
    }
}