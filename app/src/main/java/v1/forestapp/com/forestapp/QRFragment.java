package v1.forestapp.com.forestapp;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import v1.forestapp.com.forestapp.DAL.DataBaseManager;
import v1.forestapp.com.forestapp.DTO.ArbolDTO;


/**
 * A simple {@link Fragment} subclass.
 */
public class QRFragment extends Fragment implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    Context cnt;

    public QRFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el diseño de este fragmento.
        View Vista = inflater.inflate(R.layout.fragment_qr, container, false);
        cnt = getActivity().getApplicationContext();
        mScannerView = new ZXingScannerView(Vista.getContext());//Mediante programacion inicia la vista del scanner.

        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Inicia la camara
        return mScannerView;
    }

    @Override
    public void handleResult(Result rawResult) {
        Log.e("handler", rawResult.getText()); //Imprime los resultados del análisis.
        Log.e("handler", rawResult.getBarcodeFormat().toString()); //Imprime el formato de exploración(qrcode)

        //Muestra el resultado del escáner en el cuadro de diálogo .
        DataBaseManager manager = new DataBaseManager(cnt);
        ArbolDTO Arbol = manager.getArbol(rawResult.getText());
        if(Arbol != null){
            mScannerView.stopCamera();
            MostrarDialog(Arbol);
        }

        mScannerView.resumeCameraPreview(this);
    }

    private void MostrarDialog(ArbolDTO arbol){
        FragmentManager fm = getFragmentManager();
        NuevoArbolDialogFragment dialogFragment = new NuevoArbolDialogFragment(cnt,arbol,this.mScannerView);
        dialogFragment.show(fm, "Sample Fragment");

    }
}

