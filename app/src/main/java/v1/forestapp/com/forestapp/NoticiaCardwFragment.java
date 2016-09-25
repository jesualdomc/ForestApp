package v1.forestapp.com.forestapp;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class  NoticiaCardwFragment extends Fragment {

    private LinearLayoutManager llayout;
    Context ctx;

    public NoticiaCardwFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noticia_cardw, container, false);
        ctx = getActivity().getApplicationContext();

        List<ItemObject> rowListItem = getAllItemList();
        llayout = new LinearLayoutManager(view.getContext());

        //((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Noticias");

        RecyclerView rView = (RecyclerView) view.findViewById(R.id.recycler_view);
        rView.setLayoutManager(llayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(view.getContext(), rowListItem, getFragmentManager());//ojo
        rView.setAdapter(rcAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private List<ItemObject> getAllItemList() {

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("EL PILON", R.drawable.elpilon));
        allItems.add(new ItemObject("Semanario La calle", R.drawable.lacalle));
        allItems.add(new ItemObject("RPT", R.drawable.rpt));


        return allItems;
    }

    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    // handle back button's click listener
                    //Toast.makeText(getActivity(), "Back press", Toast.LENGTH_SHORT).show();

                    Fragment fragment = new InicioFragment();
                    FragmentManager fragMana = getFragmentManager();
                    fragMana.beginTransaction()
                            .remove(NoticiaCardwFragment.this)
                            .replace(R.id.content_frame, fragment)
                            .commit();

                    return true;
                }
                return false;
            }
        });
    }
}