package com.example.franko.expertwisc;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.franko.expertwisc.Entidades.Persona;
import com.example.franko.expertwisc.FragmentosPrincipales.AboutMe;
import com.example.franko.expertwisc.FragmentosPrincipales.DatosPaciente;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.DirectaEscalar;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.IndicesCI;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.PerfilCompuestas;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.PerfilEscalar;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.Sugerencias;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.Sugerencias_free;
import com.example.franko.expertwisc.FragmentosPrincipales.GeneralSubPruebas;
import com.example.franko.expertwisc.FragmentosPrincipales.ListaPacientes;
import com.example.franko.expertwisc.FragmentosPrincipales.RegistroPaciente;
import com.example.franko.expertwisc.FragmentosPrincipales.Resultados;
import com.example.franko.expertwisc.FragmentosPrincipales.Upgrade;
import com.example.franko.expertwisc.FragmentosSubTest.A;
import com.example.franko.expertwisc.FragmentosSubTest.Ad;
import com.example.franko.expertwisc.FragmentosSubTest.Ar;
import com.example.franko.expertwisc.FragmentosSubTest.BS;
import com.example.franko.expertwisc.FragmentosSubTest.C;
import com.example.franko.expertwisc.FragmentosSubTest.CC;
import com.example.franko.expertwisc.FragmentosSubTest.CF;
import com.example.franko.expertwisc.FragmentosSubTest.Cl;
import com.example.franko.expertwisc.FragmentosSubTest.Co;
import com.example.franko.expertwisc.FragmentosSubTest.I;
import com.example.franko.expertwisc.FragmentosSubTest.LN;
import com.example.franko.expertwisc.FragmentosSubTest.M;
import com.example.franko.expertwisc.FragmentosSubTest.RD;
import com.example.franko.expertwisc.FragmentosSubTest.S;
import com.example.franko.expertwisc.FragmentosSubTest.V;
import com.example.franko.expertwisc.Tools.BlurBuilder;
import com.example.franko.expertwisc.Tools.Consultas;
import com.example.franko.expertwisc.Utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        ListaPacientes.OnFragmentInteractionListener,
        RegistroPaciente.OnFragmentInteractionListener,
        GeneralSubPruebas.OnFragmentInteractionListener,
        DatosPaciente.OnFragmentInteractionListener,
        CC.OnFragmentInteractionListener,
        S.OnFragmentInteractionListener,
        RD.OnFragmentInteractionListener,
        Co.OnFragmentInteractionListener,
        Cl.OnFragmentInteractionListener,
        V.OnFragmentInteractionListener,
        LN.OnFragmentInteractionListener,
        M.OnFragmentInteractionListener,
        C.OnFragmentInteractionListener,
        BS.OnFragmentInteractionListener,
        CF.OnFragmentInteractionListener,
        A.OnFragmentInteractionListener,
        I.OnFragmentInteractionListener,
        Ar.OnFragmentInteractionListener,
        Ad.OnFragmentInteractionListener,
        Resultados.OnFragmentInteractionListener,
        DirectaEscalar.OnFragmentInteractionListener,
        IndicesCI.OnFragmentInteractionListener,
        PerfilCompuestas.OnFragmentInteractionListener,
        PerfilEscalar.OnFragmentInteractionListener,
        Sugerencias.OnFragmentInteractionListener,
        Sugerencias_free.OnFragmentInteractionListener,
        AboutMe.OnFragmentInteractionListener,
        Upgrade.OnFragmentInteractionListener
{
    FloatingActionButton fab;
    ImageView imageViewProfile;
    TextView textViewNameProfile;
    CircleImageView circleImageView;
    LinearLayout linear_back;
    Integer contador = 0;
    ConexionHelper con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        con = new ConexionHelper(this,"bd_wisc", null, 1);

        fab = findViewById(R.id.fab);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (Utilidades.pantalla == true){
            Fragment fragment = new ListaPacientes();
            getSupportFragmentManager().beginTransaction().add(R.id.content_main,fragment).commit();
            Utilidades.pantalla = false;
        }

        if (Utilidades.rotacionFab==0){
            fab.show();
        }else{
            fab.hide();
        }

        Consultas consultas = new Consultas();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Contador: "+Utilidades.currentCounterPatients,Toast.LENGTH_LONG).show();

                //Si es free
                if (Utilidades.currentUserFreeUsuario.equals("1")){
                    if (consultas.Contador(getApplicationContext()) > 1){
                        Snackbar.make(view, "Ha superado la cantidad máxima de registro de pacientes en esta versión", Snackbar.LENGTH_LONG).show();
                    }else{
                        fab.hide();
                        Utilidades.rotacionFab=1;
                        Fragment fragment = new RegistroPaciente();
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();

                        CambioTitulo("Registro de paciente");
                    }

                }else{
                    fab.hide();
                    Utilidades.rotacionFab=1;
                    Fragment fragment = new RegistroPaciente();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();

                    CambioTitulo("Registro de paciente");
                }

            }
        });

        Bundle bundle = getIntent().getExtras();
        Persona persona;
        persona = (Persona) bundle.getSerializable("persona");


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);

        textViewNameProfile = hView.findViewById(R.id.nameProfile);
        circleImageView = hView.findViewById(R.id.imageViewProfile);
        linear_back = hView.findViewById(R.id.linear_back_header);

        if (persona != null){

            textViewNameProfile.setText(persona.getNombre_persona()+" "+persona.getApellido_persona());
            byte[] image = persona.getImagen_persona();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
            circleImageView.setImageBitmap(bitmap);
            //Enviamos el bitmap para recibir un BlurImage
            Bitmap imageBlur = BlurBuilder.blur(getApplicationContext(), bitmap);
            try{
                Drawable newImage = ConvertBitmapToDrawable(imageBlur);
//                linear_back.setBackground(newImage);
            }catch (Exception e){

            }

        }else{
            Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_LONG).show();
        }

    }

    private Drawable ConvertBitmapToDrawable(Bitmap bitmap) {
        Drawable drawable = new BitmapDrawable(getResources(),bitmap);
        return drawable;
    }


    private void CambioTitulo(String titulo) {
        this.setTitle(titulo);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("SALIR");
            builder.setMessage("¿Estás seguro de salir?");

            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Utilidades.pantalla=true;
                    finish();
                    moveTaskToBack(true);
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sigout) {
            Utilidades.pantalla = true;
            this.finish();
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Boolean aBoolean = false;

        Consultas consultas = new Consultas();

        if (id == R.id.nav_inicio) {
            fragment = new ListaPacientes();
            aBoolean = true;
            fab.show();
            Utilidades.rotacionFab =0;
            CambioTitulo("Inicio");
        } else if (id == R.id.nav_nuevo_paciente) {

            if (Utilidades.currentUserFreeUsuario.equals("1")) {
                if (consultas.Contador(getApplicationContext()) > 1) {
                    Toast.makeText(getApplicationContext(),"Ha superado la cantidad máxima de registro de pacientes en esta versión",Toast.LENGTH_SHORT).show();
                }else {
                    fragment = new RegistroPaciente();
                    aBoolean = true;
                    fab.hide();
                    Utilidades.rotacionFab=1;
                    CambioTitulo("Registro de pacientes");
                }

            }else{
                fragment = new RegistroPaciente();
                aBoolean = true;
                fab.hide();
                Utilidades.rotacionFab=1;
                CambioTitulo("Registro de pacientes");
            }
//            Toast.makeText(getApplicationContext(),"Contador: "+Utilidades.currentCounterPatients,Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_datos) {
//            fragment = new CC();
//            aBoolean = true;
//            fab.hide();
//            Utilidades.rotacionFab=1;
//            CambioTitulo("Datos");
            Toast.makeText(getApplicationContext(),"Pronto...",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_config) {
//            fragment = new AboutMe();
//            aBoolean = true;
//            fab.hide();
//            CambioTitulo("Sobre mi");
            Toast.makeText(getApplicationContext(),"Pronto...",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_upgrade) {
            fragment = new Upgrade();
            aBoolean = true;
            fab.hide();
            CambioTitulo("Actualizar aplicación");
        }
        else if (id == R.id.nav_sobre) {
            fragment = new AboutMe();
            aBoolean = true;
            fab.hide();
            CambioTitulo("Sobre mi");
        }

        if (aBoolean){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
