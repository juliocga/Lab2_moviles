package com.juliocgutierrez.lab2;



import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class punto4 extends AppCompatActivity {

    private EditText loggin;
    private EditText pass;
    private EditText conpass;
    private EditText email;
    private TextView tv;
    private String fecha;
    int num_user=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto4);

        Button benviar=(Button) findViewById(R.id.benviar);

        final Spinner spinner = (Spinner) findViewById(R.id.ciudades);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ciudades, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        final CheckBox natacion =(CheckBox) findViewById(R.id.natacion);
        final CheckBox futbol =(CheckBox) findViewById(R.id.futbol);
        final CheckBox dibujar =(CheckBox) findViewById(R.id.dibujar);
        final CheckBox musica =(CheckBox) findViewById(R.id.musica);
        final RadioButton masculino= (RadioButton) findViewById(R.id.masculino);
        final RadioButton femenino= (RadioButton) findViewById(R.id.femenino);
        loggin=(EditText) findViewById(R.id.eloggin);
        pass=(EditText) findViewById(R.id.epass);
        conpass=(EditText) findViewById(R.id.econpass);
        email=(EditText) findViewById(R.id.email);
        tv = (TextView) findViewById(R.id.tv_long);
        tv.setMovementMethod(new ScrollingMovementMethod());

        final User[] usuarios=new User[100];

        for (int i=0;i<10;i++){
            usuarios[i]=new User();
        }

        benviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message,sexo="",hobbies="",clave1,clave2;
                if(futbol.isChecked()){
                    hobbies=hobbies+"Futbol ";
                }
                if (natacion.isChecked()){
                    hobbies=hobbies+"Natacion ";
                }
                if(dibujar.isChecked()){
                    hobbies=hobbies+"Dibujar ";
                }
                if (musica.isChecked()){
                    hobbies=hobbies+"Musica ";
                }
                if(masculino.isChecked()){
                    sexo="Masculino";
                }
                if(femenino.isChecked()){
                    sexo="Femenino";
                }
                clave1=pass.getText().toString();
                clave2=conpass.getText().toString();
                if(!String.valueOf(loggin.getText()).isEmpty() && !String.valueOf(pass.getText()).isEmpty()
                        && !String.valueOf(conpass.getText()).isEmpty() && clave1.equals(clave2)
                        && !String.valueOf(email.getText()).isEmpty() && !sexo.isEmpty() && !hobbies.isEmpty()) {
                    usuarios[num_user].setLoggin(String.valueOf(loggin.getText()));
                    usuarios[num_user].setPassword(String.valueOf(pass.getText()));
                    usuarios[num_user].setEmail(String.valueOf(email.getText()));
                    usuarios[num_user].setSexo(String.valueOf(sexo));
                    usuarios[num_user].setFecha(String.valueOf(fecha));
                    usuarios[num_user].setCiudad(spinner.getSelectedItem().toString());
                    usuarios[num_user].setHobbies(hobbies);
                    loggin.getText().clear();
                    pass.getText().clear();
                    conpass.getText().clear();
                    email.getText().clear();
                    num_user++;
                    message = "USUARIO N." + num_user + '\n' + "ID: " + String.valueOf(loggin.getText()) + '\n' + "PASSWORD: " + String.valueOf(pass.getText()) + '\n' + "E-MAIL: " + String.valueOf(email.getText()) + '\n' +
                            "SEXO: " + sexo + '\n' + "FECHA DE NACIMIENTO: " + fecha + '\n' + "CIUDAD DE NACIMIENTO: " + spinner.getSelectedItem().toString() + '\n' + "HOBBIES: " + String.valueOf(hobbies) + '\n' + "*****************************"+ '\n';

                    tv.append(message);
                }else{
                    if(!clave1.equals(clave2)) {
                        Toast.makeText(punto4.this, "Verificar la contraseña", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(punto4.this, "Faltan datos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            fecha=String.valueOf(day)+'/'+String.valueOf(month+1)+'/'+String.valueOf(year);

        }
    }

}



