package org.ronaldomartinez.v_waiter.main.productos.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.ronaldomartinez.v_waiter.R;
import org.ronaldomartinez.v_waiter.entities.Productos;

import java.util.List;

/**
 * Created by Ronaldo on 17/07/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.producto_nombre);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

    List<Productos> persons;

    public Adapter(List<Productos> persons){
        this.persons = persons;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        PersonViewHolder pvh = new PersonViewHolder(v1);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personName.setText(persons.get(position).getName());
        holder.personPhoto.setImageResource(persons.get(position).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }



}
