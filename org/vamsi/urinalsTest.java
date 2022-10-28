package org.vamsi;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @Test
    void counterTest()
    {
        Assertion.assertequals(1, urinals.counter("100101"));
        system.out.println("VamsiKrishna Test One executed");
    }

    @Test
    void readFileTest()
    {
        File file= new File("filepath");
        String[] a=
                {"10001", "1001", "00000", "0000", "01000", "011"};
        String expected=Arrays.toString(a);
        String actual=Arrays.deepToString(urinals.readFile());
        Assertions.assertEquals(expected,actual);
        system.out.println("VamsiKrishna Test two executed");
    }

    @Test
    void writeFileTest()
    {
        int[] Result = {1,2,3,4,5,6,7,8,9,10};
        Assertions.assertEquals(true,urinals.writeFile(Result));
        system.out.println("VamsiKrishna Test three executed");
    }
}