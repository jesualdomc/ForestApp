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
            a.setDescripcion("El fruto del árbol achoite, sirve como colorante para comidas.");
            manager.InsertarSabias(a);

            SabiasDTO b = new SabiasDTO();
            b.setImagen(R.drawable.arbolmango);
            b.setNombre("Sabias que?");
            b.setDescripcion("El árbol de mango es la mayor arbolización en Valledupar.");
            manager.InsertarSabias(b);

            SabiasDTO c = new SabiasDTO();
            c.setImagen(R.drawable.canaguate);
            c.setNombre("Sabias que?");
            c.setDescripcion("El cañaguate cuando florece, los cerros de Valledupar se tornan amarillos gracias a los cañaguates florecidos.");
            manager.InsertarSabias(c);

            SabiasDTO d = new SabiasDTO();
            d.setImagen(R.drawable.arboluvitablanca);
            d.setNombre("Sabias que?");
            d.setDescripcion("El fruto de este arbol, sirve para pegante de muchas cosas.");
            manager.InsertarSabias(d);

        }
    }
}
