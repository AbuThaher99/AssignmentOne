package com.example.assignmentone;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedMathAdapter
        extends RecyclerView.Adapter<CaptionedMathAdapter.ViewHolder>{
    private double x[];
    private double y[];
    private String operation[];
    private double optionOne[];
    private double optionTwo[];
    private double optionThree[];
    private double optionFour[];
    private double answer[];

    public CaptionedMathAdapter(double x[], double y[], String operation[], double optionOne[], double optionTwo[], double optionThree[], double optionFour[], double answer[]){
        this.x = x;
        this.y = y;
        this.operation = operation;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.answer = answer;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,  int position) {

        CardView cardView = holder.cardView;
        TextView txt = (TextView)cardView.findViewById(R.id.EQtext);
        txt.setText(x[position] + " " + operation[position] + " " + y[position] + " = ?");
        RadioGroup radioGroup = (RadioGroup)cardView.findViewById(R.id.group);
        radioGroup.check(-1);
        TextView r1 = (TextView)cardView.findViewById(R.id.R1);
        r1.setText("" + optionOne[position]);
        TextView r2 = (TextView)cardView.findViewById(R.id.R2);
        r2.setText("" + optionTwo[position]);
        TextView r3 = (TextView)cardView.findViewById(R.id.R3);
        r3.setText("" + optionThree[position]);
        TextView r4 = (TextView)cardView.findViewById(R.id.R4);
        r4.setText("" + optionFour[position]);
        Button btn = (Button)cardView.findViewById(R.id.check);
        btn.setTag(position);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int)v.getTag();

                RadioGroup radioGroup = (RadioGroup)cardView.findViewById(R.id.group);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton)cardView.findViewById(selectedId);

                if(radioButton.getText().toString().equals("" + answer[position])){
                    AlertDialog.Builder builder = new AlertDialog.Builder(cardView.getContext());
                    builder.setTitle("Correct");
                    builder.setMessage("You got it right!");


                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    });
                    builder.show();
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(cardView.getContext());
                    builder.setTitle("Incorrect");
                    builder.setMessage("You got it wrong!");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    });
                    builder.show();
                }
            }
        });






    }

    @Override
    public int getItemCount() {
        return x.length;
    }

    public double getAnswer(int position) {
        return answer[position];
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
