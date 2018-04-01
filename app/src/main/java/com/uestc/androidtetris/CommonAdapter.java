package com.uestc.androidtetris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.List;

/**
 * Created by Lucky_Xiao on 2016/5/15.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    private final LayoutInflater mInflater;
    private final int mItemLayoutId;
    Context mContext;
    List<T> mDatas;

    public CommonAdapter(Context context, List<T> mDatas, int mLayoutId)
    {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
        this.mItemLayoutId = mLayoutId;
    }

    //设置数据
    public void setDatas(List<T> datas){
        if(datas!=null){
            this.mDatas = datas;
            notifyDataSetChanged();
        }
    }

    //添加数据,如果要做一个排序的话，就在这里进行排序
    public void addDatas(List<T> datas){
        if(datas!=null){
            mDatas.addAll(datas);
            notifyDataSetChanged();
        }
    }
    public void addData(T data){
        if(data!=null){
            mDatas.add(data);
            notifyDataSetChanged();
        }
    }

    //删除数据
    public void deleteData(T data){
        if(mDatas!=null){
            mDatas.remove(data);
        }
    }

    public void clearData(){
        if(mDatas!=null){
            mDatas.clear(); //清空数据
            notifyDataSetChanged();
        }
    }

    protected List<T> getData(){
        return mDatas;
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final  ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder,getItem(position));
        return viewHolder.getConvertView();
    }
    public abstract void convert(ViewHolder helper,T item);
    public ViewHolder getViewHolder(int position, View convertView, ViewGroup parent)
    {
        return ViewHolder.get(mContext,convertView,parent,mItemLayoutId,position);
    }

    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }
}