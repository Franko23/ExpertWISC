package com.example.franko.expertwisc;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.franko.expertwisc.Tools.PBDialog;
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Register extends AppCompatActivity {
    final Context context = this;
    ConexionHelper con;

    private TextInputLayout textInputLayoutNombre;
    private TextInputLayout textInputLayoutApellido;
    private TextInputLayout textInputLayoutUsuario;
    private TextInputLayout textInputLayoutContraseña;
    private TextInputLayout textInputLayoutConfirmararContraseña;

    private TextInputEditText textInputEditTextNombre;
    private TextInputEditText textInputEditTextApellido;
    private TextInputEditText textInputEditTextUsuario;
    private TextInputEditText textInputEditTextContraseña;
    private TextInputEditText textInputEditTextConfirmarContraseña;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatImageView appCompatImageView;

    private static final int SELECT_PHOTO = 1;
    private static final int CAPTURE_PHOTO = 2;

    private Boolean hasImageChanged = false;
    Bitmap thumbnail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.setTitle("Registro de usuario");

        con = new ConexionHelper(this,"bd_wisc", null, 1);

        textInputLayoutNombre = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        textInputLayoutApellido = (TextInputLayout) findViewById(R.id.textInputLayoutApellido);
        textInputLayoutUsuario = (TextInputLayout) findViewById(R.id.textInputLayoutUser);
        textInputLayoutContraseña = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmararContraseña = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);

        textInputEditTextNombre = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextApellido = (TextInputEditText) findViewById(R.id.textInputEditTextApellido);
        textInputEditTextUsuario = (TextInputEditText) findViewById(R.id.textInputEditTextUser);
        textInputEditTextContraseña = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmarContraseña= (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatImageView = (AppCompatImageView) findViewById(R.id.imgProfilePic);


        appCompatButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });

        appCompatImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(false);
                builder.setTitle("Selecciona una opción:");
                builder.setItems(R.array.uploadImages, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                                photoPickerIntent.setType("image/*");
                                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                                break;
                                case 1:
                                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    startActivityForResult(intent, CAPTURE_PHOTO);
                                    break;
                                    case 2:
                                        appCompatImageView.setImageResource(R.drawable.n_user);
                                        break;
                        }

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //the user clicked on Cancel
                    }
                });
                builder.show();

            }
        });

    }

    private void registrarUsuario() {

        SQLiteDatabase db = con.getWritableDatabase();
        View focusView = null;
        boolean cancel = false;

        textInputLayoutNombre.setError(null);
        textInputLayoutApellido.setError(null);
        textInputLayoutUsuario.setError(null);
        textInputLayoutContraseña.setError(null);
        textInputLayoutConfirmararContraseña.setError(null);

        String nombre = textInputEditTextNombre.getText().toString();
        String apellido = textInputEditTextApellido.getText().toString();
        String usuario = textInputEditTextUsuario.getText().toString();
        String contraseña = textInputEditTextContraseña.getText().toString();
        String conContraseña = textInputEditTextConfirmarContraseña.getText().toString();

        appCompatImageView.setDrawingCacheEnabled(true);
        appCompatImageView.buildDrawingCache();
        Bitmap bitmap =  appCompatImageView.getDrawingCache();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte[] data = baos.toByteArray();


        //Verificamos si los campos no están vacios
        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(apellido) || TextUtils.isEmpty(usuario) || TextUtils.isEmpty(contraseña) || TextUtils.isEmpty(conContraseña) ){
            textInputLayoutNombre.setError(getString(R.string.error_field_required));
            textInputLayoutApellido.setError(getString(R.string.error_field_required));
            textInputLayoutUsuario.setError(getString(R.string.error_field_required));
            textInputLayoutContraseña.setError(getString(R.string.error_field_required));
            textInputLayoutConfirmararContraseña.setError(getString(R.string.error_field_required));
            focusView = textInputLayoutNombre;
            cancel = true;
        }else {


            ContentValues persona = new ContentValues();
            persona.put(Utilidades.CAMPO_NOMBRE_PERSONA, nombre);
            persona.put(Utilidades.CAMPO_APELLIDO_PERSONA, apellido);
            persona.put(Utilidades.CAMPO_IMAGEN_PERSONA, data);
            persona.put(Utilidades.CAMPO_TIPO_PERSONA, "user");

            ContentValues user = new ContentValues();

            try {
                //ProgressDialog
                PBDialog PBDialog = new PBDialog(context);
                PBDialog.setProgressBar();

                //Insert to Table Person
                Long resPersona=db.insert(Utilidades.TABLA_PERSONA, Utilidades.CAMPO_ID_PERSONA, persona);
                //Obtenemos el resultado en Long y convertimos a String
                String a, b;
                a = Long.toString(resPersona);
                //Convertimos el resultado String en int
                int number = Integer.parseInt(a);

                user.put(Utilidades.CAMPO_NOMBRE_USUARIO, usuario);
                user.put(Utilidades.CAMPO_CONTRASENA_USUARIO, contraseña);
                user.put(Utilidades.CAMPO_ID_PERSONA, number);

                Long resUser=db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID_USUARIO, user);
                b = Long.toString(resUser);

                Toast.makeText(getApplicationContext(),"Persona: "+a + " Usuario "+b, Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"Error al insertar Usuario o Persona", Toast.LENGTH_SHORT).show();
            }

        }
        db.close();
        if (cancel){
            focusView.requestFocus();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                appCompatImageView.setEnabled(true);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SELECT_PHOTO){
            if(resultCode == RESULT_OK) {
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    //set Progress Bar
//                    setProgressBar();
                    //set profile picture form gallery
                    PBDialog PBDialog = new PBDialog(context);
                    PBDialog.setProgressBar();
                    appCompatImageView.setImageBitmap(selectedImage);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }else if(requestCode == CAPTURE_PHOTO){
            if(resultCode == RESULT_OK) {
                onCaptureImageResult(data);
            }
        }
    }


    private void onCaptureImageResult(Intent data) {
        thumbnail = (Bitmap) data.getExtras().get("data");

        PBDialog PBDialog = new PBDialog(context);
        PBDialog.setProgressBar();
        //set Progress Bar
//        setProgressBar();
        //set profile picture form camera
//        appCompatImageView.setMaxWidth(300);
        appCompatImageView.setImageBitmap(thumbnail);

    }

}
