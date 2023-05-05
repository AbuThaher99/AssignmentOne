package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView tr;
private Spinner sp;
private Button bt;
    String selectedItem = null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrayOfStrings = {"Welcome to my Math application","This app for grade Four Student","to help them learn Math Problem"};

        StringBuilder sb = new StringBuilder();

        for (String s : arrayOfStrings) {
            sb.append(s).append("\n");
        }

        String text = sb.toString();
        tr=findViewById(R.id.intro);
        tr.setText(text);
        bt=findViewById(R.id.button);



        sp=findViewById(R.id.spinner);
        String [] datalist={"Select an option","Hard","Easy"};

        ArrayAdapter<String> ad = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,datalist);

        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle the selected item here
                 selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Selected item: " + selectedItem, Toast.LENGTH_SHORT).show();
                if(selectedItem.equals("Hard")|| selectedItem.equals("Easy")) {
                    bt.setVisibility(View.VISIBLE);
                }else{
                    bt.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    public void OpenActivityTwo(View v){
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("selected_item", selectedItem);
        startActivity(intent);


    }

}