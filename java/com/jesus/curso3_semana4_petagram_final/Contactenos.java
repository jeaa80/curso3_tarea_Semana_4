package com.jesus.curso3_semana4_petagram_final;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Contactenos extends AppCompatActivity {

    private EditText correo, titulo, mensaje;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactenos);

        correo = (EditText) findViewById(R.id.etEmail);
        titulo = (EditText) findViewById(R.id.etNombre);
        mensaje = (EditText) findViewById(R.id.etMensaje);
        boton = (Button) findViewById(R.id.b_enviar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });


        Toolbar actionbar = (Toolbar) findViewById(R.id.topAppBar);
        actionbar.setTitle(R.string.contactenos);

        actionbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contactenos.this, MainActivity.class);
                startActivity(intent);
                Contactenos.this.finish();
            }
        });

    }
    private void sendEmail(){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL,correo.getText());
        email.putExtra(Intent.EXTRA_SUBJECT,titulo.getText());
        email.putExtra(Intent.EXTRA_TEXT,mensaje.getText());
        startActivity(Intent.createChooser(email,"Sent Email"));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Contactenos.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }



}