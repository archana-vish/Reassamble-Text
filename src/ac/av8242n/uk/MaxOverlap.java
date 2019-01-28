package ac.av8242n.uk;

import java.util.*;
import java.util.stream.Collectors;

public class MaxOverlap {

    private String line;
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



    public  boolean matchAndMerge(String one, String two) {
        boolean matched = false;
        int maxOverlap = 0;
        for (int i=0; i<one.length(); i++) {
            if(two.regionMatches(false,0,one,i,one.length() - i)) {
                maxOverlap = one.length() - i;
                if ((maxOverlap > getMaxOverlap() || i==0)) {
                    System.out.println("Changing maxOverlap from  " + getMaxOverlap() + " to  " + maxOverlap);
                    setMaxOverlap(maxOverlap);
                    System.out.println("Final string " + one.substring(0,i).concat(two));
                    setLine(one.substring(0,i).concat(two));
                    matched = true;
                }

                break;
            }
        }
        return matched;
    }

    public void mergeLines(String line) {
        Arrays.asList(line.split(";"))
                .stream().forEach(System.out::println);

        Comparator<String> compByLength = (first, second) -> first.length() - second.length();

        ArrayList<String> lines = new ArrayList(Arrays.asList(line.split(";"))
                .stream().sorted().collect(Collectors.toList()));

        System.out.println(lines);

        int point = 0;
        boolean matched = false; //maxOverlap.matchAndMerge(one,two)?true:maxOverlap.matchAndMerge(two, one);

        ListIterator<String> itr = lines.listIterator();
        int index = 0;
        String one, two;
        int pointer = 1;

        while (lines.size() > 1) {

            one = lines.get(0);
            itr = lines.listIterator();
            setMaxOverlap(0);

            System.out.println("Line 1 :: " + one);

            ListIterator<String> innerItr = lines.listIterator(1);
            Set<Integer> removeIndex = new TreeSet<>();


            while (innerItr.hasNext()) {
                two = innerItr.next();
                System.out.println("Line 2 :: " + two);
                matched = matchAndMerge(one, two) ; //? true : matchAndMerge(two, one);
                if (matched) {

                    index = innerItr.nextIndex() - 1;

                    if (one.indexOf(two) > 0 || two.indexOf(one) > 0) {
                        removeIndex.add(index);
                        System.out.println("Words matched so index to remove added " + one + "---" + two);
                    } else {

                        System.out.println("Matched at " + index + " line " + getLine());
                        if (getMaxOverlap() > 1) {
                            removeIndex.add(index);
                        }
                    }
                }
            }

            // Now set and remove objects
            System.out.println("Get line :: " + getLine());
            lines.set(0,getLine());
            System.out.println(lines);
            itr = lines.listIterator();
            one = getLine();
            System.out.println("remove index " + removeIndex);
            int ri = 0;



            while(itr.hasNext() && !removeIndex.isEmpty()) {
                int maxToRemove = Collections.max(removeIndex);
                System.out.println("At element " + itr.next());
                if(ri == maxToRemove) {
                    System.out.println("Removing..");
                    itr.remove();
                    //break;
                }
                ri++;
            }



            System.out.println(lines);
            String temp = "";

            if (removeIndex.isEmpty()) {
                if (pointer >= (lines.size())) {
                    pointer = 1;
                    //setLine(lines.get(0));
                }
                temp = lines.get(0);
                lines.set(0, lines.get(pointer));
                lines.set(pointer++, temp);
                System.out.println("Swapped...");
                System.out.println(lines);
            }


            System.out.println("===============");
        }


        System.out.println("Final final final String :: " + getLine());
    }

    public static void main(String[] args) {

        MaxOverlap maxOverlap = new MaxOverlap();


        String line = "m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut labore et dolore magnam aliquam qu;dipisci velit, sed quia non numqua;us modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi tem;pora inc;am al";
//        String line = "all is well;ell that en;t ends well;hat end";
        maxOverlap.mergeLines(line);


    }
}
