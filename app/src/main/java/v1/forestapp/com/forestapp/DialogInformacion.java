package v1.forestapp.com.forestapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import v1.forestapp.com.forestapp.DTO.ArbolDTO;

/**
 * Created by Jesualdo Martinez on 22/07/2016.
 */
public class DialogInformacion extends android.app.DialogFragment {

    ArbolDTO Arbol;
    public void setInventario (ArbolDTO arbol){
        this.Arbol=arbol;
     }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater i = getActivity().getLayoutInflater();
        View v = i.inflate(R.layout.activity_lista_inventario,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        return builder.create();
    }
}
