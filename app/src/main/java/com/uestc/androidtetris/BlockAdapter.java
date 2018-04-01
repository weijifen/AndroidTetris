package com.uestc.androidtetris;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by dell on 2018/3/23.
 */

public class BlockAdapter extends CommonAdapter {
    Context context;
    List<Integer> mDatas;
    public BlockAdapter(Context context, List mDatas, int mLayoutId) {
        super(context, mDatas, mLayoutId);
        this.context = context;
        this.mDatas=mDatas;
    }

    @Override
    public void convert(ViewHolder helper, Object item) {
        ImageView imageView= helper.getView(R.id.adapter_image);

        Integer integer = (Integer) item;
        if (integer > 0) {
//            imageView.setBackgroundResource(StateFang.color[integer-1]);
            Glide.with(context)
                    .load(StateFang.color[integer - 1])
                    .into(imageView);
//            imageView.setBackgroundColor(Color.BLUE);
        }else {
            imageView.setBackgroundColor(Color.parseColor("#29505B"));
        }

    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);
//        convertView.setLayoutParams(new GridView.LayoutParams(22,22));
//        return convertView;
//    }

}
