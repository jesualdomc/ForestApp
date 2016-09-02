package v1.forestapp.com.forestapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment {
    WebView webView;

    public NoticiasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_noticias, container, false);
        webView = (WebView)v.findViewById(R.id.mi_navegador);
        webView.loadUrl("http://elpilon.com.co/");

        webView.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverriceUrlLoading(WebView view, String url)
            {
                return false;
            }
        });

            return v;



    }

}
