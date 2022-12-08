package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;


public class Day8Part1 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var input = input("day8.txt").split("\n");
        var length = input.length;
        var set = new HashSet<String>();
        var arr = new int[length][length];
        for (int x = 0; x < length; x++)
            arr[x] = input[x].chars().limit(length).toArray();
        for (int x = 0; x < length; x++) {
            var horizontal = arr[x];
            var vertical = new int[length];
            for (int y = 0; y < length; y++) {
                vertical[y] = arr[y][x];
            }

            for (int i = 0; i < length; i++) {
                if (isVisible(i, vertical)) {
                    set.add(x + "-" + i);
                }
                if (isVisible(i, horizontal)) {
                    set.add(i + "-" + x);
                }
            }
        }
        System.out.println(set.size());
    }

    public static boolean isVisible(int indexOfTree, int[] arr) {
        if (indexOfTree == 0) return true;
        if (Arrays.stream(Arrays.copyOfRange(arr, 0, indexOfTree)).noneMatch(x -> x >= arr[indexOfTree]))
            return true;
        return Arrays.stream(Arrays.copyOfRange(arr, indexOfTree + 1, arr.length)).noneMatch(x -> x >= arr[indexOfTree]);
    }

}