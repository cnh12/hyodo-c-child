package com.postit.mymomsweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.postit.mymomsweather.Model.EmotionRecord;
import com.postit.mymomsweather.databinding.ItemEmotionWeatherBinding;

import java.util.ArrayList;

public class InfoBoardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<EmotionRecord> data = new ArrayList<>();

    InfoBoardAdapter(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WeatherViewHolder(ItemEmotionWeatherBinding.inflate(LayoutInflater.from(mContext),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((WeatherViewHolder)(holder)).bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void setItem(EmotionRecord er){
        data.clear();
        data.add(er);
        notifyDataSetChanged();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{

        ItemEmotionWeatherBinding binding;
        public WeatherViewHolder(ItemEmotionWeatherBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(EmotionRecord er){
            if(er == null){
                return;
            }
            switch (er.getEmotion()){
                case 0:
                    binding.weatherImageView.setImageResource(R.drawable.ic_outline_wb_sunny_24);
                    binding.weatherDescriptionTextView.setText("좋아요!");
                    break;
                case 1:
                    binding.weatherImageView.setImageResource(R.drawable.ic_outline_cloud_24);
                    binding.weatherDescriptionTextView.setText("무기력해요");
                    break;
                case 2:
                    binding.weatherImageView.setImageResource(R.drawable.ic_outline_mode_night_24);
                    binding.weatherDescriptionTextView.setText("슬퍼요");
                    break;
                case 3:
                    binding.weatherImageView.setImageResource(R.drawable.ic_outline_bolt_24);
                    binding.weatherDescriptionTextView.setText("화나요");
                    break;

            }
        }


    }


}