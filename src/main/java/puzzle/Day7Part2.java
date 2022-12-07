package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;


public class Day7Part2 extends Puzzle {

    public static void main(String[] args) throws IOException {
        var pattern = Pattern.compile("(\\$\\s.+[^$]*)");
        var filesize = Pattern.compile("\\d+");
        var ops = pattern.matcher(input("day7.txt"));
        var map = new HashMap<String, Integer>();
        map.put("root", 0);
        var sb = new StringBuilder("root");
        while (ops.find()) {
            var group = ops.group().trim();
            if (group.contains("cd ..")) {
                sb.delete(sb.lastIndexOf("/"), sb.length());
            } else if (group.matches("\\$ cd [^/]*")) {
                sb.append("/").append(group.substring(5));
            } else if (group.contains("ls")) {
                var sizes = filesize.matcher(group);
                int i = 0;
                while (sizes.find())
                    i += Integer.parseInt(sizes.group());
                var path = new StringBuilder();
                var wd = Arrays.stream(sb.toString().split("/")).toList();
                for (String s : wd) {
                    map.put(path.append(s).toString(), i + map.getOrDefault(path.toString(), 0));
                    path.append("/");
                }
            }
        }
        System.out.println("root: " + map.get("root"));
        map.values().stream().filter(v -> v >= 30000000-(70000000-map.get("root"))).min(Integer::compareTo).ifPresent(System.out::println);
    }
}
