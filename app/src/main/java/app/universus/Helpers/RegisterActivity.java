package app.universus.Helpers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.universus.Main;
import app.universus.com.universus.R;

/**
 * Created by isaac on 30/11/15.
 */
public class RegisterActivity extends Activity {

    /*Elementos para interactuar*/
    private EditText matricula;
    private EditText contraseña;
    private EditText telefono;
    private EditText confContraseña;
    private EditText correo;
    private Button crear;
    private Button cancelar;
    private EditText nombre;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrer_layout);

        /*Asignación de elementos para recuperar información*/
        matricula = (EditText) findViewById(R.id.r_txt_matricula);
        contraseña = (EditText) findViewById(R.id.r_txt_contraseña);
        telefono = (EditText)findViewById(R.id.r_txt_telefono);
        confContraseña = (EditText)findViewById(R.id.r_conf_txt_contraseña);
        correo = (EditText)findViewById(R.id.r_txt_correo);
        crear = (Button)findViewById(R.id.btt_creat);
        nombre = (EditText) findViewById(R.id.r_txt_nombre);

        //Elemento para crear la cuenta
        crear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String matricula_s = matricula.getText().toString();
                String nombre_s = nombre.getText().toString();
                String contraseñ_s = contraseña.getText().toString();
                String confir_contra = confContraseña.getText().toString();
                String email = correo.getText().toString();

                if(!matricula_s.isEmpty() || !nombre_s.isEmpty()){
                    Intent i = new Intent(getApplicationContext(), Main.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("matricula", matricula_s);
                    bundle.putString("nombre", nombre_s);
                    bundle.putString("contraseña", contraseñ_s);
                    bundle.putString("correo", email);
                    bundle.putBoolean("registrado", false);
                    i.putExtra("usuario", bundle);
                    startActivity(i);

                }else{
                    Toast.makeText(v.getContext(), "Falatan campos por reyenar",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        cancelar = (Button)findViewById(R.id.btt_cancel);
        //Elemento para cancelar la creación de la cuenta
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo.getText();
            }
        });


    }
}
