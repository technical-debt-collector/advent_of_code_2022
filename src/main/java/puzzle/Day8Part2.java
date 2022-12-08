package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day8Part2 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var input = input("day8.txt").split("\n");
        var length = input.length;
        var max = 0;
        Integer[][] arr = new Integer[length][length];
        for (int x = 0; x < length; x++)
            arr[x] = input[x].chars().limit(length).boxed().toArray(Integer[]::new);
        for (int x = 0; x < length; x++) {
            var vertical = new Integer[length];
            for (int y = 0; y < length; y++) {
                for (int y2 = 0; y2 < vertical.length; y2++) vertical[y2] = arr[y2][y];
                var result = (calculateAxis(y, arr[x]) * calculateAxis(x, vertical));
                if (max < result) max = result;
            }
        }
        System.out.println(max);
    }

    static Integer calculateAxis(Integer index, Integer[] axis) {
        var height = axis[index];
        List<Integer> forward = Arrays.asList(axis);
        var start = lookAtTrees(forward, height, index + 1);

        var backward = Arrays.asList(Arrays.copyOf(axis, axis.length));
        Collections.reverse(backward);
        var end = lookAtTrees(backward, height, axis.length - index);

        return start * end;
    }

    static int lookAtTrees(List<Integer> forest, int treeHeight, int skip) {
        int visibility = 0;
        for (int i : forest.stream().skip(skip).toList()) {
            if (treeHeight > i)
                visibility++;
            else if (treeHeight == i) {
                visibility++;
                break;
            }
        }
        return visibility;
    }

}