package ac.av8242n.uk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Reorder {

    public static final String PATH = "/Users/av8242n/Documents/Archana/Development/AlfaSystems/TextFile";

    public static String reassemble(String line) {
            MaxOverlap maxOverlap = new MaxOverlap();
            return maxOverlap.mergeLines(line);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(PATH))) {
            in.lines()
                    .map(Reorder::reassemble)
                    .forEach(System.out::println) ;
        }
    }
}
