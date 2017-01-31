package com.example.lrb13.cipher;

import android.app.Activity;
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



public class MainActivity extends Activity {

    Spinner functionList;
    TextView output;
    int position;
    int i=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.textView);
        functionList = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.split_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        functionList.setAdapter(adapter);
        functionList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        doFunction(0);
                        break;
                    case 1:
                        doFunction(1);
                        break;
                    case 2:
                        doFunction(2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // sometimes you need nothing here
            }
        });
        //position = functionList.getSelectedItemPosition();
        //doFunction(position);


    }
    //@Override
    public void doFunction (int p)
    {
        if(p==0)
        {
            output.setText("You selected Joey's Function");
        }
        else if(p==1)
        {
            output.setText("You selected Chris's Function");
        }
        else if(p==2)
        {
            output.setText("You selected Mate's Function");
        }

    }
}
