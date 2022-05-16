package com.app.cameraindex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class C_RecycleViewAdapter extends RecyclerView.Adapter<C_RecycleViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<CameraModel> cameraModels;

    public C_RecycleViewAdapter(Context context, ArrayList<CameraModel> cameraModels){
             this.context = context;
             this.cameraModels = cameraModels;
    }

    @NonNull
    @Override
    public C_RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout - Giving a look to our rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new C_RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull C_RecycleViewAdapter.MyViewHolder holder, int position) {
        //assigning values to the views we created in the recycler_view_row layout file
        //based om the position of the recycler view
        holder.tvName.setText(cameraModels.get(position).getCameraName());
        holder.tvRating.setText(cameraModels.get(position).getCameraRating());
        holder.tvYear.setText(cameraModels.get(position).getCameraYear());
        holder.imageView.setImageResource(cameraModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        //the recycler view just wants to know the number of items you want displayed
        return cameraModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the views from our recycler_view_row layout file
        // kinda like in the onCreate method

        ImageView imageView;
        TextView tvName, tvRating, tvYear;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView2);
            tvName = itemView.findViewById(R.id.textView3);
            tvRating = itemView.findViewById(R.id.textView4);
            tvYear = itemView.findViewById(R.id.textView5);

        }
    }
}
