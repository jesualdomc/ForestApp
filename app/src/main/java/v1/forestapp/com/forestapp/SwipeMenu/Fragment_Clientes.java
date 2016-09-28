package v1.forestapp.com.forestapp.SwipeMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import v1.forestapp.com.forestapp.R;

/**
 * Created by Jesualdo Martinez on 27/09/2016.
 */

public class Fragment_Clientes extends Fragment {

    public Fragment_Clientes() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clientes, container, false);
    }
}
