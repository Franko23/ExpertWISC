package com.example.franko.expertwisc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Splash extends AppCompatActivity {
    Thread splashTread;
    ConexionHelper con;
    int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Here, thisActivity is the current activity
//        if (ContextCompat.checkSelfPermission(getApplicationContext(),
//                Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
//
//                // Show an expanation to the user *asynchronously* -- don't block
//                // this thread waiting for the user's response! After the user
//                // sees the explanation, try again to request the permission.
//
//            } else {
//
//                // No explanation needed, we can request the permission.
//
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
//
//                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                // app-defined int constant. The callback method gets the
//                // result of the request.
//            }
//        }

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            appCompatImageView.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        StartAnimationImage();
        StartAnimationText();

        con = new ConexionHelper(this,"bd_wisc", null, 1);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3000) {
                        sleep(100);
                        waited += 100;
                    }
//                    StartAnimationLayout();
                    Intent intent;
                    Boolean isExist = Iniciar();
//                    Toast toast = Toast.makeText(getApplicationContext(),"RESP: "+isExist.toString(), Toast.LENGTH_LONG);
//                    toast.show();

                    if (isExist){
                        intent = new Intent(getApplicationContext(), Login.class);
                    }else{
                        intent = new Intent(getApplicationContext(), Register.class);
                    }
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Splash.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splash.this.finish();
                }

            }
        };
        splashTread.start();

    }


        private Boolean Iniciar () {

            boolean isExist = false;
//        if (ContextCompat.checkSelfPermission(getApplicationContext(),
//                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED);

            SQLiteDatabase db = con.getWritableDatabase();
//            this.deleteDatabase("db_ws");
            try {

                Cursor cursor = db.rawQuery("select nombre_usuario from usuario", null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        isExist = true;
                    }
                    cursor.close();
                }
            } catch (Exception e) {

            }

            return isExist;
        }

        private void StartAnimationImage () {
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
            anim.reset();
            LinearLayout l = (LinearLayout) findViewById(R.id.lin_lay);
            l.clearAnimation();
            l.startAnimation(anim);

        }

        private void StartAnimationText () {
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate);
            anim.reset();
            LinearLayout tv = (LinearLayout) findViewById(R.id.Texto);
            tv.clearAnimation();
            tv.startAnimation(anim);
        }
    }
