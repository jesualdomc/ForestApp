package v1.forestapp.com.forestapp;

import android.app.Fragment;
import android.app.FragmentManager;

import java.util.ArrayList;

import v1.forestapp.com.forestapp.Noticias.NoticiasFragment;

public class DesNoticias {

    public static int categoria, monumento;
    Fragment fragment;
    FragmentManager fragmentManager;
    public static ArrayList<Integer> lista;


    public DesNoticias(int categoria, int monumento, FragmentManager fragmentManager) {

        lista = new ArrayList<Integer>();
        this.categoria = categoria;
        this.monumento = monumento;
        this.fragmentManager = fragmentManager;
    }

    public void mostrarDescripcion() {

        switch (categoria) {

            case 0:

                switch (monumento) {

                    case 0:


                        lista.add(R.drawable.elpilon);
                        fragment = new NoticiasFragment();
                        fragmentManager.beginTransaction()
                                .replace(R.id.content_frame, fragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                }
                break;
        }
    }
}



