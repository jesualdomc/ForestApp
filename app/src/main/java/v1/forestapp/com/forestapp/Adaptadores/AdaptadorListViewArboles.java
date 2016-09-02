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
import v1.forestapp.com.forestapp.DTO.ArbolDTO;
import v1.forestapp.com.forestapp.R;

/**
 * Created by Jesualdo Martinez on 11/08/2016.
 */
public class AdaptadorListViewArboles extends ArrayAdapter<ArbolDTO> {

    List<ArbolDTO> datos;
    ArrayList<ArbolDTO> datosBackup;
    Context cnt;
    int layout_list;

    public AdaptadorListViewArboles(Context context, int resource, List<ArbolDTO> objects)
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
        TextView txtClase;
        TextView txtDescripcion;
        CircleImageView Imagen;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        ArbolDTO rowItem = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());


        if (convertView == null) {
            convertView = inflater.inflate(layout_list, null);
            holder = new ViewHolder();
            holder.txtNombre = (TextView) convertView.findViewById(R.id.txtNombre);
            holder.txtClase = (TextView) convertView.findViewById(R.id.txtClase);
            holder.txtDescripcion = (TextView) convertView.findViewById(R.id.txtDescripcion);
            holder.Imagen = (CircleImageView) convertView.findViewById(R.id.itemImage);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
            holder.txtNombre.setText(rowItem.getNombreComun());
            holder.txtClase.setText(rowItem.getClase());
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
                    for (ArbolDTO arbol : datosBackup)
                    {
                        if (arbol.getNombreComun().toLowerCase(Locale.getDefault()).contains(constraint)
                                || arbol.getClase().toLowerCase(Locale.getDefault()).contains(constraint))
                        {
                            datos.add(arbol);
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
            for (ArbolDTO arbol : datosBackup)
            {
                if (arbol.getNombreComun().toLowerCase(Locale.getDefault()).contains(charText)
                    || arbol.getClase().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    datos.add(arbol);
                }
            }
        }
        notifyDataSetChanged();
    }
}
