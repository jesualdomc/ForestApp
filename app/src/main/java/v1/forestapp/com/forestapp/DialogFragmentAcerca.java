package v1.forestapp.com.forestapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Admin_Sena on 28/07/2016.
 */
public class DialogFragmentAcerca extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle("Acerca de");
        builder.setMessage("ForestApp es una aplicación móvil la cual te permite conocer toda la información de un árbol determinado," +
                " puedes acceder a nuestro inventario a través de la opción Inventario, también puedes enterarte de las noticias" +
                " actuales en Valledupar, tips para cuidar el medio ambiente y datos curiosos acerca de la flora de la ciudad de Valledupar.");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }
}
