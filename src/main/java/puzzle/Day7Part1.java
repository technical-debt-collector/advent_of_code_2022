package puzzle;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;


public class Day7Part1 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var pattern = Pattern.compile("(\\$\\s.+[^$]*)");
        var filesize = Pattern.compile("\\d+");
        var ops = pattern.matcher(input("day7.txt"));
        var map = new HashMap<String, Integer>();
        var sb = new StringBuilder("/");
        ops.find(); //We're adding the first / outside the loop
        while (ops.find()) {
            var group = ops.group().trim();
            if (group.contains("cd .."))
                sb.delete(sb.lastIndexOf("/", sb.length() - 2) + 1, sb.length());
            else if (group.contains("cd"))
                sb.append(group.substring(5)).append("/");
            else if (group.contains("ls")) {
                var sizes = filesize.matcher(group);
                int i = 0;
                while (sizes.find())
                    i += Integer.parseInt(sizes.group());
                var path = new StringBuilder();
                for (String s : sb.toString().split("/"))
                    map.put(path.append(s).append("/").toString(), i + map.getOrDefault(path.toString(), 0));
            }
        }
        map.values().stream().filter(v -> v < 100000).reduce(Integer::sum).ifPresent(System.out::println);
    }
}
