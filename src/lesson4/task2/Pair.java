package lesson4.task2;

import java.util.Objects;

public class Pair<T1, T2> {
    private final T1 firstObj;
    private final T2 secondObj;

    private Pair(T1 firstObj, T2 secondObj) {
        this.firstObj = firstObj;
        this.secondObj = secondObj;
    }

    public T1 getFirstObj() {
        return firstObj;
    }

    public T2 getSecondObj() {
        return secondObj;
    }

    public static <T1, T2> Pair<T1, T2> of(T1 firstObj, T2 secondObj) {
        return new Pair<>(firstObj, secondObj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.hashCode() != this.hashCode()) return false;

        try {
            return o instanceof Pair<?, ?> &&
                    ((Pair<?, ?>) o).firstObj.equals(firstObj) &&
                    ((Pair<?, ?>) o).secondObj.equals(secondObj);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstObj, secondObj);
    }
}

