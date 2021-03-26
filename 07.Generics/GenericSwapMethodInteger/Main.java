package Generics.GenericSwapMethodInteger;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        BoxSwap<Integer> box = new BoxSwap<>();
        for (int i = 0; i < count; i++) {
            box.add(Integer.valueOf(scan.nextLine()));
        }
        int[] swapCmd = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        box.swap(swapCmd[0], swapCmd[1]);
        box.print();
    }
}
