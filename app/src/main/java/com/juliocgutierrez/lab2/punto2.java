package com.juliocgutierrez.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class punto2 extends AppCompatActivity {

    private Button bcalcu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);
        final RadioButton radiosuma= (RadioButton) findViewById(R.id.suma);
        final RadioButton radioresta= (RadioButton) findViewById(R.id.resta);
        final RadioButton radiomulti= (RadioButton) findViewById(R.id.multi);
        final RadioButton radiodiv= (RadioButton) findViewById(R.id.div);

        final EditText enumber1=(EditText) findViewById(R.id.enumber1);
        final EditText enumber2=(EditText) findViewById(R.id.enumber2);
        final TextView eresult=(TextView) findViewById(R.id.eresult);
        Button bcalcu=(Button) findViewById(R.id.bcalcu);

        bcalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number1, number2,result;

                if(!enumber1.getText().toString().isEmpty() && !enumber2.getText().toString().isEmpty()) {
                    number1=Double.parseDouble(enumber1.getText().toString());
                    number2=Double.parseDouble(enumber2.getText().toString());
                    result=0;
                    if (radiosuma.isChecked()) {
                        result = number1 + number2;
                    }
                    if (radioresta.isChecked()) {
                        result = number1 - number2;
                    }
                    if (radiomulti.isChecked()) {
                        result = number1 * number2;
                    }
                    if (radiodiv.isChecked()) {
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            eresult.setText("INF");
                        }
                    }
                    eresult.setText(String.valueOf(result));
                }
                // to=Double.parseDouble(eto.getText().toString());
            }
        });
    }
}
