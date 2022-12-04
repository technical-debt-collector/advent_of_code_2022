package puzzle;

import java.io.IOException;


public class Day4Part2 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var pairs = input("day4.txt").split("\\n");
        var sum = 0;

        for (String pair : pairs) {
            var arr = pair.split("\\D");
            var one = Integer.parseInt(arr[0]);
            var two = Integer.parseInt(arr[1]);
            var three = Integer.parseInt(arr[2]);
            var four = Integer.parseInt(arr[3]);
            if (one < three) {
                if (two >= three)
                    sum++;
            } else {
                if (four >= one)
                    sum++;
            }
        }
        System.out.println(sum);
    }
}
