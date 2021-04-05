package Generics.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputName = scan.nextLine().split("\\s+");
        Tuple<String, String> name = new Tuple<>(String.format("%s %s", inputName[0], inputName[1]), inputName[2]);

        String[] inputBeer = scan.nextLine().split("\\s+");
        Tuple<String, Integer> beer = new Tuple<>(inputBeer[0], Integer.parseInt(inputBeer[1]));

        String[] inputNums = scan.nextLine().split("\\s+");
        Tuple<Integer, Double> numbers = new Tuple<>(Integer.parseInt(inputNums[0]), Double.parseDouble(inputNums[1]));

        System.out.println(name.toString());
        System.out.println(beer.toString());
        System.out.println(numbers.toString());
    }
}
