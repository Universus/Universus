package app.universus.Helpers;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import app.universus.Helpers.RegisterActivity;
import app.universus.Main;
import app.universus.Models.UniversusBDDAdministrador;
import app.universus.com.universus.R;


public class SessionActivity extends Activity {

    /*Elementos para interactuar*/

    private EditText matricula;
    private EditText contraseña;
    private EditText telefono;
    private EditText correo;
    private Button ingresar;
    private Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_session);

        if(usuarioEstaLogueago()){
            Intent i = new Intent(this, Main.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("registrado", true);
            bundle.putString("contrasenya", "Hola");
            bundle.putString("matricula", "Es una prueba");
            i.putExtra("usuario", bundle);
            startActivity(i);
        }
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
                String matricula_s = matricula.getText().toString();
                String contraseña_s = contraseña.getText().toString();

                if(UniversusBDDAdministrador.getUsuario(matricula_s, contraseña_s) == null){
                    Toast.makeText(v.getContext(), "Usuario no registrado",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Intent i = new Intent(getApplicationContext(), Main.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("matricula", matricula_s);
                    bundle.putString("contraseña", contraseña_s);
                    bundle.putBoolean("registrado", true);
                    i.putExtra("usuario", bundle);
                    startActivity(i);
                }
            }
        });

        registrarse = (Button) findViewById(R.id.bttn_registrarse);

        //Elemento para registrarse
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registrarse = new Intent(SessionActivity.this, RegisterActivity.class);
                startActivity(registrarse);

            }
        });
    }

    private boolean usuarioEstaLogueago(){
        return false;
    }
}
