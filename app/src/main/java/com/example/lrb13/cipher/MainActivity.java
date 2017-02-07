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
            //size = Integer.parseInt(nv);
            //size = 2;
            if(size<1){ //size is the result of text field i need to create (n)
                size=1;
            }//end if

            input =input.replaceAll(" ","");
            input=input.toUpperCase();
            input = input.replaceAll("[A-Za-z]+","");
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
            output.setText("You selected Mate's Function");
        }
        else if (p==3)
            output.setText("Joey 2");
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
