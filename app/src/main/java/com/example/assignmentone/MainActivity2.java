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
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("hardMath", "");
            Math[] obj = gson.fromJson(str, Math[].class);

            recycler = findViewById(R.id.pizza_recycler);
            double x[] = new double[obj.length];
            double y[] = new double[obj.length];
            String operation[] = new String[obj.length];
            double optionOne[] = new double[obj.length];
            double optionTwo[] = new double[obj.length];
            double optionThree[] = new double[obj.length];
            double optionFour[] = new double[obj.length];
            double answer[] = new double[obj.length];
            for(int i = 0 ;i<obj.length;i++){
                x[i] = obj[i].getX();
                y[i] = obj[i].getY();
                operation[i] = obj[i].getOperation();
                optionOne[i] = obj[i].getOptionOne();
                optionTwo[i] = obj[i].getOptionetwo();
                optionThree[i] = obj[i].getOptionThree();
                optionFour[i] = obj[i].getOptionFour();
                answer[i] = obj[i].getAnswer();

            }

            recycler.setLayoutManager(new LinearLayoutManager(this));
            CaptionedMathAdapter adapter = new CaptionedMathAdapter(x,y,operation,optionOne,optionTwo,optionThree,optionFour,answer);
            recycler.setAdapter(adapter);

        } else if (selectedItem.equals("Easy")) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson = new Gson();
            String str = prefs.getString("easyMath", "");
            Math[] obj = gson.fromJson(str, Math[].class);
             recycler = findViewById(R.id.pizza_recycler);
            double x[] = new double[obj.length];
            double y[] = new double[obj.length];
            String operation[] = new String[obj.length];
            double optionOne[] = new double[obj.length];
            double optionTwo[] = new double[obj.length];
            double optionThree[] = new double[obj.length];
            double optionFour[] = new double[obj.length];
            double answer[] = new double[obj.length];
            for(int i = 0 ;i<obj.length;i++){
                x[i] = obj[i].getX();
                y[i] = obj[i].getY();
                operation[i] = obj[i].getOperation();
                optionOne[i] = obj[i].getOptionOne();
                optionTwo[i] = obj[i].getOptionetwo();
                optionThree[i] = obj[i].getOptionThree();
                optionFour[i] = obj[i].getOptionFour();
                answer[i] = obj[i].getAnswer();

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