package BasicAlgorithms.RecursiveFactorial;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        System.out.println(factorial(num));
    }

    private static long factorial(int num) {
        if (num == 1) {
            return num;
        }
        return num *= factorial(num-1);
    }
}
