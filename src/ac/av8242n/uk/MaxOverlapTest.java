package ac.av8242n.uk;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxOverlapTest {

    MaxOverlap maxOverlap = new MaxOverlap();

    @Test
    public void testStringOne() {
        maxOverlap.mergeLines("all is well;ell that en;t ends well;hat end");
        assertTrue(maxOverlap.getLine().equals("all is well that ends well"));
    }

    @Test
    public void testStringTwo() {
        maxOverlap.mergeLines("O draconia;conian devil! Oh la;h lame sa;saint!");
        assertTrue(maxOverlap.getLine().equals("O draconian devil! Oh lame saint!"));
    }

    @Test
    public void testStringThree() {
        maxOverlap.mergeLines("O draconia;conian devil! Oh la;saint!;h lame sa;");
        assertTrue(maxOverlap.getLine().equals("O draconian devil! Oh lame saint!"));
    }

    @Test
    public void testStringFour() {
        maxOverlap.mergeLines("m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci velit;olore magnam aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem ipsum qu;iquam quaerat vol;psum quia dolor sit amet, consectetur, a;ia dolor sit amet, conse;squam est, qui do;Neque porro quisquam est, qu;aerat voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem ipsum quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut labore et dolore magnam aliquam qu;dipisci velit, sed quia non numqua;us modi tempora incid;Neque porro quisquam est, qui dolorem i;uam eius modi tem;pora inc;am al");
        assertTrue(maxOverlap.getLine().equals("Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem."));
    }

}