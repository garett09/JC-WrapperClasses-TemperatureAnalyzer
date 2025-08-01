package org.example;

import java.util.Scanner;

public class TemperatureAnalyzer {

    static double readTemperature(Scanner input, String day){
        System.out.print("Enter " + day+ " High Temperature (e.g., 28.5): ");
        while (!input.hasNextDouble()) {
            System.out.printf("   '%s' is not a number. Please try again.%n%n", input.next());
            System.out.print("Enter " + day + " High Temperature (e.g., 28.5): ");
        }
        double value = input.nextDouble();
        input.nextLine();
        return value;
    }

    static public void main (String[] temp) {
        try (Scanner input = new Scanner(System.in)) {
            double day1 = readTemperature(input, "Day 1");
            double day2 = readTemperature(input, "Day 2");
            double day3 = readTemperature(input, "Day 3");

            Double d1 = Double.valueOf(day1);
            Double d2 = Double.valueOf(day2);
            Double d3 = Double.valueOf(day3);

            System.out.println("\n--- Temperature Analysis ---\n");

            System.out.println("Parsed Day 1 Temp (primitive double): " + d1);
            System.out.println("Parsed Day 2 Temp (primitive double): " + d2 + "\n");


            int compareDays = Double.compare(day1, day2);
            if (compareDays < 0) {
                System.out.printf("Day 1 (%.1f°C) was cooler than Day 2 (%.1f°C).%n", d1, d2);
            } else if (compareDays > 0) {
                System.out.printf("Day 1 (%.1f°C) was warmer than Day 2 (%.1f°C).%n", d1, d2);
            } else {
                System.out.printf("Day 1 and Day 2 were the same temperature: %.1f°C.%n", d1);
            }

            System.out.println();

            float day1F = d1.floatValue();
            int   day2I = d2.intValue();
            System.out.printf("Extracted Day 1 Temp (primitive float from Double wrapper): %.1f%n", day1F);
            System.out.printf("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): %d%n", day2I);

            System.out.println();

            double max = Math.max(day1, Math.max(day2, day3));
            System.out.printf("The highest temperature recorded was: %.1f°C%n", max);


        }

    }
}
