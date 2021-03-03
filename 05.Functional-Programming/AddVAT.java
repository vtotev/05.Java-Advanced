package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] prices = Arrays.stream(scan.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        UnaryOperator<Double> withVAT = value -> value * 1.2;
        System.out.println("Prices with VAT:");
        for (double price : prices) {
            price = withVAT.apply(price);
            System.out.printf("%.2f%n", price);
        }
    }
}
