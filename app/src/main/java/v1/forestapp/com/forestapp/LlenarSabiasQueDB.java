package v1.forestapp.com.forestapp;

import android.content.Context;

import java.util.ArrayList;

import v1.forestapp.com.forestapp.DAL.DataBaseManager;
import v1.forestapp.com.forestapp.DTO.SabiasDTO;

/**
 * Created by Admin_Sena on 22/09/2016.
 */

public class LlenarSabiasQueDB {

    DataBaseManager manager;

    public void FillGrid(Context cnt) {

        manager = new DataBaseManager(cnt);
        ArrayList<SabiasDTO> Listado = manager.getListaSabias();
        if (Listado.size() == 0) {

            SabiasDTO a = new SabiasDTO();
            a.setImagen(R.drawable.arbolachote);
            a.setNombre("Sabias que?");
            a.setDescripcion("Desde tiempos pasados esta planta medicinal fue usada para la elaboración de colorantes, así mismo fue usada como especie dentro de la preparación de ciertos platos.\n" +
                    "Los nombres comunes utilizados son: Achiote, acote, achihuete, saca achote, urcu, annato.");
            manager.InsertarSabias(a);
        }
    }
}
