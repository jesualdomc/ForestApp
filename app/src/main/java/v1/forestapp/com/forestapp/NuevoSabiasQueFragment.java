package v1.forestapp.com.forestapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import v1.forestapp.com.forestapp.DAL.DataBaseManager;
import v1.forestapp.com.forestapp.DTO.SabiasDTO;

/**
 * Created by Admin_Sena on 22/09/2016.
 */

public class NuevoSabiasQueFragment extends android.app.DialogFragment {

    private TextView Nombre;
    private TextView Descripcion;
    private ImageView Imagen;

    private SabiasDTO Sabias;
    private Context cnt;
    private DataBaseManager manager;

    public NuevoSabiasQueFragment(Context cnt, SabiasDTO sabias) {

        this.Sabias = sabias;
        manager = new DataBaseManager(cnt);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater i = getActivity().getLayoutInflater();
        View v = i.inflate(R.layout.adaptador_lista_sabiasque,null);

        cnt= getActivity().getApplicationContext();

        Nombre = (TextView) v.findViewById(R.id.titulo_arbol);
        Descripcion = (TextView) v.findViewById(R.id.contenido_arbol);
        Imagen = (ImageView)v.findViewById(R.id.imagensabias);

        if (Sabias!= null){
            Nombre.setText(Sabias.getNombre().toString());
            Descripcion.setText(Sabias.getDescripcion().toString());
            Imagen.setImageResource(Sabias.getImagen());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("");
        builder.setPositiveButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.e("Jesu","No funciona");
            }
        });

        builder.setNegativeButton("", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        builder.setView(v);
        return builder.create();
    }
}
