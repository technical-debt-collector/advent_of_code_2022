package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;


public class Day1Part2 extends Puzzle {
    public static void main(String[] args) throws IOException {
        var max = Arrays
                .stream(input("day1.txt").split("\\n\\s"))
                .map(str -> Arrays
                        .stream(str.split("\n"))
                        .mapToInt(s -> s.isEmpty() ? 0 : Integer.parseInt(s.trim())))
                .map(IntStream::sum)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(Integer::sum);
        System.out.println(max.get());
    }
}
