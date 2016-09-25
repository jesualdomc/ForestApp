package v1.forestapp.com.forestapp;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import v1.forestapp.com.forestapp.Noticias.NoticiasFragment;
import v1.forestapp.com.forestapp.Noticias.NoticiasFragment2;
import v1.forestapp.com.forestapp.Noticias.NoticiasFragment3;

public class    RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView Noticiasname;
    public ImageView Noticiasphoto;

    public FragmentManager fragmentManager; //ojo

    private Fragment fragment;

    public static List<ItemObjectMonAbs> listaMon = new ArrayList<ItemObjectMonAbs>();

    public RecyclerViewHolders(View itemView, FragmentManager fragmentManager) {// ojo
        super(itemView);
        itemView.setOnClickListener(this);
        Noticiasname = (TextView) itemView.findViewById(R.id.noticia_name);
        Noticiasphoto = (ImageView) itemView.findViewById(R.id.noticia_photo);
        this.fragmentManager = fragmentManager;
    }
    @Override
    public void onClick(View view) {
        //Toast.makeText(view.getContext(), "Categoría noticias: " + getPosition(), Toast.LENGTH_SHORT).show();

        int opc;

        opc = getPosition();

        switch (opc){

            case 0: //Toast.makeText(view.getContext(), "Noticias", Toast.LENGTH_SHORT).show();


                fragment = new NoticiasFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();

                break;
            case 1: //Toast.makeText(view.getContext(), "Noticias", Toast.LENGTH_SHORT).show();


                fragment = new NoticiasFragment2();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();

                break;
            case 2: //Toast.makeText(view.getContext(), "Noticias", Toast.LENGTH_SHORT).show();


                fragment = new NoticiasFragment3();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();

                break;

        }

    }

}