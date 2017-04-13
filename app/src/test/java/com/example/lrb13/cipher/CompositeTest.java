package com.example.lrb13.cipher;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

public class CompositeTest extends TestCase {

    MainActivity ma = new MainActivity();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    @Test
    public void testnGraph()
    {
        ma.input = "abc";
        ma.p = 0;
        ma.strn = "2";
        ma.nGraph();
        String expected = "AB = 1 at positions 0\nBC = 1 at positions 1\n";
        assertEquals(ma.nGraph(), expected);
    }
    @Test
    public void testrunTheAlphabet()
    {
        ma.input = "abcd";
        String expected = "abcd\nbcde\ncdef\ndefg\nefgh\nfghi\nghij\nhijk\nijkl\njklm\nklmn\nlmno\n"+
                "mnop\nnopq\nopqr\npqrs\nqrst\nrstu\nstuv\ntuvw\nuvwx\nvwxy\nwxyz\nxyza\nyzab\nzabc\n";//todo yzab
        assertEquals(ma.runTheAlphabet(), expected);
        ma.input = "how ya doin?";
        expected = "how ya doin \n" +
                "ipx zb epjo \n" +
                "jqy ac fqkp \n" +
                "krz bd grlq \n" +
                "lsa ce hsmr \n" +
                "mtb df itns \n" +
                "nuc eg juot \n" +
                "ovd fh kvpu \n" +
                "pwe gi lwqv \n" +
                "qxf hj mxrw \n" +
                "ryg ik nysx \n" +
                "szh jl ozty \n" +
                "tai km pauz \n" +
                "ubj ln qbva \n" +
                "vck mo rcwb \n" +
                "wdl np sdxc \n" +
                "xem oq teyd \n" +
                "yfn pr ufze \n" +
                "zgo qs vgaf \n" +
                "ahp rt whbg \n" +
                "biq su xich \n" +
                "cjr tv yjdi \n" +
                "dks uw zkej \n" +
                "elt vx alfk \n" +
                "fmu wy bmgl \n" +
                "gnv xz cnhm \n";
        assertEquals(ma.runTheAlphabet(), expected);
    }
    @Test
    public void testindexOfCoincidence()
    {
        ma.input = "";
        String expected = "NA";
        assertEquals(ma.indexOfCoincidence(), expected);
        ma.input = "as";
        String expected1 = "0.0";
        assertEquals(ma.indexOfCoincidence(), expected1);
        ma.input = "this is a test";
        String expected2 = "0.12727272727272726";
        assertEquals(ma.indexOfCoincidence(), expected2);
        ma.input = "hubal432oo i k12ang123aroo";
        String expected3 = "0.075";
        assertEquals(ma.indexOfCoincidence(), expected3);
        ma.input = "welcome to th!!!!e machine";
        String expected4 = "0.06432748538011696";
        assertEquals(ma.indexOfCoincidence(), expected4);

    }
    @Test
    public void testcaesar()
    {
        ma.input = "asdf";
        ma.strn = "3";
        String expected = "dvgi";
        assertEquals(ma.caesar(true), expected);
    }
    @Test
    public void testmultiplicative()
    {
        ma.input = "xyz";
        ma.p2 = 1;
        String expected = "xyz";
        assertEquals(ma.multiplicative(true), expected);
        ma.p2 = 3;
        expected = "twz";
        assertEquals(ma.multiplicative(true), expected);
        ma.input = "Jacob is a tester!";
        ma.p2 = 19;
        expected = "hseyl owspq wpqd";
        assertEquals(ma.multiplicative(true).replaceAll(" ", ""), expected.replaceAll(" ", ""));
        ma.input = "J@cob is a tester!";
        expected = "heylo wspqw pqd";
        assertEquals(ma.multiplicative(true).replaceAll(" ", ""), expected.replaceAll(" ", ""));
        ma.input = "";
        ma.p2 =1 ;
        expected = "";
        assertEquals(ma.multiplicative(true), expected);



    }
    @Test
    public void testfrequency()
    {
        ma.input = "new test";
        String expected = "A = 0 = \n" +
                "B = 0 = \n" +
                "C = 0 = \n" +
                "D = 0 = \n" +
                "E = 2 = II\n" +
                "F = 0 = \n" +
                "G = 0 = \n" +
                "H = 0 = \n" +
                "I = 0 = \n" +
                "J = 0 = \n" +
                "K = 0 = \n" +
                "L = 0 = \n" +
                "M = 0 = \n" +
                "N = 1 = I\n" +
                "O = 0 = \n" +
                "P = 0 = \n" +
                "Q = 0 = \n" +
                "R = 0 = \n" +
                "S = 1 = I\n" +
                "T = 2 = II\n" +
                "U = 0 = \n" +
                "V = 0 = \n" +
                "W = 1 = I\n" +
                "X = 0 = \n" +
                "Y = 0 = \n" +
                "Z = 0 = \n" +
                "\n\n\n"
                + "Expected Frequencies of English\n"
                +"\n\n"
                + "A = 1 = I\n" +
                "B = 0 = \n" +
                "C = 0 = \n" +
                "D = 0 = \n" +
                "E = 1 = I\n" +
                "F = 0 = \n" +
                "G = 0 = \n" +
                "H = 0 = \n" +
                "I = 0 = \n" +
                "J = 0 = \n" +
                "K = 0 = \n" +
                "L = 0 = \n" +
                "M = 0 = \n" +
                "N = 0 = \n" +
                "O = 1 = I\n" +
                "P = 0 = \n" +
                "Q = 0 = \n" +
                "R = 0 = \n" +
                "S = 0 = \n" +
                "T = 1 = I\n" +
                "U = 0 = \n" +
                "V = 0 = \n" +
                "W = 0 = \n" +
                "X = 0 = \n" +
                "Y = 0 = \n" +
                "Z = 0 = \n";

        assertEquals(ma.frequency(), expected);
        ma.input = "234The Wr0ng Text3#$@ Doe???";
        expected = "A = 0 = \n" +
                "B = 0 = \n" +
                "C = 0 = \n" +
                "D = 1 = I\n" +
                "E = 3 = III\n" +
                "F = 0 = \n" +
                "G = 1 = I\n" +
                "H = 1 = I\n" +
                "I = 0 = \n" +
                "J = 0 = \n" +
                "K = 0 = \n" +
                "L = 0 = \n" +
                "M = 0 = \n" +
                "N = 1 = I\n" +
                "O = 1 = I\n" +
                "P = 0 = \n" +
                "Q = 0 = \n" +
                "R = 1 = I\n" +
                "S = 0 = \n" +
                "T = 3 = III\n" +
                "U = 0 = \n" +
                "V = 0 = \n" +
                "W = 1 = I\n" +
                "X = 1 = I\n" +
                "Y = 0 = \n" +
                "Z = 0 = \n" +
                "\n\n\n"
                + "Expected Frequencies of English\n"
                +"\n\n"
                + "A = 1 = I\n" +
                "B = 0 = \n" +
                "C = 0 = \n" +
                "D = 1 = I\n" +
                "E = 2 = II\n" +
                "F = 0 = \n" +
                "G = 0 = \n" +
                "H = 1 = I\n" +
                "I = 1 = I\n" +
                "J = 0 = \n" +
                "K = 0 = \n" +
                "L = 1 = I\n" +
                "M = 0 = \n" +
                "N = 1 = I\n" +
                "O = 1 = I\n" +
                "P = 0 = \n" +
                "Q = 0 = \n" +
                "R = 1 = I\n" +
                "S = 1 = I\n" +
                "T = 1 = I\n" +
                "U = 0 = \n" +
                "V = 0 = \n" +
                "W = 0 = \n" +
                "X = 0 = \n" +
                "Y = 0 = \n" +
                "Z = 0 = \n";
        assertEquals(ma.frequency(), expected);
    }
    //    @Test
    //    public void testaffine()
    //    {
    //        ma.input = "ahhj";
    //        String expected = "elln";
    //        assertEquals(ma.affine(), expected);
    //    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
