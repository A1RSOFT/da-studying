package lesson4.task2;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = Pair.of(1, "hello");
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        Pair<Integer, String> pairWithNull = Pair.of(1, null);

        System.out.println(pair1.equals(pair2));
        System.out.println(pair1.equals(pairWithNull));
    }
}
