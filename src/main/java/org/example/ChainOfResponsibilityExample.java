package org.example;

abstract class DocumentChecker {

    private DocumentChecker next;

    public void setNext(DocumentChecker next) {
        this.next = next;
    }

    public void check(String document) {

        if (isResponsible(document)) {
            process(document);
        } else if (next != null) {
            next.check(document);
        } else {
            System.out.println(
                    "Документ никто не смог обработать: "
                            + document
            );
        }
    }

    protected abstract boolean isResponsible(
            String document
    );

    protected abstract void process(
            String document
    );
}

class PassportChecker extends DocumentChecker {

    @Override
    protected boolean isResponsible(String document) {
        return document.equals("passport");
    }

    @Override
    protected void process(String document) {
        System.out.println(
                "Паспорт проверен"
        );
    }
}

class ContractChecker extends DocumentChecker {

    @Override
    protected boolean isResponsible(String document) {
        return document.equals("contract");
    }

    @Override
    protected void process(String document) {
        System.out.println(
                "Договор проверен юристом"
        );
    }
}

class InvoiceChecker extends DocumentChecker {

    @Override
    protected boolean isResponsible(String document) {
        return document.equals("invoice");
    }

    @Override
    protected void process(String document) {
        System.out.println(
                "Счёт проверен бухгалтером"
        );
    }
}

public class ChainOfResponsibilityExample {

    public static void main(String[] args) {

        DocumentChecker passport =
                new PassportChecker();

        DocumentChecker contract =
                new ContractChecker();

        DocumentChecker invoice =
                new InvoiceChecker();

        passport.setNext(contract);
        contract.setNext(invoice);

        passport.check("passport");
        passport.check("contract");
        passport.check("invoice");
        passport.check("photo");
    }
}