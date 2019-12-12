package com.example.nextcalcul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText num1;
    EditText num2;

    Button plus;
    Button minus;
    Button times;
    Button divided;

    TextView res;

    String oper = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);

        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        times = (Button)findViewById(R.id.times);
        divided = (Button)findViewById(R.id.divided);

        res = (TextView)findViewById(R.id.res);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        times.setOnClickListener(this);
        divided.setOnClickListener(this);

    }
    @Override
    public void onClick (View v){
        float number1 = 0;
        float number2;
        float result = 0;

        number1 = Float.parseFloat(num1.getText().toString());
        number2 = Float.parseFloat(num2.getText().toString());

        switch (v.getId()){
            case R.id.plus:
                oper = "+";
                result = number1 + number2;
                break;
            case R.id.minus:
                oper = "-";
                result = number1 - number2;
                break;
            case  R.id.times:
                oper = "*";
                result= number1 * number2;
                break;
            case R.id.divided:
                oper = "/";
                result = number1 / number2;
                break;

        }
        if (number2 == 0){
            Toast toast = Toast.makeText(this, "division by zero", Toast.LENGTH_SHORT);
            toast.show();
            res.setText("Error");
        }else {
            res.setText(number1 + "" + oper + "" + number2 + "=" + result);
        }

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        menu.add (0, MENU_RESET_ID, 0, "Reset");
        menu.add (0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case MENU_RESET_ID:
                num1.setText("");
                num2.setText("");
                res.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
