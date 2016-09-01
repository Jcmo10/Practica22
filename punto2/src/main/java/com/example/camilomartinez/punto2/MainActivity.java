package com.example.camilomartinez.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    RadioGroup grupo;
    TextView resultado;
    String num1,num2;
    double operacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1 = (EditText)findViewById(R.id.eNumero1);
        numero2 = (EditText)findViewById(R.id.eNumero2);
        grupo = (RadioGroup)findViewById(R.id.eGroup);
        resultado = (TextView)findViewById(R.id.eResultado);
    }
    public void onRadioButtonClicked(View view) {
        num1 = numero1.getText().toString();
        num2 = numero2.getText().toString();
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked

        try {

            switch (view.getId()) {
                case R.id.eSuma:
                    if (checked)
                        operacion = Double.parseDouble(num1) + Double.parseDouble(num2);
                    break;
                case R.id.eResta:
                    if (checked)
                        operacion = Double.parseDouble(num1) - Double.parseDouble(num2);
                    break;
                case R.id.eMultiplicacion:
                    if (checked)
                        operacion = Double.parseDouble(num1) * Double.parseDouble(num2);
                    break;
                case R.id.eDivision:
                    if (checked)
                        operacion = Double.parseDouble(num1) / Double.parseDouble(num2);
                    break;
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        resultado.setText(String.valueOf(operacion));
    }


}