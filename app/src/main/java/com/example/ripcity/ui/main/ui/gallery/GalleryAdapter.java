package com.example.ripcity.ui.main.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ripcity.R;
import com.example.ripcity.ui.main.ui.UserHelperClass;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private Context mcontext;
    private List<UserHelperClass> users;

    public GalleryAdapter(Context mcontext, List<UserHelperClass> users) {
        this.mcontext = mcontext;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.user_list_item,parent,false);
        return new GalleryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserHelperClass userHelperClass = users.get(position);
        String id = userHelperClass.getId();
        String versus = userHelperClass.getVersus();
        String tanggal = userHelperClass.getTanggal();
        String time = userHelperClass.getTime();
        holder.Id.setText(id);
        holder.Versus.setText(versus);
        holder.Tanggal.setText(tanggal);
        holder.Time.setText(time);

    }

    @Override
    public int getItemCount() {
       return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView Id, Versus, Tanggal, Time;
        public ViewHolder(View itemView){
            super(itemView);
            Id=itemView.findViewById(R.id.textViewId);
            Versus=itemView.findViewById(R.id.textViewVersus);
            Tanggal=itemView.findViewById(R.id.textViewTanggal);
            Time=itemView.findViewById(R.id.textViewTime);
        }
    }
}
