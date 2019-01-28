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

    public static final String PATH = "/Users/av8242n/Documents/Archana/Development/AlfaSystems/TF2";

    public static String reassemble(String line) {
            String[] lines = line.split(";");
            List<String> listOfLines = Arrays.asList(lines);
            List<String> finalLines = new ArrayList<>();
            Iterator<String> itrLines = listOfLines.iterator();
            String cLine, nLine;
            int index = 0;

            while(itrLines.hasNext()) {
                cLine = itrLines.next();
                index++;
                for (int inner = index; inner < listOfLines.size(); inner++) {
                    nLine = listOfLines.get(inner);
                    System.out.println(cLine + "---> " + nLine);
                    System.out.println(cLine.matches(nLine) + "??" + nLine.regionMatches(5,cLine,0,cLine.length()));

                }

            }
        System.out.println(finalLines);
            return line;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(PATH))) {
            in.lines()
                    .map(Reorder::reassemble)
                    .forEach(System.out::println) ;
        }
    }
}
