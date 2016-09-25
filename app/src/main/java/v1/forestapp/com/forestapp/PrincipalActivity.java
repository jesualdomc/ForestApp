package v1.forestapp.com.forestapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LlenarArbolesDB llenar;
    Context cnt;
    LlenarSabiasQueDB llenarSabias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        cnt = this;
        llenar = new LlenarArbolesDB();
        llenar.FillGrid(cnt);

        cnt = this;
        llenarSabias = new LlenarSabiasQueDB();
        llenarSabias.FillGrid(cnt);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragmento = new InicioFragment();
        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragmento)
                .commit();

        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment fragmento = new InicioFragment();;
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragmento).commit();
            //super.onBackPressed();
        }

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean fragmentTransaction = false;
        Fragment fragmento = null;
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.home) {
            fragmento = new InicioFragment();
            fragmentTransaction = true;

        } else if (id == R.id.inventario) {
            fragmento = new ListaInventarioFragment();
            fragmentTransaction = true;

        }else if (id== R.id.sabias_que){
            fragmento = new SabiasQueFragment();
            fragmentTransaction = true;
        }

        else if (id == R.id.mi_navegador) {
            fragmento = new NoticiaCardwFragment();
            fragmentTransaction = true;
        }if (fragmentTransaction) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, fragmento)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }
        else if (id == R.id.acerdade) {
            fragmento = new DialogFragmentAcerca();
            FragmentManager fm = getFragmentManager();
            DialogFragmentAcerca dialogFragment = new DialogFragmentAcerca ();
            dialogFragment.show(fm, "Sample Fragment");
        }
        else if (id == R.id.idsalir){
            fragmento = new ExitFragment();
            FragmentManager fm = getFragmentManager();
            ExitFragment dialogFragment = new ExitFragment();
            dialogFragment.show(fm,"Sample Fragment");
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

