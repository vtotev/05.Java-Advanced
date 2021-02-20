package SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            if (!students.containsKey(input[0])) {
                students.put(input[0], new ArrayList<>());
            }
            List<Double> scores = students.get(input[0]);
            scores.add(Double.parseDouble(input[1]));
            students.put(input[0], scores);
        }
        students.entrySet().stream().forEach(o -> {
            System.out.print(o.getKey()+" -> ");
            o.getValue().forEach(g -> System.out.printf("%.2f ", g));
            double avg = 0.0;
            for (double d: o.getValue()) {
                avg += d;
            }
            avg /= o.getValue().size();
            System.out.printf("(avg: %.2f)%n", avg);
        });
    }
}
