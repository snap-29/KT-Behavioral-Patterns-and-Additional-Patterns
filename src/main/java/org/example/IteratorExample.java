package org.example;

interface StudentIterator {

    boolean hasNext();

    String next();
}

class StudentGroup {

    private final String[] students = {
            "Алексей",
            "Мария",
            "Дмитрий",
            "Ольга",
            "Иван"
    };

    public StudentIterator iterator() {
        return new GroupIterator();
    }

    private class GroupIterator
            implements StudentIterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < students.length;
        }

        @Override
        public String next() {

            if (!hasNext()) {
                throw new IllegalStateException(
                        "Элементы закончились"
                );
            }

            return students[index++];
        }
    }
}

public class IteratorExample {

    public static void main(String[] args) {

        StudentGroup group =
                new StudentGroup();

        StudentIterator iterator =
                group.iterator();

        while (iterator.hasNext()) {

            System.out.println(
                    "Студент: " +
                            iterator.next()
            );
        }
    }
}