package v1.forestapp.com.forestapp;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
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
import v1.forestapp.com.forestapp.DAL.DataBaseManager;
import v1.forestapp.com.forestapp.DTO.ArbolDTO;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaInventarioFragment extends Fragment {

    ListView listItemArboles;
    Context cnt;
    ArrayList<ArbolDTO> datos;
    AdaptadorListViewArboles adaptador;
    private DataBaseManager manager;

    public ListaInventarioFragment() {
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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View vista = inflater.inflate(R.layout.fragment_lista_inventario, container, false);

        datos= new ArrayList<ArbolDTO>();
        cnt= getActivity().getApplicationContext();
        manager = new DataBaseManager(cnt);
        adaptador = new AdaptadorListViewArboles(cnt, R.layout.layout_adaptador_arboles, datos);

        listItemArboles = (ListView) vista.findViewById(R.id.listView);
        listItemArboles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView Nombre = (TextView)view.findViewById(R.id.txtNombre);
                ArbolDTO Arbol = manager.getArbol(Nombre.getText().toString());
                MostrarDialog(Arbol);
            }
        });

        ActualizarListaArboles();
        return vista;
    }
    private void ActualizarListaArboles () {
        datos.clear();
        datos = manager.getListaArboles();
        if (datos.size() > 0) {
            adaptador = new AdaptadorListViewArboles(cnt, R.layout.layout_adaptador_arboles, datos);
            listItemArboles.setAdapter(adaptador);
        }
    }

    private void MostrarDialog(ArbolDTO arbol){
        FragmentManager fm = getFragmentManager();
        NuevoArbolDialogFragment dialogFragment = new NuevoArbolDialogFragment(cnt,arbol,null);
        dialogFragment.show(fm, "Sample Fragment");
    }
}




