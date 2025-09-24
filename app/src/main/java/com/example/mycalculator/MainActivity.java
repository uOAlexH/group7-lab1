package com.example.mycalculator;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btn_plus, btn_minus, btn_times, btn_divide, btn_equal, btn_clear, btn_dot;
    TextView text_display;

    // This is to evaluate the math expression

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // numbers
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);

        // operations
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_times = (Button) findViewById(R.id.btn_times);
        btn_divide = (Button) findViewById(R.id.btn_divide);

        // clear, equal, dot
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_dot = (Button) findViewById(R.id.btn_dot);

        text_display = (TextView) findViewById(R.id.textview_input_display);

        setClickListeners();
    }

    private void setClickListeners() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_times.setOnClickListener(this);
        btn_divide.setOnClickListener(this);

        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                addSymbol("1");
                break;
            case R.id.btn2:
                addSymbol("2");
                break;
            case R.id.btn3:
                addSymbol("3");
                break;
            case R.id.btn4:
                addSymbol("4");
                break;
            case R.id.btn5:
                addSymbol("5");
                break;
            case R.id.btn6:
                addSymbol("6");
                break;
            case R.id.btn7:
                addSymbol("7");
                break;
            case R.id.btn8:
                addSymbol("8");
                break;
            case R.id.btn9:
                addSymbol("9");
                break;
            case R.id.btn0:
                addSymbol("0");
                break;
            case R.id.btn_plus:
                addSymbol("+");
                break;
            case R.id.btn_minus:
                addSymbol("-");
                break;
            case R.id.btn_times:
                addSymbol("*");
                break;
            case R.id.btn_divide:
                addSymbol("/");
                break;
            case R.id.btn_equal:
                String result = null;
                try {
                    result = evaluate(text_display.getText().toString());
                    text_display.setText(result);
                } catch (Exception e) {
                    text_display.setText("Error");
                }
                break;
            case R.id.btn_clear:
                clear_display();
                break;
            case R.id.btn_dot:
                addSymbol(".");
        }
    }

    private String evaluate(String expression) throws Exception {
        String result = evaluate(expression);
        BigDecimal decimal = new BigDecimal(result);
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

    private void addSymbol(String symbol) {
        text_display.setText(text_display.getText() + symbol);
    }

    private void clear_display() {
        text_display.setText("");
    }
}
