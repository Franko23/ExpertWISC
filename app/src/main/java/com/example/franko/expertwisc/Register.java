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
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Tools.PBDialog;
import com.example.franko.expertwisc.Utilidades.Utilidades;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.internal.InternalTokenResult;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity {
    private static final String TAG = "Mensaje";
    FirebaseFirestore dbFire = FirebaseFirestore.getInstance();
    Boolean existe = false;
    String nUsuario, idUsuario, cUsuario;
    Boolean fUsuario;
    TextView mensaje;

    final Context context = this;
    ConexionHelper con;

    private TextInputLayout textInputLayoutNombre;
    private TextInputLayout textInputLayoutApellido;
    private TextInputLayout textInputLayoutUsuario;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutContraseña;
    private TextInputLayout textInputLayoutConfirmararContraseña;

    private TextInputEditText textInputEditTextNombre;
    private TextInputEditText textInputEditTextApellido;
    private TextInputEditText textInputEditTextUsuario;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextContraseña;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatButton appCompatButtonConectar;
    private AppCompatImageView appCompatImageView;
    private AppCompatImageView appCompatImageViewUser;


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
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutContraseña = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        textInputEditTextNombre = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextApellido = (TextInputEditText) findViewById(R.id.textInputEditTextApellido);
        textInputEditTextUsuario = (TextInputEditText) findViewById(R.id.textInputEditTextUser);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextContraseña = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);
        appCompatButtonConectar = (AppCompatButton) findViewById(R.id.appCompatButtonConectar);

        appCompatImageView = (AppCompatImageView) findViewById(R.id.imgProfilePic);


        mensaje = findViewById(R.id.txt_mensaje);

        appCompatButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()){
                    registrarUsuario(v);
                }else {
                    Snackbar.make(v, "No hay conexión a internet", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        appCompatButtonConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbFire.collection("usuarios")
                        .whereEqualTo("usuario", textInputEditTextUsuario.getText().toString())
                        .whereEqualTo("contraseña",textInputEditTextContraseña.getText().toString())
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG, document.getId() + " => " + document.getData());
                                        existe = true;
                                        nUsuario = document.getString("usuario");
                                        cUsuario = document.getString("contraseña");
                                        fUsuario = document.getBoolean("free");
                                        idUsuario = document.getId();
//                                        Log.d("Usuario",nUsuario);
                                    }
                                    if (existe){
                                        mensaje.setText("CONECTADO!");
//                                        mensaje.setTextColor(getColor(R.color.colorPrimaryDark));
                                        mensaje.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
//                                        appCompatImageViewUser.setVisibility(View.GONE);
                                        textInputEditTextUsuario.setEnabled(false);
                                        textInputEditTextContraseña.setEnabled(false);
                                        appCompatButtonConectar.setVisibility(View.GONE);

                                        appCompatImageView.setVisibility(View.VISIBLE);
                                        textInputEditTextNombre.setVisibility(View.VISIBLE);
                                        textInputLayoutNombre.setVisibility(View.VISIBLE);
                                        textInputEditTextApellido.setVisibility(View.VISIBLE);
                                        textInputLayoutApellido.setVisibility(View.VISIBLE);
                                        textInputEditTextEmail.setVisibility(View.VISIBLE);
                                        textInputLayoutEmail.setVisibility(View.VISIBLE);
                                        appCompatButtonRegister.setVisibility(View.VISIBLE);


                                    }else {
                                        mensaje.setText("No existe el usuario");
//                                        mensaje.setTextColor(getColor(R.color.colorAccent));
                                        mensaje.setTextColor(getResources().getColor(R.color.colorAccent));
                                    }
                                    mensaje.setVisibility(View.VISIBLE);


                                } else {
                                    Log.d(TAG, "Error getting documents: ", task.getException());

                                }
                            }
                        });
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

    private Boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        return info != null && info.isAvailable() && info.isConnected();

    }

    private void registrarUsuario(View view) {
// Access a Cloud Firestore instance from your Activity

        SQLiteDatabase db = con.getWritableDatabase();
        View focusView = null;
        boolean cancel = false;
        int number = 0, id_Usuario=0;

        textInputLayoutNombre.setError(null);
        textInputLayoutApellido.setError(null);


        String nombre = textInputEditTextNombre.getText().toString();
        String apellido = textInputEditTextApellido.getText().toString();
        String email = textInputEditTextUsuario.getText().toString();

        appCompatImageView.setDrawingCacheEnabled(true);
        appCompatImageView.buildDrawingCache();
        Bitmap bitmap =  appCompatImageView.getDrawingCache();
        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte[] data = baos.toByteArray();


        //Verificamos si los campos no están vacios
        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(apellido) || TextUtils.isEmpty(email) ){
            textInputLayoutNombre.setError(getString(R.string.error_field_required));
            textInputLayoutApellido.setError(getString(R.string.error_field_required));
            textInputLayoutEmail.setError(getString(R.string.error_field_required));

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
                Long resPersona = db.insert(Utilidades.TABLA_PERSONA, Utilidades.CAMPO_ID_PERSONA, persona);
                //Obtenemos el resultado en Long y convertimos a String
                String a, b;
                a = Long.toString(resPersona);
                //Convertimos el resultado String en int
                number = Integer.parseInt(a);

                user.put(Utilidades.CAMPO_NOMBRE_USUARIO, nUsuario);
                user.put(Utilidades.CAMPO_EMAIL_USUARIO, email);
                user.put(Utilidades.CAMPO_CONTRASENA_USUARIO, cUsuario);
                user.put(Utilidades.CAMPO_ID_PERSONA, number);
                user.put(Utilidades.CAMPO_FREE_USUARIO, fUsuario);

                Long resUser = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID_USUARIO, user);
                b = Long.toString(resUser);
                id_Usuario = Integer.parseInt(b);
                // Almanecenando un nuevo usuario


                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            } catch (Exception e) {
                Snackbar.make(view, "Error al guardar usuario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }


            DocumentReference usuarios = dbFire.collection("usuarios").document(nUsuario);

            // Add a new document with a generated id.
            Map<String, Object> currentUser = new HashMap<>();
            currentUser.put("imagen",String.valueOf(data));
            currentUser.put("nombres", textInputEditTextNombre.getText().toString());
            currentUser.put("apellidos", textInputEditTextApellido.getText().toString());
            currentUser.put("e-mail", textInputEditTextEmail.getText().toString());


            usuarios
                    .update(currentUser)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "Usuario " + nUsuario + " actualizado correctamente");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error al actualizar " + nUsuario, e);
                        }
                    });
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
