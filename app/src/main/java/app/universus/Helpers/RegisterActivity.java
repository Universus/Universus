package app.universus.Helpers;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        //Elemento para crear la cuenta
        crear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                matricula.getText();
                contraseña.getText();
                telefono.getText();
                confContraseña.getText();
                correo.getText();
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
