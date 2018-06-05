package com.example.franko.expertwisc;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.franko.expertwisc.Entidades.Paciente;
import com.example.franko.expertwisc.Entidades.Usuario;
import com.example.franko.expertwisc.FragmentosPrincipales.DatosPaciente;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.DirectaEscalar;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.IndicesCI;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.PerfilCompuestas;
import com.example.franko.expertwisc.FragmentosPrincipales.FragmentosResultados.PerfilEscalar;
import com.example.franko.expertwisc.FragmentosPrincipales.GeneralSubPruebas;
import com.example.franko.expertwisc.FragmentosPrincipales.ListaPacientes;
import com.example.franko.expertwisc.FragmentosPrincipales.RegistroPaciente;
import com.example.franko.expertwisc.FragmentosPrincipales.Resultados;
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
import com.example.franko.expertwisc.Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.UUID;

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
        PerfilEscalar.OnFragmentInteractionListener
{
    FloatingActionButton fab;
    ImageView imageViewProfile;
    TextView textViewNameProfile;
    CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),NuevoPaciente.class);
//                startActivity(intent);

                Fragment fragment = new RegistroPaciente();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
                fab.hide();
                CambioTitulo("Registro de paciente");
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (Utilidades.pantalla == true){
            Fragment fragment = new ListaPacientes();
            getSupportFragmentManager().beginTransaction().add(R.id.content_main,fragment).commit();
            Utilidades.pantalla = false;
        }

        Bundle bundle = getIntent().getExtras();
        Usuario usuario = null;
        usuario = (Usuario) bundle.getSerializable("usuario");


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);
        textViewNameProfile = (TextView)hView.findViewById(R.id.nameProfile);
        circleImageView = (CircleImageView) hView.findViewById(R.id.imageViewProfile);

        if (usuario != null){

            textViewNameProfile.setText(usuario.getNombre()+" "+usuario.getApellido());
            byte[] image = usuario.getImagen();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
            circleImageView.setImageBitmap(bitmap);

        }else{
            Toast.makeText(getApplicationContext(),"Null",Toast.LENGTH_LONG).show();
        }

    }


    private void CambioTitulo(String titulo) {
        this.setTitle(titulo);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        Intent intent;
        Fragment fragment = null;
        Boolean aBoolean = false;

        if (id == R.id.nav_home) {
            fragment = new ListaPacientes();
            aBoolean = true;
            fab.show();
            CambioTitulo("Inicio");
        } else if (id == R.id.nav_new) {
            fragment = new RegistroPaciente();
            aBoolean = true;
            fab.hide();
            CambioTitulo("Registro de pacientes");
        } else if (id == R.id.nav_slideshow) {
            fragment = new GeneralSubPruebas();
            aBoolean = true;
            fab.hide();
            CambioTitulo("Sub Test");
        } else if (id == R.id.nav_manage) {
            fragment = new Resultados();
            aBoolean = true;
            fab.hide();
            CambioTitulo("Resultados");
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

            fab.show();
        }

        if (aBoolean){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
