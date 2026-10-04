package org.example;
interface ComputerVisitor {

    void visit(Processor processor);

    void visit(VideoCard videoCard);

    void visit(Monitor monitor);
}

interface ComputerPart {

    void accept(ComputerVisitor visitor);
}

class Processor implements ComputerPart {

    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
}

class VideoCard implements ComputerPart {

    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
}

class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerVisitor visitor) {
        visitor.visit(this);
    }
}

class ServiceEngineer
        implements ComputerVisitor {

    @Override
    public void visit(Processor processor) {
        System.out.println(
                "Проверка процессора"
        );
    }

    @Override
    public void visit(VideoCard videoCard) {
        System.out.println(
                "Проверка видеокарты"
        );
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println(
                "Проверка монитора"
        );
    }
}

public class VisitorExample {

    public static void main(String[] args) {

        ComputerPart[] parts = {
                new Processor(),
                new VideoCard(),
                new Monitor()
        };

        ComputerVisitor engineer =
                new ServiceEngineer();

        for (ComputerPart part : parts) {
            part.accept(engineer);
        }
    }
}