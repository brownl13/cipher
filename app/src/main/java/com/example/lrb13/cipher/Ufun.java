package com.example.lrb13.cipher;

import java.util.*;
import java.lang.*;


public class Ufun{
//1-26
public final ArrayList<Integer> uZcon(String c){
        c = c.toLowerCase(); //to lower
        c = c.replaceAll(" ","");
        ArrayList n = new ArrayList<Integer>();
        char[] cArray = c.toCharArray(); // to char array

        //loop through char array and convert letters into #
        for(int i = 0; i < cArray.length; i++){
        //conversion equation and add to arraylist
        n.add((int)cArray[i] - (int)'a' + 1);
        }
        return n;


        }
//0-25
public final ArrayList<Integer> uOcon(String c){
        c = c.toLowerCase(); //to lower
        c = c.replaceAll(" ","");
        ArrayList n = new ArrayList<Integer>();
        char[] cArray = c.toCharArray(); // to char array

        //loop through char array and convert letters into #
        for(int i = 0; i < cArray.length; i++){
        //conversion equation and add to arraylist
        n.add((int)cArray[i] - (int)'a');
        }
        return n;
        }


        }
