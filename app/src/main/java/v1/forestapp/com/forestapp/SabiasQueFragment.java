package v1.forestapp.com.forestapp;


import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import v1.forestapp.com.forestapp.Adaptadores.AdaptadorListViewArboles;
import v1.forestapp.com.forestapp.Adaptadores.AdaptadorListViewSabias;
import v1.forestapp.com.forestapp.DAL.DataBaseManager;
import v1.forestapp.com.forestapp.DTO.ArbolDTO;
import v1.forestapp.com.forestapp.DTO.SabiasDTO;


/**
 * A simple {@link Fragment} subclass.
 */
public class SabiasQueFragment extends Fragment {

    ListView listItemSabias;
    Context cnt;
    ArrayList<SabiasDTO> datos;
    AdaptadorListViewSabias adaptador;
    private DataBaseManager manager;


    public SabiasQueFragment() {
        // Required empty public constructor
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.principal, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptador.filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu,inflater);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View vista = inflater.inflate(R.layout.fragment_lista_inventario, container, false);

        datos= new ArrayList<SabiasDTO>();
        cnt= getActivity().getApplicationContext();
        manager = new DataBaseManager(cnt);
        adaptador = new AdaptadorListViewSabias(cnt, R.layout.layout_adaptador_arboles, datos);

        listItemSabias = (ListView) vista.findViewById(R.id.listView);
        listItemSabias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView Nombre = (TextView)view.findViewById(R.id.txtNombre);
                SabiasDTO Sabias = manager.getSabias(Nombre.getText().toString());
                MostrarDialog(Sabias);
            }
        });

        ActualizarListaSabias();
        return vista;
    }
    private void ActualizarListaSabias () {
        datos.clear();
        datos = manager.getListaSabias();
        if (datos.size() > 0) {
            adaptador = new AdaptadorListViewSabias(cnt, R.layout.layout_adaptador_arboles, datos);
            listItemSabias.setAdapter(adaptador);
        }
    }

    private void MostrarDialog(SabiasDTO sabias){
        FragmentManager fm = getFragmentManager();
        NuevoSabiasQueFragment dialogFragment = new NuevoSabiasQueFragment(cnt,sabias);
        dialogFragment.show(fm, "Sample Fragment");
    }

}
