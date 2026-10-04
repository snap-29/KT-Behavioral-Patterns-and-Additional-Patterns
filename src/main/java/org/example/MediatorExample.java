package org.example;

interface AirTrafficControl {
    void requestLanding(Airplane airplane);
}

class ControlTower implements AirTrafficControl {

    @Override
    public void requestLanding(Airplane airplane) {
        System.out.println(
                "Диспетчер получил запрос от самолёта "
                        + airplane.getNumber()
        );

        System.out.println(
                "Посадка самолёту "
                        + airplane.getNumber()
                        + " разрешена"
        );
    }
}

class Airplane {

    private final String number;
    private final AirTrafficControl control;

    public Airplane(
            String number,
            AirTrafficControl control
    ) {
        this.number = number;
        this.control = control;
    }

    public String getNumber() {
        return number;
    }

    public void land() {
        control.requestLanding(this);
    }
}

public class MediatorExample {

    public static void main(String[] args) {

        ControlTower tower =
                new ControlTower();

        Airplane plane1 =
                new Airplane("SU-100", tower);

        Airplane plane2 =
                new Airplane("S7-205", tower);

        plane1.land();

        System.out.println();

        plane2.land();
    }
}