package com.uestc.androidtetris;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lucky_Xiao on 2016/5/15.
 */
public class ViewHolder {


    private final SparseArray<View> mViews;
    private final View mConvertView;
    private int mPosition;

    public ViewHolder(Context context, ViewGroup viewGroup, int layoutId, int position) {

        this.mPosition = position;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, viewGroup, false);
        mConvertView.setTag(this);

    }

    /**
     * 得到一个ViewHolder对象
     * @param context
     * @param convertView
     * @param viewGroup
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup viewGroup, int layoutId, int position) {
//        if (convertView == null)
//        {
//            return  (new ViewHolder(context,viewGroup,layoutId,position));
//        }
//        return  (ViewHolder)convertView.getTag();
        //上是改前，下是改后


//        if (convertView == null) {

            return (new ViewHolder(context, viewGroup, layoutId, position));
//        } else {
//            ViewHolder holder = (ViewHolder) convertView.getTag();
//            holder.mPosition = position;
//            return holder;
//        }
    }

    /**
     * 通过空间的Id获取对应的控件，如果没有则加入views
     * @param layoutId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int layoutId) {
        View view = mViews.get(layoutId);
        if (view == null) {
            view = mConvertView.findViewById(layoutId);
            mViews.put(layoutId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

}
