package v1.forestapp.com.forestapp;


import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;
    private FragmentManager fragmentManager; //ojo

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList, FragmentManager fragmentManager) {//ojo
        this.itemList = itemList;
        this.context = context;
        this.fragmentManager = fragmentManager;//ojo
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView, fragmentManager);//ojo
        return rcv;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.Noticiasname.setText(itemList.get(position).getName());
        holder.Noticiasphoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}