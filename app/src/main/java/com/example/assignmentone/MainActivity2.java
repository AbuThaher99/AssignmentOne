package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

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
        MathEQ mathEQ = new MathEQ();
        r1 = findViewById(R.id.R1);
        r2 = findViewById(R.id.R2);
        r3 = findViewById(R.id.R3);
        r4 = findViewById(R.id.R4);
        button = findViewById(R.id.Next);
        radioGroup = findViewById(R.id.group);
        text = findViewById(R.id.EQtext);
        fin = findViewById(R.id.Finish);
        ch = findViewById(R.id.check);
        selectedItem = getIntent().getStringExtra("selected_item");
        if (selectedItem.equals("Hard")) {
            hard = mathEQ.getHardEQ();
            text.setText(hard.get(0).getX() + " " + hard.get(0).getOperation() + " " + hard.get(0).getY()+" = ");
            r1.setText("" + hard.get(0).getOptionOne());
            r2.setText("" + hard.get(0).getOptionetwo());
            r3.setText("" + hard.get(0).getOptionThree());
            r4.setText("" + hard.get(0).getOptionFour());
            Ans = String.valueOf(hard.get(0).getAnswer());
        } else if (selectedItem.equals("Easy")) {
            easy = mathEQ.getEasyEQ();
            text.setText(easy.get(0).getX() + " " + easy.get(0).getOperation() + " " + easy.get(0).getY()+" = ");
            r1.setText("" + easy.get(0).getOptionOne());
            r2.setText("" + easy.get(0).getOptionetwo());
            r3.setText("" + easy.get(0).getOptionThree());
            r4.setText("" + easy.get(0).getOptionFour());
            Ans = String.valueOf(easy.get(0).getAnswer());
        }
    }
    public void check(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            String selectedText = radioButton.getText().toString();
            if (selectedText.equals(Ans)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Message")
                        .setMessage("The Answer is True ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // do something when the OK button is clicked
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                button.setVisibility(View.VISIBLE);
            } else {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Message")
                        .setMessage("The Answer is Wrong try again ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // do something when the OK button is clicked
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }
    }

    public void next(View v) {
        button.setVisibility(View.INVISIBLE);
        int flag = 0;
        try {
            if (selectedItem.equals("Hard")) {
                radioGroup.clearCheck();
                text.setText(hard.get(i).getX() + " " + hard.get(i).getOperation() + " " + hard.get(i).getY()+" = ");
                r1.setText("" + hard.get(i).getOptionOne());
                r2.setText("" + hard.get(i).getOptionetwo());
                r3.setText("" + hard.get(i).getOptionThree());
                r4.setText("" + hard.get(i).getOptionFour());
                Ans = String.valueOf(hard.get(i).getAnswer());
                if (hard.size() == i + 1) {
                    flag = 1;
                    i++;
                }
                System.out.println("AbuThaher " + i + "\n" + "Mohammad " + hard.size());

                if (i == hard.size() && flag == 1) {

                    button.setVisibility(View.GONE);
                    fin.setVisibility(View.VISIBLE);
                    ch.setVisibility(View.INVISIBLE);

                }
                i++;
            } else if (selectedItem.equals("Easy")) {
                radioGroup.clearCheck();
                text.setText(easy.get(i).getX() + " " + easy.get(i).getOperation() + " " + easy.get(i).getY()+" = ");
                r1.setText("" + easy.get(i).getOptionOne());
                r2.setText("" + easy.get(i).getOptionetwo());
                r3.setText("" + easy.get(i).getOptionThree());
                r4.setText("" + easy.get(i).getOptionFour());
                Ans = String.valueOf(easy.get(i).getAnswer());

                System.out.println("AbuThaher " + i + "\n" + "Mohammad " + easy.size());
                if (easy.size() == i + 1) {
                    flag = 1;
                    i++;
                }
                if (i == easy.size() && flag == 1) {

                    button.setVisibility(View.GONE);
                    fin.setVisibility(View.VISIBLE);
                    ch.setVisibility(View.INVISIBLE);
                }
                i++;

            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void finish(View v) {
        if (selectedItem.equals("Hard")) {

            Ans = String.valueOf(hard.get(i-2).getAnswer());

        }else{

            Ans = String.valueOf(easy.get(i-2).getAnswer());
        }
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId != -1) {

            RadioButton radioButton = findViewById(selectedId);
            String selectedText = radioButton.getText().toString();

            if (!selectedText.equals(Ans)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Message")
                        .setMessage("The Answer is Wrong try again  ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // do something when the OK button is clicked
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();


            } else {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Message")
                        .setMessage("Now you Finish Your Math Problem ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intentw = new Intent(MainActivity2.this, MainActivity.class);
                                startActivity(intentw);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

                i = 1;

            }
        }


    }

}