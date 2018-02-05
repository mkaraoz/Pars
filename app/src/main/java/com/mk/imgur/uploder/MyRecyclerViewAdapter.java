package com.mk.imgur.uploder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mk.imgur.uploder.unsplash.Image;

/**
 * Created by mk on 02.02.2018.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>
{

    private Image[] mData = new Image[0];
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context c;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, Image[] data)
    {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.c = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Image i = mData[position];
        String imgUrl = i.getUrls().getSmall();

        GlideApp.with(c)
                .load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.image_placeholder)
                .centerCrop()
                .into(holder.ivPhotoView);

        holder.labePhotographerName.setText(i.getUser().getName());

        // holder.ivPhotoView.setRatio(ratio);

        //Glide.with(this).load(resourceId).transition(withCrossFade(fadeAnimDuration)).into(mBackground);
    }

    // total number of cells
    @Override
    public int getItemCount()
    {
        return mData.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView ivPhotoView;
        TextView labePhotographerName;

        ViewHolder(View itemView)
        {
            super(itemView);

            ivPhotoView = itemView.findViewById(R.id.image_from_unsplash);
            labePhotographerName = itemView.findViewById(R.id.label_photographer);
            labePhotographerName.setAlpha(0.8f);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            if (mClickListener != null)
            {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    // convenience method for getting data at click position
    String getItem(int id)
    {
        return "car";
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener)
    {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener
    {
        void onItemClick(View view, int position);
    }

    public void clear()
    {
        mData = new Image[0];
        notifyDataSetChanged();
    }
}
