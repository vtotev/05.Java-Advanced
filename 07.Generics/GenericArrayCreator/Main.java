package Generics.GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] ints = ArrayCreator.create(13, 13);
        String[] strings = ArrayCreator.create(13, "IntelliJ");
        String[] strings2 = ArrayCreator.create(String.class, 13, "Java");
    }
}
