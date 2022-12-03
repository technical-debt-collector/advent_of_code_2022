package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


public class Day2Part1 extends Puzzle {
    public static void main(String[] args) throws IOException {
        var map = Map.of(
                "A X", 4,
                "A Y", 8,
                "A Z", 3,
                "B X", 1,
                "B Y", 5,
                "B Z", 9,
                "C X", 7,
                "C Y", 2,
                "C Z", 6
        );
        int max = Arrays.stream(input("day2.txt").split("\\n")).map(String::trim).mapToInt(map::get).sum();
        System.out.println(max);
    }
}
