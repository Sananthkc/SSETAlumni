package com.pro.ssetalumni;
import android.content.Context;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;

import static androidx.recyclerview.widget.RecyclerView.*;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;

    private List<UploadImage> mUploads;

    public ImageAdapter(Context context, List<UploadImage> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);


        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        UploadImage uploadCurrent = mUploads.get(position);
        holder.name.setText(uploadCurrent.getName());
        holder.textViewName.setText(uploadCurrent.getDescription());
        Picasso.get()
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.drawable.logo)
                .fit()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView imageView;
        public TextView name;


        public ImageViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_poster);
            textViewName = itemView.findViewById(R.id.text_view_description);
            imageView = itemView.findViewById(R.id.image_view_upload);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UploadImage uploadImage = mUploads.get(getAdapterPosition());
                    Intent i=new Intent(mContext, PostEdit.class);
                    i.putExtra("id",uploadImage.getKey());
                    i.putExtra("title",uploadImage.getName());
                    i.putExtra("desc",uploadImage.getDescription());
                    i.putExtra("imageurl",uploadImage.getImageUrl());
                    mContext.startActivity(i);
                }
            });
        }
    }
}