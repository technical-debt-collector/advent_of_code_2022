package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;


public class Day1Part1 extends Puzzle {
    public static void main(String[] args) throws IOException {
        var max = Arrays
                .stream(input("day1.txt").split("\\n\\s"))
                .map(str -> Arrays
                        .stream(str.split("\n"))
                        .mapToInt(s -> s.isEmpty() ? 0 : Integer.parseInt(s.trim())))
                .map(IntStream::sum)
                .max(Integer::compareTo);
        System.out.println(max.get());
    }
}
