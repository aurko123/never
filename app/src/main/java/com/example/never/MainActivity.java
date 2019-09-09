package com.example.never;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView info;
    private TextView result;
    private final char ADD = '+';
    private final char SUB = '-';
    private final char MUL = '*';
    private final char DIV = '/';
    private final char EQU = '0';
    private double val1= Double.NaN;
    private double val2;
    private char action;
    DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        databaseReference= FirebaseDatabase.getInstance().getReference("History");

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "0");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = ADD;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = SUB;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = MUL;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = DIV;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                action = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(null);
            }
        });

        //hiii

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(info.getText().length() > 0){
                   CharSequence name = info.getText().toString();
                   info.setText(name.subSequence(0, name.length()-1 ));
               }

               else{
                   val1 = Double.NaN;
                   val2 = Double.NaN;
                   info.setText(null);
                   result.setText(null);
               }
            }
        });
    }

    private void setupUI(){
        one = (Button)findViewById(R.id.bt9);
        two = (Button)findViewById(R.id.bt10);
        three = (Button)findViewById(R.id.bt11);
        four = (Button)findViewById(R.id.bt5);
        five = (Button)findViewById(R.id.bt6);
        six = (Button)findViewById(R.id.bt7);
        seven = (Button)findViewById(R.id.bt1);
        eight = (Button)findViewById(R.id.bt2);
        nine = (Button)findViewById(R.id.bt3);
        add = (Button)findViewById(R.id.bt4);
        sub = (Button)findViewById(R.id.bt8);
        mul = (Button)findViewById(R.id.bt12);
        div = (Button)findViewById(R.id.bt16);
        zero = (Button)findViewById(R.id.bt14);
        info = (TextView)findViewById(R.id.tv2);
        result = (TextView)findViewById(R.id.tv1);
        equal = (Button)findViewById(R.id.bt15);
        clear = (Button)findViewById(R.id.bt13);

    }

    private void compute(){
        if (!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch (action){
                case ADD:
                    val1 = val1 + val2;
                    save(val1);
                    break;
                case SUB:
                    val1 = val1 - val2;
                    save(val1);
                    break;
                case MUL:
                    val1 = val1 * val2;
                    save(val1);
                    break;
                case DIV:
                    val1 = val1 / val2;
                    save(val1);
                    break;
                case EQU:
                    break;
            }
        }

        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
    private void save(double result){
        String key=databaseReference.push().getKey();
        databaseReference.child(key).setValue(result);
        Toast.makeText(getApplicationContext(),"Successfull",Toast.LENGTH_SHORT).show();
    }
}
