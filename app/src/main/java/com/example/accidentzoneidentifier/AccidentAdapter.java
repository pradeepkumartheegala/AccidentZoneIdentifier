package com.example.accidentzoneidentifier;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AccidentAdapter extends RecyclerView.Adapter<AccidentAdapter.AccidentViewHolder> {

    Dashboard dashboard;
    List<AccidentData> accidentList;

    public AccidentAdapter(Dashboard dashboard, List<AccidentData> accidentList) {
        this.dashboard = dashboard;
        this.accidentList = accidentList;
    }

    @NonNull
    @Override
    public AccidentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_model, viewGroup, false);
        return new AccidentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccidentViewHolder viewHolder, int i) {
        viewHolder.address.setText(accidentList.get(i).getAddress());
        viewHolder.stateTV.setText(accidentList.get(i).getState());
        viewHolder.zipcodeTV.setText(accidentList.get(i).getZip());
    }

    @Override
    public int getItemCount() {
        return accidentList.size();
    }


    public static class AccidentViewHolder extends RecyclerView.ViewHolder {

        TextView address, stateTV, zipcodeTV;
        View view;
        private Listener listener;

        public AccidentViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemClick(v, getAdapterPosition());
                    return true;
                }
            });

            address = itemView.findViewById(R.id.nameTV);
            stateTV = itemView.findViewById(R.id.startTV);
            zipcodeTV = itemView.findViewById(R.id.endTV);


        }

        public void setOnClickListener(Listener listener) {
            this.listener = listener;
        }

        public interface Listener {
            void onItemClick(View view, int position);

            void onItemLongClick(View view, int position);
        }
    }

}

