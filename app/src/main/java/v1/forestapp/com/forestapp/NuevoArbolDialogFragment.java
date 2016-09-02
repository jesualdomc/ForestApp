package v1.forestapp.com.forestapp;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import v1.forestapp.com.forestapp.DAL.DataBaseManager;
import v1.forestapp.com.forestapp.DTO.ArbolDTO;


/**
 * A simple {@link Fragment} subclass.
 */
public class NuevoArbolDialogFragment extends android.app.DialogFragment {

    private TextView NombreComun;
    private TextView NombreCientifico;
    private TextView Reino;
    private TextView Filo;
    private TextView Clase;
    private TextView Fruto;
    private TextView Flor;
    private TextView Descripcion;
    private ImageView Imagen;
    private ZXingScannerView mi_scanner;

    private ArbolDTO Arbol;
    private Context cnt;
    private DataBaseManager manager;



    public NuevoArbolDialogFragment(Context cnt, ArbolDTO arbol, ZXingScannerView scanner) {

        this.Arbol = arbol;
        manager = new DataBaseManager(cnt);
        this.mi_scanner = scanner;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater i = getActivity().getLayoutInflater();
        View v = i.inflate(R.layout.adaptador_lista_inventario,null);

        cnt= getActivity().getApplicationContext();

        NombreComun = (TextView) v.findViewById(R.id.tv_titulo_arbol);
        NombreCientifico = (TextView)v.findViewById(R.id.tv_nombre_cientifico);
        Reino = (TextView)v.findViewById(R.id.tv_reino);
        Filo = (TextView)v.findViewById(R.id.tv_filo);
        Clase = (TextView)v.findViewById(R.id.tv_clase);
        Fruto = (TextView)v.findViewById(R.id.tv_fruto);
        Flor = (TextView)v.findViewById(R.id.tv_flor);
        Descripcion = (TextView) v.findViewById(R.id.tv_contenido_arbol);
        Imagen = (ImageView)v.findViewById(R.id.iv_imagen);

        if (Arbol!= null){
            NombreComun.setText(Arbol.getNombreComun().toString());
            NombreCientifico.setText(Arbol.getNombreCientifico().toString());
            Reino.setText(Arbol.getReino().toString());
            Filo.setText(Arbol.getFilo().toString());
            Clase.setText(Arbol.getClase().toString());
            Fruto.setText(Arbol.getFruto().toString());
            Flor.setText(Arbol.getFlor().toString());
            Descripcion.setText(Arbol.getDescripcion().toString());
            Imagen.setImageResource(Arbol.getImagen());

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


    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        if(this.mi_scanner!= null)
            this.mi_scanner.startCamera();
    }
}