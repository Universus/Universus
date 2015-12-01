package app.universus.Session;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import app.universus.com.universus.R;


/**
 * Created by isaac on 29/11/15.
 */
public class SessionActivity extends Activity {

    /*Elementos para interactuar*/
    private EditText matricula;
    private EditText contraseña;
    private Button ingresar;
    private Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_session);

        /*Asignación de elementos para recuperar información*/
        matricula = (EditText) findViewById(R.id.txt_matricula);
        contraseña = (EditText) findViewById(R.id.txt_contraseña);
        ingresar = (Button)findViewById(R.id.bttn_ingresar);
        //Elemento para hacer la conexión
        ingresar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                matricula.getText();
                contraseña.getText();


            }
        });

        registrarse = (Button) findViewById(R.id.bttn_registrarse);
        //Elemento para registrarse
        registrarse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent registrarse = new Intent(SessionActivity.this, RegisterActivity.class);
                startActivity(registrarse);
            }
        });
    }

}
