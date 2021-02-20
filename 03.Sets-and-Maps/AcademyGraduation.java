package SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String name = scan.nextLine();
            List<Double> grades = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());
            students.put(name, grades);
        }
        students.entrySet().stream().forEach(st -> {
            Double avg = 0.0;
            for (Double grade : st.getValue()) {
                avg += grade;
            }
            avg /= st.getValue().size();
            System.out.printf("%s is graduated with %s%n", st.getKey(), avg);
        });
    }
}
