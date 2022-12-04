package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Day4Part1 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var pairs = input("day4.txt").split("\\n");
        var sum = 0;

        for (String pair : pairs) {
            var arr = pair.split("\\D");
            var start = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
            var end = Integer.parseInt(arr[1]) - Integer.parseInt(arr[3]);
            if ((start >= 0 && end <= 0) || (start <= 0 && end >= 0))
                sum++;
        }
        System.out.println(sum);
    }
}
