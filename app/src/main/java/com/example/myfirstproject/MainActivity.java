package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    char act;
    double num1;
    double num2;
    double ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);

    }

    //Get number & show it on screen
    public void numberFunction(View view) {

        if( view instanceof Button) {
            Button button = (Button) view;

            String str = button.getText().toString();

            result.append(str);
            }
    }

    public void actionClick(View view){
        if(view instanceof  Button) {
            String str1 = result.getText().toString();
            num1 = Integer.parseInt(str1);
            Button button = (Button) view;
            act = button.getText().charAt(0);
            result.setText(null);
        }
    }



    public void clearFunction(View view) {
        if( view instanceof  Button) {
            result.setText("");
        }
    }

    public void calculateFunction (View view) {
        if( view instanceof  Button) {
            String str2 = result.getText().toString();
             num2 = Integer.parseInt(str2);
             ans = doMath(num1,num2,act);

             if(!Double.isFinite(ans)){
                 result.setText("Error divided by zero - enter c");
             }
             else {
                 result.setText(ans +"");
             }
        }
    }

    public double doMath (double first, double second, char op){

        switch (op) {
            case '+':
                return first + second;
            case '-':
                return first - second;

            case 'X':
                return first * second;

            case '/':
                if( second != 0) {
                    return (first / second);
                } else {
                    return 1.0/0.0;
                }

            default:
                return 0;
        }
    }
}
