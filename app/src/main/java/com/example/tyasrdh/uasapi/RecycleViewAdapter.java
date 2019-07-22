package com.example.tyasrdh.uasapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tyasrdh.uasapi.model.Musik;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private List<Musik> dataList = new ArrayList<>();
    private onViewClick listener;

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {
        Musik data = dataList.get(position);
        holder.tvMusikTitle.setText(data.getMusik_title());
        holder.tvMusikGenre.setText(data.getMusik_genre());
        holder.tvAwards.setText(data.getAwards());
        holder.tvLabel.setText(data.getLabel());
        holder.tvSinger.setText(data.getSinger());
        holder.tvReleaseYear.setText(data.getRelease_year());
        holder.tvMusikWriter.setText(data.getMusik_writer());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvMusikTitle, tvMusikGenre, tvAwards, tvLabel, tvSinger, tvReleaseYear, tvMusikWriter;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvMusikTitle= itemView.findViewById(R.id.tvMusikTitle);
            tvMusikGenre= itemView.findViewById(R.id.tvMusikGenre);
            tvAwards= itemView.findViewById(R.id.tvAwards);
            tvLabel= itemView.findViewById(R.id.tvLabel);
            tvSinger= itemView.findViewById(R.id.tvSinger);
            tvReleaseYear= itemView.findViewById(R.id.tvReleaseYear);
            tvMusikWriter= itemView.findViewById(R.id.tvMusikWriter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onViewClick(getAdapterPosition());
                }
            });
        }
    }

    public void setDataList(List<Musik> list ){
        this.dataList = list;
        notifyDataSetChanged();
    }

    public void clearDataList(List<Musik> list ){
        this.dataList = list;
        dataList.clear();
    }

    public interface onViewClick{
        void onViewClick(int position);
    }

    public void setOnClickListener(onViewClick listener){
        this.listener = listener;
    }
}
