package org.example;

interface Expression {

    int interpret();
}

class NumberExpression
        implements Expression {

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

class AddExpression
        implements Expression {

    private final Expression left;
    private final Expression right;

    public AddExpression(
            Expression left,
            Expression right
    ) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret()
                + right.interpret();
    }
}

class SubtractExpression
        implements Expression {

    private final Expression left;
    private final Expression right;

    public SubtractExpression(
            Expression left,
            Expression right
    ) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret()
                - right.interpret();
    }
}

public class InterpreterExample {

    public static void main(String[] args) {

        Expression five =
                new NumberExpression(5);

        Expression three =
                new NumberExpression(3);

        Expression ten =
                new NumberExpression(10);

        Expression four =
                new NumberExpression(4);

        Expression addition =
                new AddExpression(
                        five,
                        three
                );

        Expression subtraction =
                new SubtractExpression(
                        ten,
                        four
                );

        System.out.println(
                "5 + 3 = " +
                        addition.interpret()
        );

        System.out.println(
                "10 - 4 = " +
                        subtraction.interpret()
        );
    }
}