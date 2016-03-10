package com.juliocgutierrez.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button bview1;
    private Button bview2;
    private Button bview3;
    private Button bview4;
    private Button bback1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_view);

        Button bview1=(Button) findViewById(R.id.bview1);
        Button bview2=(Button) findViewById(R.id.bview2);
        Button bview3=(Button) findViewById(R.id.bview3);
        Button bview4=(Button) findViewById(R.id.bview4);

        bview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, punto1.class);
                startActivity(i);
            }
        });

        bview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, punto2.class);
                startActivity(i);
            }
        });

        bview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, punto3.class);
                startActivity(i);
            }
        });

        bview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, punto4.class);
                startActivity(i);
            }
        });

    }

}
