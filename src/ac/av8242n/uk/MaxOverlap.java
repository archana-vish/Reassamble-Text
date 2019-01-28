package ac.av8242n.uk;

import java.util.*;
import java.util.stream.Collectors;

public class MaxOverlap {

    // Final line
    private String line;
    // Maximum overlap length between words
    private int maxOverlap;


    public void setLine(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public int getMaxOverlap() {
        return maxOverlap;
    }

    public void setMaxOverlap(int maxOverlap) {
        this.maxOverlap = maxOverlap;
    }


    /**
     * Method to find the maximal overlap match and set the maximum overlap and the merged line
     * @param one first text fragment
     * @param two second text fragment
     * @return true if text fragments overlap
     */

    public  boolean isMaximalOverlap(String one, String two) {
        boolean matched = false;
        int maxOverlap = 0;
        for (int i=0; i<one.length(); i++) {
            if(two.regionMatches(false,0,one,i,one.length() - i)) {
                maxOverlap = one.length() - i;
                if ((maxOverlap > getMaxOverlap())) {
                    setMaxOverlap(maxOverlap);
                    setLine(one.substring(0,i).concat(two));
                    matched = true;
                }
                break;
            }
        }
        return matched;
    }

    /**
     * Main method to split lines by the ';' delimiter and then merge them to one
     * @param line input line
     */
    public String mergeLines(String line) {

        ArrayList<String> lines = new ArrayList(Arrays.asList(line.split(";"))
                .stream().sorted().collect(Collectors.toList()));

        boolean matched;

        ListIterator<String> itr;
        int index = 0;
        String one, two;
        int pointer = 1;

        // Finally the collection will have only 1 line
        while (lines.size() > 1) {

            one = lines.get(0);
            setMaxOverlap(0);

            ListIterator<String> innerItr = lines.listIterator(1);
            Set<Integer> removeIndex = new TreeSet<>();

            while (innerItr.hasNext()) {
                two = innerItr.next();
                matched = isMaximalOverlap(one, two) ;
                if (matched) {
                    index = innerItr.nextIndex() - 1;

                    if (one.indexOf(two) > 0 || two.indexOf(one) > 0 || getMaxOverlap() > 1) {
                        removeIndex.add(index);
                    }
                }
            }

            // Now set and remove objects
            lines.set(0,getLine());
            itr = lines.listIterator();
            int ri = 0;

            while(itr.hasNext() && !removeIndex.isEmpty()) {
                int maxToRemove = Collections.max(removeIndex);
                itr.next();
                if(ri == maxToRemove) {
                    itr.remove();
                    break;
                }
                ri++;
            }



            String temp = "";

            // When there is no more match between the first fragment and the next, cycle to the next fragment and so on
            if (removeIndex.isEmpty()) {
                if (pointer >= (lines.size())) {
                    pointer = 1;
                }
                temp = lines.get(0);
                lines.set(0, lines.get(pointer));
                lines.set(pointer++, temp);
            }
        }

        System.out.println("Final String :: " + getLine());
        return getLine();
    }
}
