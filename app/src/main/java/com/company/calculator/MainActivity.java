package com.company.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btnAC, btnDEL, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDivide, btnMul, btnAdd,
                    btnSub, btn0, btnDot, btnEqual;

    private TextView textViewHistory, textViewResult;
    String number = null, status = null;
    double first=0, last=0;
    boolean operator = false, dot = true, AC = true, equal = false;
    String history, current;
    DecimalFormat myFormat = new DecimalFormat("########.###########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAC = findViewById(R.id.btnAC);
        btnDEL = findViewById(R.id.btnDEL);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnDivide = findViewById(R.id.btnDivide);
        btnMul = findViewById(R.id.btnMul);
        btnEqual = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);
        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                current = textViewResult.getText().toString();
                textViewHistory.setText(history+current+"+");

                if(operator){
                    if(status == "subtract"){
                        subtract();
                    }
                    else if(status == "multiply"){
                        multiply();
                    }
                    else if(status == "divide"){
                        divide();
                    }
                    else{
                        add();
                    }
                }
                operator = false;
                number = null;
                status = "add";
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                current = textViewResult.getText().toString();
                textViewHistory.setText(history+current+"-");

                if(operator){
                    if(status == "add"){
                        add();
                    }
                    else if(status == "multiply"){
                        multiply();
                    }
                    else if(status == "divide"){
                        divide();
                    }
                    else{
                        subtract();
                    }
                }
                operator = false;
                number = null;
                status = "subtract";
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                current = textViewResult.getText().toString();
                textViewHistory.setText(history+current+"*");

                if(operator){
                    if(status == "add"){
                        add();
                    }
                    else if(status == "subtract"){
                        subtract();
                    }
                    else if(status == "divide"){
                        divide();
                    }
                    else{
                        multiply();
                    }
                }
                operator = false;
                number = null;
                status = "multiply";
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                history = textViewHistory.getText().toString();
                current = textViewResult.getText().toString();
                textViewHistory.setText(history+current+"/");

                if(operator){
                    if(status == "add"){
                        add();
                    }
                    else if(status == "multiply"){
                        multiply();
                    }
                    else if(status == "subtract"){
                        subtract();
                    }
                    else{
                        divide();
                    }
                }
                operator = false;
                number = null;
                status = "divide";
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator){
                    if(status == "add"){
                        add();
                    }
                    else if(status == "subtract"){
                        subtract();
                    }
                    else if(status == "multiply"){
                        multiply();
                    }
                    else if(status == "divide"){
                        divide();
                    }
                    else{
                        first = Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operator = false;
                equal = true;
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = null;
                status = null;
                first=0;
                last=0;
                dot = true;
                AC = true;
                textViewResult.setText("0");
                textViewHistory.setText("");
            }
        });

        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(AC){
                    textViewResult.setText("0");
                }
                else{
                    number = number.substring(0, number.length()-1);
                    if(number.length()==0){
                        btnDEL.setClickable(false);
                    }
                    else if(number.contains(".")){
                        dot = false;
                    }
                    else{
                        dot = true;
                    }

                    textViewResult.setText(number.toString());
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dot) {
                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }
                textViewResult.setText(number.toString());
                dot = false;
            }
        });
    }

    public void numberClick(String view){
        if(number == null){
            number = view;
        }
        else if(equal){
            first = 0;
            last = 0;
            number = view;
        }
        else{
            number = number + view;
        }
        textViewResult.setText(number);
        operator = true;
        AC = false;
        btnDEL.setClickable(true);
        equal = false;
    }

    public void add(){
        last = Double.parseDouble(textViewResult.getText().toString());
        first = first+last;
        textViewResult.setText(myFormat.format(first));
        dot = true;
    }
    public void subtract(){
        if(first == 0){
            first = Double.parseDouble(textViewResult.getText().toString());
        }
        else {
            last = Double.parseDouble(textViewResult.getText().toString());
        }
        first = first-last;
        textViewResult.setText(myFormat.format(first));
        dot = true;
    }
    public void multiply(){
        if(first == 0) {
            first = 1;
            last = Double.parseDouble(textViewResult.getText().toString());
            first = first*last;
        }
        else{
            last = Double.parseDouble(textViewResult.getText().toString());
            first = first*last;
        }
        textViewResult.setText(myFormat.format(first));
        dot = true;
    }
    public void divide(){
        if(first == 0){
            last = Double.parseDouble(textViewResult.getText().toString());
            first = last/1;
        }
        else{
            last = Double.parseDouble(textViewResult.getText().toString());
            first = first/last;
        }
        textViewResult.setText(myFormat.format(first));
        dot = true;
    }
}