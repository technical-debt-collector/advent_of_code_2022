package puzzle;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Day6Part1 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var i = 0;
        int dupes = 0;

        var lhs = new LinkedList<>();
        for (char c : input("day6.txt").toCharArray()) {
            if (++i > 4 && lhs.contains(lhs.removeFirst()))
                dupes--;
            if (lhs.contains(c))
                dupes++;
            lhs.add(c);

            if (lhs.size() == 4 && dupes == 0)
                break;
        }
        System.out.println(i);
    }
}
