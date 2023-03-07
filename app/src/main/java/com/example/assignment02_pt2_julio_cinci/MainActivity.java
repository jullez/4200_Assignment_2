package com.example.assignment02_pt2_julio_cinci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView counter;
    Button clicker;
    Button resetter;//widget definitions

    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context=getApplicationContext();//grabs activity context
        counter=findViewById(R.id.textView);
        clicker=findViewById(R.id.clickIt);
        resetter=findViewById(R.id.resetBtn);//Widget assignments
        resetter.setVisibility(View.GONE);//makes reset button initially invisible
        counter.setText(Integer.toString(n));//Display initial counter text (0)

        //creates the alert dialog, sets its title and message, as well as the confirm button (text is "Reset")
        AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this).setTitle("RESET").setMessage("Really reset the counter?").setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                n=0;
                counter.setText(Integer.toString(n));//confirms the reset, resets the counter valuie and updates the textview
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {//creates the cancel button listener
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //does nothing, just as it should
            }
        });
        alert.create();
        clicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){//click event for the "CLICK" button
                n++;//increments n
                counter.setText(Integer.toString(n));//updates textview with value of n
                resetter.setVisibility(View.VISIBLE);//makes reset button visible
            }

        });
        resetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//click event for "Reset" button
               alert.show();

                }
            });
        }
    }