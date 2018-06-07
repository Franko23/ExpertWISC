package com.example.franko.expertwisc;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.Entidades.Usuario;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Login extends AppCompatActivity {
    private TextInputEditText mUserView;
    private TextInputEditText mPasswordView;
    ConexionHelper con;
    ArrayList<Usuario> listaUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,"Karla-Regular.ttf", true );

        con = new ConexionHelper(this,"bd_wisc", null, 1);

        // Set up the login form.
        mUserView = (TextInputEditText) findViewById(R.id.user);
//        populateAutoComplete();

        mPasswordView = (TextInputEditText) findViewById(R.id.password);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.ingresar);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin(){

        SQLiteDatabase db = con.getWritableDatabase();
        // Reset errors.
        mUserView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String user = mUserView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        Intent intent;

        if (TextUtils.isEmpty(user)){
            mUserView.setError(getString(R.string.error_field_required));
            focusView = mUserView;
            focusView.requestFocus();
        }
        else if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            focusView.requestFocus();
        }else if(user.equals("admin")) {
            if (password.equals("admin")) {
                intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                focusView = mPasswordView;
                focusView.requestFocus();
            }
        }else{

            Cursor us = db.rawQuery("SELECT nombre_usuario FROM usuario WHERE nombre_usuario = ?", new String[] {user});
            if(us != null && us.getCount()>0) {
//                Toast toast = Toast.makeText(getApplicationContext(),"Existe: "+user, Toast.LENGTH_LONG);
//                toast.show();
                Cursor pw = db.rawQuery("SELECT id_usuario FROM usuario WHERE nombre_usuario = ? AND contrasena_usuario= ?", new String[] {user, password});
                if (pw.getCount()>0) {
                    int id = 0;
                    while (pw.moveToNext()){
                        id = pw.getInt(0);
                    }

                    ContentValues usuario = new ContentValues();
                    usuario.put(Utilidades.CAMPO_ACTIVO_USUARIO,1);

                    db.update(Utilidades.TABLA_USUARIO,usuario,Utilidades.CAMPO_ID_USUARIO+"="+id,null);

                    intent = new Intent(getApplicationContext(), Home.class);

                    Persona persona = null;
                    persona = llenarUsuario(id);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("persona",persona);

                    intent.putExtras(bundle);

                    startActivity(intent);
                }else {
                    mPasswordView.setError(getString(R.string.error_incorrect_password));
                    focusView = mPasswordView;
                    focusView.requestFocus();
                }
            }else{
                mUserView.setError(getString(R.string.error_incorrect_user));
                focusView = mUserView;
                focusView.requestFocus();
            }
        }

//
//
//        if (cancel) {
//            // There was an error; don't attempt login and focus the first
//            // form field with an error.
//            focusView.requestFocus();
//        } else {
//            // Show a progress spinner, and kick off a background task to
//            // perform the user login attempt.
//            intent = new Intent(getApplicationContext(), Home.class);
//            startActivity(intent);
//        }
    }

    private Persona llenarUsuario(int id) {
        SQLiteDatabase db = con.getReadableDatabase();

        Persona persona = null;
        Cursor cursor = db.rawQuery("SELECT * FROM persona WHERE id_persona="+id,null);

        while (cursor.moveToNext()) {

            persona = new Persona();

            persona.setNombre_persona(cursor.getString(1));
            persona.setApellido_persona(cursor.getString(2));
            persona.setImagen_persona(cursor.getBlob(4));
        }
        return persona;
    }
}
