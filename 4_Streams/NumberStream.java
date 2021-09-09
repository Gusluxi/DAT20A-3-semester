import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStream {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(5, 4, 3, 2, 1, 3, 6, 5, 2, 1, 9, 0, 1, 0);

    int sum = numbers.stream().mapToInt(number -> number).sum();

    int sumParallelized = numbers.parallelStream().mapToInt(number -> number).sum();

    double averageTemperature = numbers.stream().mapToInt(number -> number).average().getAsDouble();

    System.out.println(sum + " " +sumParallelized + " " + averageTemperature);

    List<Integer> squareNumbers =
        numbers.stream().map(nomNom -> nomNom * nomNom).collect(Collectors.toList());

    System.out.println(squareNumbers);

    List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());

    List<Integer> oddNumbers = numbers.stream().filter(number -> number % 2 == 1).collect(Collectors.toList());

    List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());

    System.out.println(evenNumbers + " " + oddNumbers + " " + uniqueNumbers);

    IntSummaryStatistics summary = numbers
        .parallelStream()
        .mapToInt(number -> number)
        .summaryStatistics();

    System.out.println(summary.getMin());
    System.out.println(summary.getMax());
    System.out.println(summary.getAverage());
    System.out.println(summary.getCount());
    System.out.println(summary.getSum());
  }
}
