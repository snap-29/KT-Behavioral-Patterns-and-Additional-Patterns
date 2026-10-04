package org.example;

abstract class ReportGenerator {

    public final void generate() {
        openDocument();
        createHeader();
        createBody();
        createFooter();
        closeDocument();
    }

    private void openDocument() {
        System.out.println("Открытие документа");
    }

    protected abstract void createHeader();

    protected abstract void createBody();

    protected abstract void createFooter();

    private void closeDocument() {
        System.out.println("Закрытие документа");
    }
}

class SalesReport extends ReportGenerator {

    @Override
    protected void createHeader() {
        System.out.println("Заголовок: Отчёт о продажах");
    }

    @Override
    protected void createBody() {
        System.out.println("Таблица продаж за текущий месяц");
    }

    @Override
    protected void createFooter() {
        System.out.println("Итого продаж: 1 250 000 рублей");
    }
}

class EmployeeReport extends ReportGenerator {

    @Override
    protected void createHeader() {
        System.out.println("Заголовок: Отчёт о сотрудниках");
    }

    @Override
    protected void createBody() {
        System.out.println("Список сотрудников компании");
    }

    @Override
    protected void createFooter() {
        System.out.println("Всего сотрудников: 42");
    }
}

public class TemplateMethodExample {

    public static void main(String[] args) {

        System.out.println("=== ОТЧЁТ О ПРОДАЖАХ ===");

        ReportGenerator sales =
                new SalesReport();

        sales.generate();

        System.out.println();

        System.out.println("=== ОТЧЁТ О СОТРУДНИКАХ ===");

        ReportGenerator employees =
                new EmployeeReport();

        employees.generate();
    }
}