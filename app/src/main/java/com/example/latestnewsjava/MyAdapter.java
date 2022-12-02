package com.example.latestnewsjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    List<ModelClass> modelClasses = new ArrayList<>();

    public MyAdapter(Context context, List<ModelClass> modelClasses) {
        this.context = context;
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.my_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelClass data = modelClasses.get(position);

        Glide.with(context).load(data.getCoverImage()).into(holder.image);
        holder.title.setText(data.getTitle().toString());
        holder.details.setText(data.getExcerpt().toString());
        holder.date.setText(data.getTime().toString());

    }

    @Override
    public int getItemCount() {
        return modelClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, details, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.tittle);
            details = itemView.findViewById(R.id.details);
            date = itemView.findViewById(R.id.published);
        }
    }
}
