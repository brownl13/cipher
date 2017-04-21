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
       // ma.p = 0;
        ma.strn = "2";
       // ma.nGraph();
        String expected = "AB = 1 at positions 0\nBC = 1 at positions 1\n";
        assertEquals(ma.nGraph(), expected);
    }
    @Test
    public void testnGraph2()
    {
        ma.input = "abc";
        //ma.p = 0;
        ma.strn = "a";
        String expected = "n needs to be an int";
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
    public void testcaesar1() {
        ma.input = "asdfgh";
        ma.strn = "3";
        String expected = "DVGIJ K";
        assertEquals(ma.caesar(true), expected);
    }
    @Test
    public void testcaesar2(){
        ma.input = "ofaf nx fbjxtrj";
        ma.strn = "5";
        String expected = "javai sawes ome";
        assertEquals(ma.caesar(false), expected);

    }
    @Test
    public void testcaesar3(){
        ma.input = "ofaf nx fbjxtrj";
        ma.strn = "";
        String expected = "Please enter shift amount";
        assertEquals(ma.caesar(false), expected);

    }
    @Test
    public void testmultiplicative()
    {
        ma.input = "xyz";
        ma.p2 = 1;
        String expected = "XYZ";
        assertEquals(ma.multiplicative(true), expected);
        ma.p2 = 3;
        expected = "TWZ";
        assertEquals(ma.multiplicative(true), expected);
        ma.input = "Jacob is a tester!";
        ma.p2 = 19;
        expected = "HSEYL OWSPQ WPQD";
        assertEquals(ma.multiplicative(true).replaceAll(" ", ""), expected.replaceAll(" ", ""));
        ma.input = "J@cob is a tester!";
        expected = "HEYLO WSPQW PQD";
        assertEquals(ma.multiplicative(true).replaceAll(" ", ""), expected.replaceAll(" ", ""));
        ma.input = "";
        ma.p2 =1 ;
        expected = "";
        assertEquals(ma.multiplicative(true), expected);



    }
    @Test
    public void testDecipherMultiplicative()
    {
        ma.input = "cfi";
        ma.p3 = 9;
        String expected = "abc";
        assertEquals(ma.multiplicative(false), expected);
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
    @Test
        public void testaffine()
       {
           ma.input = "ahhj";
           ma.strn = "4";
           ma.p2 = 3;
           String expected = "GBBH";
           assertEquals(ma.affine(Boolean.TRUE), expected);
       }
    @Test
    public void testaffine2()
    {
        ma.input = "ahhj";
        ma.strn = "";
        ma.p2 = 3;
        String expected = "Please enter additive shift";
        assertEquals(ma.affine(Boolean.TRUE), expected);
    }

    @Test
    public void testVigenereDecipher()
    {
        ma.input = "ypw utgd uq cbnl ng oo oy dglmrhppe"; //Logan please put input your input string
        ma.strn = "abc";
        String expected = "youus edtoc allme onmyc ellph one"; //give expected string from this returned from this function

        assertEquals(ma.vigenere(Boolean.FALSE), expected);
    }

    @Test
    public void testvigenere() {
        ma.input = "Northern Kentucky University was in the NCAA tournament"; //Logan please put input your input string
        ma.strn = "norse";
        String expected = "ACILL RFECI AHLUO LIEAZ RFJAX LKRKM AHYWR PORLS HFESQ RBK"; //give expected string from this returned from this function

        assertEquals(ma.vigenere(Boolean.TRUE), expected);

        ma.input = "Computer Science is in the college of informatics";
        ma.strn = "";
        expected = "Please enter a keyword";

        assertEquals(ma.vigenere(Boolean.TRUE), expected);

        ma.input = "";
        ma.strn = "Java";
        expected = "Please enter text to be enciphered or deciphered";
        assertEquals(ma.vigenere(Boolean.TRUE), expected);

    }
        @Test
        public void testvigenere2()
        {
            ma.input = "Java was originally developed by James Gosling";
            ma.strn = "python";
            String expected = "YYOHK NHMKP UVCYE SMQTT XSCCT BUFXN BCLNC FAGGN ";
            assertEquals(ma.vigenere(Boolean.TRUE), expected);
        }
        @Test
        public void testvigenere3() {
        ma.input = "Android Studio is the official IDE for the Android platform";
        ma.strn = "IDE";
        String expected = "IQHZR MLVXC GMWLW BKIWI JQFMI OMLHJ WUXPH EVGVW LHXOE BISZP ";
        assertEquals(ma.vigenere(Boolean.TRUE), expected);
        }
        @Test
        public void testvigenere4() {
        ma.input = "Android Studio is the official IDE for the Android platform";
        ma.strn = "9";
        String expected = "Please enter a keyword";
        assertEquals(ma.vigenere(Boolean.TRUE), expected);
        }
        @Test
        public void testvigenere5() {
        ma.input = "Android Studio is the official IDE for the Android platform";
        ma.strn = "@";
        String expected = "Please enter a keyword";
        assertEquals(ma.vigenere(Boolean.TRUE), expected);
    }






  /*  @Test
    public void testRSAKeyGeneration()
    {
        //this function does not have input
        String expected = ""; //give expected string you want this function to return

        assertEquals(ma.RSAKeyGeneration(), expected);
    }*/

    @Test
    public void testpresent()
    {
        ma.input = "1111 1111 1111 1111 1111"; //input string value
        ma.strn = "0000 0000 0000 0000"; //value for n in string
        String expected = "Round 1 Key: 0010 1111 1111 1110 " + "\n"
                + "Round 2 Key: 0001 0101 1111 1101 " +"\n"
                + "Round 3 Key: 1111 0010 1011 1100 " + "\n"
                + "Result: 1111 1101 1111 0010 "; //give expected string you want this function return with your input

        assertEquals(ma.present(), expected);
    }

    @Test
    public void testkeywordCipherEncipher() {
        ma.input = "java is the programming language we used"; //put value for input
        ma.strn = "java"; //set value for n in string
        ma.strin3 = "d"; //set value for in3 in string

        String expected = "exrxdopcalnkbnxhhdibgxibqxbasaqoaj"; //value for expected

        assertEquals(ma.keywordCipher(Boolean.TRUE), expected);

    }
    @Test
    public void testKeywordCipherDecipher(){

        ma.input = "gztzf qrebn pmdpz kkfld izlds zdbub sqbv"; //put value for input
        ma.strn = "java"; //set value for n in string
        ma.strin3 = "d"; //set value for in3 in string

        String expected = ""; //value for expected

        assertEquals(ma.keywordCipher(Boolean.FALSE), expected);


    }

    @Test
    public void testtranspositionEncipher()
    {
        ma.input = "this is just a test"; //set input value
        ma.strn = "joey"; //set value for n in string
        String expected = "IJATT ISEHS TSSUT X"; //expected value returned from this function

        assertEquals(ma.transposition(Boolean.TRUE), expected);
    }

    @Test
    public void testtranspositionDecipher()
    {
        ma.input = "IJATT ISEHS TSSUT X"; //set input value
        ma.strn = "joey"; //set value for n in string
        String expected = "thisi sjust atest x"; //expected value returned from this function

        assertEquals(ma.transposition(Boolean.FALSE), expected);
    }

    @Test
    public void testAffineDecipher()
    {
        ma.input = "zvn nhro kv lfmm pr vs pz lrmm yavsr";
        ma.strn = "3";
        ma.p3 = 9;
        String expected = "youus edtoc allme onmyc ellph one";
        assertEquals(ma.affine(Boolean.FALSE), expected);
    }

    @Test
    public void testAffineDecipher2()
    {
        ma.input = "e";
        ma.strn = "2";
        ma.p3 = 9;
        String expected = "a";
        assertEquals(ma.affine(Boolean.FALSE), expected);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
