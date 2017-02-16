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
import java.util.ArrayList;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends Activity {

    Spinner functionList;
    TextView output;
    String nv;
    EditText in;
    EditText n;
    int size;
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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.split_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        functionList.setAdapter(adapter);
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
        //position = functionList.getSelectedItemPosition();
        //doFunction(position);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void RunOnClick(View v) {
        result = "";
        input = in.getText().toString();
        length = input.length();
        if (p == 0) {

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
        } else if (p == 1) {
            output.setText("You selected Chris's Function");
        } else if (p == 2) {
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
        else if (p==3) {
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
        else if (p==4)
        {
            size = Integer.parseInt(n.getText().toString());
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
