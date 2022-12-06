package puzzle;

import java.io.IOException;
import java.util.LinkedList;


public class Day6Part2 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var i = 0;
        int dupes = 0;
        var lhs = new LinkedList<>();
        for (char c : input("day6.txt").toCharArray()) {
            if (++i > 14 && lhs.contains(lhs.removeFirst()))
                dupes--;
            if (lhs.contains(c))
                dupes++;
            lhs.add(c);

            if (lhs.size() == 14 && dupes == 0)
                break;
        }
        System.out.println(i);
    }
}
