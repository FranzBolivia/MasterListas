package com.fvillalpando.masterlistas;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InicioSesionActivity extends AppCompatActivity {
    private TextView bRegistro;
    private ArrayList bloqueo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        bRegistro = (TextView) findViewById(R.id.registro);

        Button buttonBloqueo = (Button) findViewById(R.id.boton_facebook);
        buttonBloqueo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementaIndiceDeBloqueo(null);
            }
        });
        Button buttonANR = (Button) findViewById(R.id.boton_google);
        buttonANR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementaIndiceDeANR(null);
            }
        });


        bRegistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarRegitro(null);

            }
        });


    }

    private void lanzarRegitro(View view) {
        EditText temporal1 = (EditText) findViewById(R.id.usuario);
        String temporal = temporal1.getText().toString();
        Intent i = new Intent(this, Registro.class);
        i.putExtra("nombre", temporal);
        startActivity(i);

    }


    public void loguearCheckbox(View v) {
        CheckBox recordarme = (CheckBox) findViewById(R.id.recordarme);
        String s = getString(R.string.rec_dat_usuario) + (recordarme.isChecked() ? getString(R.string.resource_si) : getString(R.string.resource_no));
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void mostrarContrasena(View v) {
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        CheckBox mostrar = (CheckBox) findViewById(R.id.mostrar_contraseña);
        if (mostrar.isChecked()) {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        } else {
            contraseña.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    public void acceder(View view) {

        Intent intent = new Intent(this, ListasActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void borrarCampos(View view) {
        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        usuario.setText("");
        contraseña.setText("");
        usuario.requestFocus();
    }

    public void incrementaIndiceDeBloqueo(View view) {
        bloqueo.add(null);
    }

    public void incrementaIndiceDeANR(View view) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
