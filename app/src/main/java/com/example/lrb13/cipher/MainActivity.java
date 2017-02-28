package com.example.lrb13.cipher;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Spinner;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends Activity {

    Spinner functionList;
    Spinner oddNumberList;
    TextView output;
    String nv;
    EditText in;
    EditText n;
    int size;
    String caesarIndex;
    int p2;
    int position;
    int i = 0;
    String input;
    String result;
    int length;
    int p;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.textView);
        n = (EditText) findViewById(R.id.nValue);
        in = (EditText) findViewById(R.id.inputCipher);

        functionList = (Spinner) findViewById(R.id.spinner);
        oddNumberList = (Spinner) findViewById(R.id.oddNumbers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.split_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.odd_numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        functionList.setAdapter(adapter);
        oddNumberList.setAdapter(adapter2);
        functionList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                p = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });

        oddNumberList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int[] d = {1,3,5,7,9,11,15,17,19,21,23,25};
                p2 = d[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void RunOnClick(View v) {
        result = "";
        input = in.getText().toString();
        length = input.length();
        if (p == 0) { //ngraph

            nGraph();

        } else if (p == 1) {//run the alphabet
            runTheAlphabet();
        }
        else if (p==2) { //index of coincidence
            indexOfCoincidence();

        }
        else if (p==3)
        { //caesar
            caesar();
        }
        else if (p==4)
        { //frequency
            frequency();


        }
        else if (p==5)
        { //multiplicative
            multiplicative();
        }

        else if (p==6)
        {
           affine();
        }
    }

    private void nGraph() {
        size = Integer.parseInt(n.getText().toString());

        if(size<1){ //size is the result of text field i need to create (n)
            size=1;
        }//end if

        input =input.replaceAll(" ","");
        input=input.toUpperCase();
        input = input.replaceAll("[^A-Za-z]+","");
        if(size<=input.length()){
            ArrayList<String> array = new ArrayList<String>();
            for(int i=0; i<input.length()-size+1;i++){
                String letters = input.substring(i,i+size);
                array.add(i,letters);
            }//end for loop

            ArrayList<String> listed = new ArrayList<String>();

            for(int j=0;j<array.size();j++){
                String l=array.get(j);
                if(listed.contains(l)==false){
                    listed.add(l);
                    if(array.lastIndexOf(l)==j){
                        result = result + l + " = 1 at positions " + j + "\n";
                    }//end if

                    else{
                        ArrayList<Integer> position = new ArrayList<Integer>();
                        int count =0;
                        for(int k=0;k<array.size();k++){
                            if(array.get(k).equals(l)){
                                count++;
                                position.add(k);
                            }//end if
                        }//end for
                        result = result + l + " = " + count + " at positions " + position + "\n";
                    }//end else
                }//end if

            }
            //end for loop
        }//end if
        output.setText(result);
    }

    private void runTheAlphabet() {
        input = input.toLowerCase();
        for (int j = 0; j <= 25; j++) {
            for (int i = 0; i < input.length(); i++) {
                int charInt = (int)input.charAt(i);
                if ((charInt >= 97 && charInt <= 122)) {
                    if ((charInt + j) > 122) {
                        int tempIndex = charInt + j - 123;
                        result = result + ((char)(97 + tempIndex));
                    }
                    else
                        result = result + ((char)(charInt + j));
                    }
                else {
                    result = result + (' ');
                }
            }
            result = result + "\n";
            }
        output.setText(result);
    }

    private void indexOfCoincidence() {
        //create array to store count in a=0,b=1...
        int array[]=new int[26];

        //take string and convert to lowercase and remove spaces
        input=input.replaceAll(" ","");
        input=input.toLowerCase();
        input=input.replaceAll("[^A-Za-z]+","");
        if(input.length()<=1){
            output.setText("NA");
        }//end if

        else{

            //look through each letter in string and update count in the correct spot
            for(int i=0;i<input.length();i++){
                char letter=input.charAt(i);
                int position= letter-'a';
                array[position]=array[position]+1;
            }//end for loop

            //loop through and get the numerator value
            int numerator=0;
            for(int i=0;i<array.length;i++){
                numerator=numerator+(array[i]*(array[i]-1));
            }//end for loop

            //create denominator value
            int denominator=input.length()*(input.length()-1);

            //convert integers to doubles and get Index
            double num=(double) numerator;
            double den=(double) denominator;
            double index = num/den;
            output.setText("" + index);
        }//end else
    }

    private void caesar() {
        caesarIndex = n.getText().toString();
        size = getIndex(caesarIndex);
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            int charInt = (int)input.charAt(i);
            if ((charInt >= 97 && charInt <= 122)) {
                if ((charInt + size) > 122) {
                    int tempIndex = charInt + size - 123;
                    result = result + ((char)(97 + tempIndex));
                }
                else
                    result = result + ((char)(charInt + size));
            }
            else {
                result = result + " ";
            }
        }
        output.setText(result);
    }

    private void frequency() {
        //remove spaces and special characters from string
        input=input.replaceAll(" ","");
        input=input.toLowerCase();
        input=input.replaceAll("[^A-Za-z]+","");

        int array[]=new int[26];
        //look through each letter in string and update count in the correct spot
        //index 0 in array is a and index 25 is z
        for(int i=0;i<input.length();i++){
            char letter=input.charAt(i);
            int position= letter-'a';
            array[position]=array[position]+1;
        }//end for loop

        String result="";
        //loop through array and put the results into a single string
        for(int i=0;i<26;i++){

            String l=String.valueOf((char)(65+i));

            String I="";
            for(int j=0;j<array[i];j++){
                I=I.concat("I");
            }//end for
            result=result + l + " = " + array[i] + " = " + I + "\n";
        }//end for
        output.setText(result);
    }

    private void multiplicative() {
        int value = p2;

        input=input.replaceAll(" ","");
        input=input.toLowerCase();
        input=input.replaceAll("[^A-Za-z]+","");

        for (int i = 0; i < input.length(); i++) {
            int charInt = (int)input.charAt(i);
            if ((charInt >= 97 && charInt <= 122)) {
                charInt = charInt - 96;
                charInt = charInt * value;
                charInt = charInt % 26;
                if (charInt == 0)
                    charInt = 122;
                else
                    charInt += 96;
                result = result + ((char)charInt);
            }
            else {
                result = result + (' ');
            }
        }
        output.setText(result);
    }

    public void affine()
    {

        input = input.toLowerCase();
        result = multiplicative2(input, p2);
        result = caesar2(result, length);
        output.setText(result);
    }

    public static String caesar2(String input, int index) {
        StringBuilder s2 = new StringBuilder();
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            int charInt = (int)input.charAt(i);
            if ((charInt >= 97 && charInt <= 122)) {
                if ((charInt + index) > 122) {
                    int tempIndex = charInt + index - 123;
                    s2.append((char)(97 + tempIndex));
                }
                else
                    s2.append((char)(charInt + index));
            }
            else {
                s2.append(' ');
            }
        }
        return s2.toString();
    }

    public String multiplicative2(String input, int index) {
        StringBuilder result2 = new StringBuilder();
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            int charInt = (int)input.charAt(i);
            if ((charInt >= 97 && charInt <= 122)) {
                charInt -= 96;
                charInt *= index;
                charInt %= 26;
                if (charInt == 0)
                    charInt = 122;
                else
                    charInt += 96;
                result2.append((char)charInt);
            }
            else {
                result2.append(' ');
                			}
        }
        return result2.toString();
    }

    public static int getIndex(String input) {
        if (isInteger(input)) {
            int index = Integer.parseInt(input);
            if (index < 0)
                return -1;
            else if (index >= 0 && index <= 25)
                return index;
            else
                return (index % 26);
        }
        else {
            if (input.length() == 1) {
                int charInt = (int)input.charAt(0);
                if (charInt >= 65 && charInt <= 90)
                    return (charInt - 65);
                else if (charInt >= 97 && charInt <= 122)
                    return (charInt - 97);
                else
                    return -1;
            }
            else
                return -1;
        }
    }

    private static boolean isInteger(String str) {
        return str.matches("^-?\\d+$");
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.lrb13.cipher/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.lrb13.cipher/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
