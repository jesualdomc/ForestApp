package v1.forestapp.com.forestapp.ClasesAsincronas;



import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Admin_Sena on 26/07/2016.
 * Clase para consumir servicios rest mediante el metodo GET
 */
public class GetAsyncrona extends AsyncTask<String, Void, String> {


    HttpURLConnection urlConnection;
    private ProgressDialog progressDialog;

    public interface AsyncResponse {
        void processFinish(String output);
    }
    public AsyncResponse delegate = null;



    public GetAsyncrona(Context cnt, AsyncResponse delegate) {
        progressDialog = new ProgressDialog(cnt);
        this.delegate = delegate;
    }

    public void execute() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onPreExecute() {
        this.progressDialog.setMessage("Descargando...");
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.show();
    }

    //Variable ruta se guarda la URI del servicio GET a consumir
    @Override
    protected String doInBackground(String... ruta) {
        StringBuilder total = new StringBuilder();
        try {
            URL url = new URL(ruta[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return total.toString();
    }

    public void onPostExecute(String result) {
        super.onPostExecute(result);
        delegate.processFinish(result);
        progressDialog.dismiss();
        //Se retorna un string que contiene un JSON con los datos obtenidos
    }
}

