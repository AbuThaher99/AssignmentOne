package com.example.assignmentone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity {
    private Spinner spinner;

    private String selectedItem = null;
    private ArrayList<Math> hard = null;
    private ArrayList<Math> easy = null;
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private RadioGroup radioGroup;
    private  CaptionedMathAdapter adapter;
    private RecyclerView recycler ;

    private int i = 1;
    TextView text;
    String Ans = null;
    Button button;
    Button fin;
    Button ch;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        r1 = findViewById(R.id.R1);
        r2 = findViewById(R.id.R2);
        r3 = findViewById(R.id.R3);
        r4 = findViewById(R.id.R4);

        radioGroup = findViewById(R.id.group);
        text = findViewById(R.id.EQtext);
        fin = findViewById(R.id.Finish);
        ch = findViewById(R.id.check);
        selectedItem = getIntent().getStringExtra("selected_item");
        if (selectedItem.equals("Hard")) {

            recycler = findViewById(R.id.pizza_recycler);
            double x[] = new double[Math.hardMath.length];
            double y[] = new double[Math.hardMath.length];
            String operation[] = new String[Math.hardMath.length];
            double optionOne[] = new double[Math.hardMath.length];
            double optionTwo[] = new double[Math.hardMath.length];
            double optionThree[] = new double[Math.hardMath.length];
            double optionFour[] = new double[Math.hardMath.length];
            double answer[] = new double[Math.hardMath.length];
            for(int i = 0 ;i<Math.hardMath.length;i++){
                x[i] = Math.hardMath[i].getX();
                y[i] = Math.hardMath[i].getY();
                operation[i] = Math.hardMath[i].getOperation();
                optionOne[i] = Math.hardMath[i].getOptionOne();
                optionTwo[i] = Math.hardMath[i].getOptionetwo();
                optionThree[i] = Math.hardMath[i].getOptionThree();
                optionFour[i] = Math.hardMath[i].getOptionFour();
                answer[i] = Math.hardMath[i].getAnswer();

            }

            recycler.setLayoutManager(new LinearLayoutManager(this));
            CaptionedMathAdapter adapter = new CaptionedMathAdapter(x,y,operation,optionOne,optionTwo,optionThree,optionFour,answer);
            recycler.setAdapter(adapter);

        } else if (selectedItem.equals("Easy")) {
             recycler = findViewById(R.id.pizza_recycler);
            double x[] = new double[Math.esayMath.length];
            double y[] = new double[Math.esayMath.length];
            String operation[] = new String[Math.esayMath.length];
            double optionOne[] = new double[Math.esayMath.length];
            double optionTwo[] = new double[Math.esayMath.length];
            double optionThree[] = new double[Math.esayMath.length];
            double optionFour[] = new double[Math.esayMath.length];
            double answer[] = new double[Math.esayMath.length];
            for(int i = 0 ;i<Math.esayMath.length;i++){
                x[i] = Math.esayMath[i].getX();
                y[i] = Math.esayMath[i].getY();
                operation[i] = Math.esayMath[i].getOperation();
                optionOne[i] = Math.esayMath[i].getOptionOne();
                optionTwo[i] = Math.esayMath[i].getOptionetwo();
                optionThree[i] = Math.esayMath[i].getOptionThree();
                optionFour[i] = Math.esayMath[i].getOptionFour();
                answer[i] = Math.esayMath[i].getAnswer();

            }

            recycler.setLayoutManager(new LinearLayoutManager(this));
            adapter = new CaptionedMathAdapter(x,y,operation,optionOne,optionTwo,optionThree,optionFour,answer);
            recycler.setAdapter(adapter);
        }



    }







    public void finish(View v) {
        Intent intentw = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intentw);
    }

}