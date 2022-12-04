package puzzle;

import java.io.IOException;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Day3Part2 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var backpacks = input("day3.txt").split("\\n");
        var sum = 0;

        for (int i = 0; i < backpacks.length; i++) {
            var first = backpacks[i].trim().chars().boxed().collect(Collectors.toCollection(HashSet::new));
            var second = backpacks[++i].trim().chars().boxed().collect(Collectors.toCollection(HashSet::new));
            var third = backpacks[++i].trim().chars().boxed().collect(Collectors.toCollection(HashSet::new));
            first.retainAll(second);
            first.retainAll(third);
            sum += first.stream().map(integer -> integer > 96 ? integer - 96 : integer - 65 + 27).reduce(Integer::sum).orElse(0);
        }
        System.out.println(sum);
    }
}
