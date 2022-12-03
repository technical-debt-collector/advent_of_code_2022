package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


public class Day2Part2 extends Puzzle {
    public static void main(String[] args) throws IOException {
        var map = Map.of(
                "A X", 3,
                "A Y", 4,
                "A Z", 8,
                "B X", 1,
                "B Y", 5,
                "B Z", 9,
                "C X", 2,
                "C Y", 6,
                "C Z", 7
        );
        int max = Arrays.stream(input("day2.txt").split("\\n")).map(String::trim).mapToInt(map::get).sum();
        System.out.println(max);
    }
}
