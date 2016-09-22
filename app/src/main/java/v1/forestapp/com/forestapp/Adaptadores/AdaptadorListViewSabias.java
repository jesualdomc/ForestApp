package v1.forestapp.com.forestapp.Adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import v1.forestapp.com.forestapp.DTO.SabiasDTO;
import v1.forestapp.com.forestapp.R;

/**
 * Created by Admin_Sena on 22/09/2016.
 */

public class AdaptadorListViewSabias extends ArrayAdapter<SabiasDTO> {

    List<SabiasDTO> datos;
    ArrayList<SabiasDTO> datosBackup;
    Context cnt;
    int layout_list;

    public AdaptadorListViewSabias(Context context, int resource, List<SabiasDTO> objects)
    {
        super(context,resource,objects);
        datos=objects;
        cnt=context;
        layout_list=resource;
        datosBackup = new ArrayList<>();
        datosBackup.addAll(datos);
    }

    private class ViewHolder {
        TextView txtNombre;
        TextView txtDescripcion;
        CircleImageView Imagen;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        AdaptadorListViewSabias.ViewHolder holder = null;
        SabiasDTO rowItem = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());


        if (convertView == null) {
            convertView = inflater.inflate(layout_list, null);
            holder = new AdaptadorListViewSabias.ViewHolder();
            holder.txtNombre = (TextView) convertView.findViewById(R.id.txtNombre);
            holder.txtDescripcion = (TextView) convertView.findViewById(R.id.txtDescripcion);
            holder.Imagen = (CircleImageView) convertView.findViewById(R.id.itemImage);
            convertView.setTag(holder);
        } else
            holder = (AdaptadorListViewSabias.ViewHolder) convertView.getTag();
        holder.txtNombre.setText(rowItem.getNombre());
        holder.txtDescripcion.setText(rowItem.getDescripcion());
        holder.Imagen.setImageResource(rowItem.getImagen());

        return convertView;
    }

    public Filter getFilter() {
        return new Filter() {
            //
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                if(constraint != null) {
                    Log.e("performFiltering",constraint.toString());
                    datos.clear();
                    for (SabiasDTO sabias : datosBackup)
                    {
                        if (sabias.getNombre().toLowerCase(Locale.getDefault()).contains(constraint)
                                || sabias.getDescripcion().toLowerCase(Locale.getDefault()).contains(constraint))
                        {
                            datos.add(sabias);
                        }
                    }
                    FilterResults filterResults = new FilterResults();
                    filterResults.values = datos;
                    filterResults.count = datos.size();
                    Log.e("filterResults",String.valueOf(filterResults.count));
                    return filterResults;
                } else {
                    return new FilterResults();
                }
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        datos.clear();
        if (charText.length() == 0) {
            datos.addAll(datosBackup);
        }
        else
        {
            for (SabiasDTO sabias : datosBackup)
            {
                if (sabias.getNombre().toLowerCase(Locale.getDefault()).contains(charText)
                        || sabias.getDescripcion().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    datos.add(sabias);
                }
            }
        }
        notifyDataSetChanged();
    }
}
