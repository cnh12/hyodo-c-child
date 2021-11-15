package com.postit.mymomsweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.postit.mymomsweather.Model.ParentUser;
import com.postit.mymomsweather.databinding.ItemParentDurationCallBinding;

import java.util.ArrayList;

public class ParentListAdapter extends RecyclerView.Adapter<ParentListAdapter.ParentCallInfoViewHolder> {

    ArrayList<ParentUser> data = new ArrayList<>();
    Context mContext;

    ParentListAdapter(Context context){
        mContext=context;
    }

    @NonNull
    @Override
    public ParentCallInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ParentCallInfoViewHolder(ItemParentDurationCallBinding.inflate(LayoutInflater.from(mContext),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ParentCallInfoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ParentCallInfoViewHolder extends RecyclerView.ViewHolder{
        ItemParentDurationCallBinding binding;
        ParentCallInfoViewHolder(ItemParentDurationCallBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
        void bind(ParentUser parentUser){
            binding.nameTextView.setText(parentUser.getName());
            binding.durationTextView.setText("구현 안되었음");
        }
    }

    void setItem(ArrayList<ParentUser> data){
        this.data = data;
        notifyDataSetChanged();
    }
}
