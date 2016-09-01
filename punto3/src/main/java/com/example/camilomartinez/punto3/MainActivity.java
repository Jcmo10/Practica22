package com.example.camilomartinez.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ebase,ealtura,eradio,elado;
    RadioGroup egrupo;
    Button ecalcular;
    TextView eresultado;
    double salida;
    String base,altura,radio,lado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ebase = (EditText)findViewById(R.id.eBase);
        ealtura = (EditText)findViewById(R.id.eAltura);
        eradio = (EditText)findViewById(R.id.eRadio);
        elado = (EditText)findViewById(R.id.eLado);
        eresultado = (TextView)findViewById(R.id.eresultado);
        ecalcular = (Button)findViewById(R.id.eCalcular);
        egrupo = (RadioGroup)findViewById(R.id.radioGroup);






        /*ebase.setText(null);
        ealtura.setText(null);
        eradio.setText(null);
        elado.setText(null);*/

        egrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton Rb = (RadioButton)radioGroup.findViewById(i);
                try {
                    switch (Rb.getId()){
                        case R.id.eCuadrado:
                            elado.setEnabled(true);
                            ealtura.setEnabled(false);
                            ebase.setEnabled(false);
                            eradio.setEnabled(false);
                            borrar();
                            break;
                        case R.id.eTraiangulo:
                            elado.setEnabled(false);
                            ealtura.setEnabled(true);
                            ebase.setEnabled(true);
                            eradio.setEnabled(false);
                            borrar();
                            break;
                        case R.id.eRectangulo:
                            elado.setEnabled(false);
                            ealtura.setEnabled(true);
                            ebase.setEnabled(true);
                            eradio.setEnabled(false);
                            borrar();
                            break;
                        case R.id.eCirculo:
                            elado.setEnabled(false);
                            ealtura.setEnabled(false);
                            ebase.setEnabled(false);
                            eradio.setEnabled(true);
                            borrar();
                            break;
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"No hay Datos",Toast.LENGTH_SHORT).show();
                }

            }

        });
        onClickListenerButton();


    }
    public void borrar(){
        ebase.setText("");
        ealtura.setText("");
        eradio.setText("");
        elado.setText("");
    }


    public void onClickListenerButton(){

        ecalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eresultado.setText(String.valueOf(salida));
                int selecid = egrupo.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selecid);
                try {
                    switch (rb.getId()){
                        case R.id.eCuadrado:
                            elado.setEnabled(true);
                            lado = elado.getText().toString();
                            salida = Double.parseDouble(lado)*Double.parseDouble(lado);
                            eresultado.setText(String.valueOf(salida));
                            break;
                        case R.id.eTraiangulo:
                            ealtura.setEnabled(true);
                            ebase.setEnabled(true);
                            altura = ealtura.getText().toString();
                            base = ebase.getText().toString();
                            salida = (Double.parseDouble(base)+Double.parseDouble(altura))/2;
                            eresultado.setText(String.valueOf(salida));
                            break;
                        case R.id.eRectangulo:
                            ealtura.setEnabled(true);
                            ebase.setEnabled(true);
                            altura = ealtura.getText().toString();
                            base = ebase.getText().toString();
                            salida = Double.parseDouble(base) * Double.parseDouble(altura);
                            eresultado.setText(String.valueOf(salida));
                            break;
                        case R.id.eCirculo:
                            eradio.setEnabled(true);
                            radio = eradio.getText().toString();
                            salida = Double.parseDouble(radio) * Double.parseDouble(radio) * Math.PI;
                            eresultado.setText(String.valueOf(salida));
                            break;
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"No hay Datos",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
