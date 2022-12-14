package puzzle;

import java.io.IOException;

public abstract class Puzzle {

    public static String input(String filename) throws IOException {
        var is = Puzzle.class.getClassLoader().getResourceAsStream(filename);
        return new String(is.readAllBytes());
    }

}
