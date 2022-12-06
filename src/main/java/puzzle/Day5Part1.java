package puzzle;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Day5Part1 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var input = input("day5.txt").split("\\n\\r");
        var craneShit = input[0].split("\\n");
        var instructions = input[1].trim();
        var map = new HashMap<Integer, Stack<Character>>();
        var index = 0;
        for (char c : craneShit[craneShit.length - 1].toCharArray()) {
            var numericValue = Character.getNumericValue(c);
            if (numericValue > -1) {
                map.put(numericValue, new Stack<>());
                for (int i = craneShit.length - 2; i >= 0; i--) {
                    var line = craneShit[i].toCharArray();
                    if (line.length >= index && line[index] != ' ') {
                        map.get(numericValue).push(line[index]);
                    }
                }
            }
            index++;
        }


        String[] split = instructions.split("\\n");
        for (int j = 1; j < split.length; j++) {
            String instruction = split[j];
            var pattern = Pattern.compile("\\d+");
            var matcher = pattern.matcher(instruction);

            matcher.find();
            System.out.println(matcher.results().toArray().length);
            for (int i = 0; i < Integer.parseInt(matcher.group(0)); i++) {
                var item = map.get(Integer.parseInt(matcher.group(1))).pop();
                map.get(Integer.parseInt(matcher.group(2))).push(item);
            }
        }
        System.out.println(map.values().stream().map(Vector::lastElement).collect(Collectors.toList()));
    }

}
