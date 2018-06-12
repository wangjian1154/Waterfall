package com.wj.waterfalldemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private List<ImgBean> list;
    private final int width;
    private final int mHeight;

    public MyAdapter(Context mContext, List<ImgBean> list) {
        this.mContext = mContext;
        this.list = list;
        width = Utils.getScreenWidth(mContext) - 20;
        mHeight = Utils.getScreenHeight(mContext) / 2;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        int width = Utils.getScreenWidth(mContext) - 20;
        int height = width * list.get(position).getHeight() / list.get(position).getWidth();
        if (height >= mHeight) {
            height = mHeight;
        }
        holder.iv_pic.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        Glide.with(mContext).load(list.get(position).getImgPath()).into(holder.iv_pic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_pic;

        public MyViewHolder(View itemView) {
            super(itemView);

            iv_pic = itemView.findViewById(R.id.iv_pic);
        }
    }
}
