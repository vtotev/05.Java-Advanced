package Generics.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale(100, 20);
        System.out.println(scale.getHeavier());
    }
}
