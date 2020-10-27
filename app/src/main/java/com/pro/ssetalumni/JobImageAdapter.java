package com.pro.ssetalumni;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class JobImageAdapter extends RecyclerView.Adapter<JobImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<UploadImageJobs> mUploads;
    public JobImageAdapter(Context context, List<UploadImageJobs> uploads) {
        mContext = context;
        mUploads = uploads;
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.jobs_item, parent, false);
        return new ImageViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        UploadImageJobs uploadCurrent = mUploads.get(position);

        holder.jobDesc.setText(uploadCurrent.getDescription());
        Picasso.get()
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.drawable.logo)
                .fit()
                .into(holder.jobimageView);
    }
    @Override
    public int getItemCount() {
        return mUploads.size();
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView jobDesc;
        public ImageView jobimageView;
       // public TextView name;
        public ImageViewHolder(View itemView) {
            super(itemView);
         //   name = itemView.findViewById(R.id.jobname);
            jobDesc = itemView.findViewById(R.id.job_text_view_description);
            jobimageView = itemView.findViewById(R.id.job_image_view);
        }
    }
}