package puzzle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;


public class Day3Part1 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var backpacks = input("day3.txt").split("\\n");
        var sum = 0;

        for (String backpack : backpacks) {
            var second = backpack.substring(backpack.length() / 2).chars().boxed().collect(Collectors.toCollection(HashSet::new));
            var first = backpack
                    .substring(0, backpack.length() / 2).chars()
                    .distinct()
                    .boxed()
                    .collect(Collectors.filtering(second::contains, Collectors.summingInt(i -> i > 96 ? i - 96 : i - 65 + 27)));
            sum += first;
        }
        System.out.println(sum);
    }
}
