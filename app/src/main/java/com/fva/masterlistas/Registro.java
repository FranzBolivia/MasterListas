package com.fva.masterlistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
 public EditText bCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("nombre");





        Toast.makeText(this,  s , Toast.LENGTH_LONG).show();



        EditText b1Correo = (EditText) findViewById (R.id.correo);

        //b1Correo.setText(bCorreo.getText().toString());
        b1Correo.setText(s);




    }

    public void loguearCheckbox(View v) {
        CheckBox recordarme = (CheckBox) findViewById(R.id.avisos);
        String s = "Enviar Avisos: " + (recordarme.isChecked() ? "Sí" : "No");
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
