package com.juliocgutierrez.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class punto3 extends AppCompatActivity {


       private EditText altura;
       private EditText base;
       private EditText radio;
       private EditText lado;
       private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto3);
        final RadioButton cuadrado= (RadioButton) findViewById(R.id.cuadrado);
        final RadioButton triangulo= (RadioButton) findViewById(R.id.trian);
        final RadioButton rectangulo= (RadioButton) findViewById(R.id.recta);
        final RadioButton circulo= (RadioButton) findViewById(R.id.circulo);
        altura=(EditText) findViewById(R.id.ealtura);
        base=(EditText) findViewById(R.id.ebase);
        radio=(EditText) findViewById(R.id.eradio);
        lado=(EditText) findViewById(R.id.elado);
        resultado=(TextView) findViewById(R.id.eresultarea);

        Button barea=(Button) findViewById(R.id.barea);

        barea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number1,number2,result;


                    result=0;
                    if (cuadrado.isChecked()) {
                        if(!lado.getText().toString().isEmpty()){
                            number1=Double.parseDouble(lado.getText().toString());
                            result = number1*number1;
                        }

                    }
                    if (triangulo.isChecked()) {
                        if(!base.getText().toString().isEmpty() && !altura.getText().toString().isEmpty()){
                            number1=Double.parseDouble(base.getText().toString());
                            number2=Double.parseDouble(altura.getText().toString());
                            result = (number1*number2)/2;
                        }
                    }
                    if (rectangulo.isChecked()) {
                        if(!base.getText().toString().isEmpty() && !altura.getText().toString().isEmpty()) {
                            number1 = Double.parseDouble(base.getText().toString());
                            number2 = Double.parseDouble(altura.getText().toString());
                            result=number1*number2;
                        }
                    }
                    if (circulo.isChecked()) {
                        if(!radio.getText().toString().isEmpty() ) {
                            number1 = Double.parseDouble(radio.getText().toString());
                            result=number1*number1*3.1416;
                        }
                    }
                    resultado.setText(String.valueOf(result));

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        altura=(EditText) findViewById(R.id.ealtura);
        base=(EditText) findViewById(R.id.ebase);
        radio=(EditText) findViewById(R.id.eradio);
        lado=(EditText) findViewById(R.id.elado);
        final LinearLayout laltura=(LinearLayout) findViewById(R.id.altura);
        final LinearLayout lbase=(LinearLayout) findViewById(R.id.base);
        final LinearLayout lradio=(LinearLayout) findViewById(R.id.radio);
        final LinearLayout llado=(LinearLayout) findViewById(R.id.lado);
        resultado=(TextView) findViewById(R.id.eresultarea);
        boolean checked = ((RadioButton) view).isChecked();
        altura.getText().clear(); base.getText().clear(); radio.getText().clear();lado.getText().clear();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.cuadrado:
                if (checked)
                    laltura.setVisibility(View.GONE);
                    lbase.setVisibility(View.GONE);
                    lradio.setVisibility(View.GONE);
                    llado.setVisibility(View.VISIBLE);
                    break;
            case R.id.trian:
                if (checked)
                    laltura.setVisibility(View.VISIBLE);
                    lbase.setVisibility(View.VISIBLE);
                    lradio.setVisibility(View.GONE);
                    llado.setVisibility(View.GONE);
                    break;
            case R.id.recta:
                if (checked)
                    laltura.setVisibility(View.VISIBLE);
                    lbase.setVisibility(View.VISIBLE);
                    lradio.setVisibility(View.GONE);
                    llado.setVisibility(View.GONE);
                    break;
            case R.id.circulo:
                if (checked)
                    laltura.setVisibility(View.GONE);
                    lbase.setVisibility(View.GONE);
                    lradio.setVisibility(View.VISIBLE);
                    llado.setVisibility(View.GONE);
                    break;
        }
    }
}
