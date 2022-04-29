package com.example.recyclerpractice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConsultAdapter extends RecyclerView.Adapter<ConsultAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Consult> consults;
    private Context context;

    ConsultAdapter(Context context, List<Consult> consults){
        this.consults = consults;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Consult consult = consults.get(position);
        holder.photoView.setImageResource(consult.getPhotoResource());
        holder.nameView.setText(consult.getName());
        holder.surnameView.setText(consult.getSurname());
        holder.roomView.setText(consult.getRoom());

        ImageButton menu = holder.menuView;

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.getMenuInflater().inflate(R.menu.card_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.call:
                                context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 0555203613")));
                                return true;
                            case R.id.appoint_to_doctor:
                                return  true;
                            case R.id.online_consult:
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return consults.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView photoView;
        final TextView nameView, surnameView, roomView;
        final ImageButton menuView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photoView = itemView.findViewById(R.id.photo);
            nameView = itemView.findViewById(R.id.name);
            surnameView = itemView.findViewById(R.id.surname);
            roomView = itemView.findViewById(R.id.room);
            menuView = itemView.findViewById(R.id.menu);
        }
    }
}
