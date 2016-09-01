package com.example.camilomartinez.punto4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText eloggin,epass,econpass,eemail,efecha;
    RadioGroup grupo;
    Button eset,eaceptar;
    TextView salida;
    CheckBox Bask,Foot,Voley,Cycli;
    int año,mes,dia;
    private static final int Tipo = 0;
    private static DatePickerDialog.OnDateSetListener selector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eloggin = (EditText)findViewById(R.id.eLoggin);
        epass = (EditText)findViewById(R.id.ePass);
        econpass = (EditText)findViewById(R.id.ePasscom);
        eemail = (EditText)findViewById(R.id.eCorreo);
        efecha = (EditText)findViewById(R.id.eFecha);
        salida = (TextView)findViewById(R.id.textView);
        eset = (Button)findViewById(R.id.button);
        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH)+1;
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mfecha();
        selector = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                año = i;
                mes = i1+1;
                dia = i2;
                mfecha();
            }
        };


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this,selector,año,mes,dia);
        }
        return null;
    }

    public void showcalendar(View control){
        showDialog(Tipo);
    }

    public void mfecha(){
        efecha.setText(dia+"/"+mes+"/"+año);

    }

    public void ejecutar(View v){
        salida.setText("User: "+eloggin.getText()+"\n"+" Email:" + eemail.getText().toString()+"\n" + "DateBirth: " + efecha.getText());

    }
}
