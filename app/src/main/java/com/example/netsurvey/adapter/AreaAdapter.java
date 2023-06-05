package com.example.netsurvey.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netsurvey.R;
import com.example.netsurvey.model.Area;

import java.util.ArrayList;

public class AreaAdapter extends RecyclerView.Adapter<AreaViewHolder> {
    ArrayList<Area> areas;
    Context ctx;
    private OnClickListener onClickListener;

    public AreaAdapter(Context ctx, ArrayList<Area> areas) {
        this.ctx = ctx;
        this.areas = areas;
    }

    @NonNull
    @Override
    public AreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View listItem = inflater.inflate(R.layout.list_item,parent,false);
        return new AreaViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaViewHolder holder, int position) {
        Area area = areas.get(position);
        holder.road.setText(areas.get(position).getRoad());
        holder.link.setText(areas.get(position).getLink());
        holder.start.setText(areas.get(position).getStart());
        holder.startValue.setText(areas.get(position).getStartPoint());
        holder.end.setText(areas.get(position).getEnd());
        holder.endValue.setText(areas.get(position).getEndPoint());
        holder.corridor.setText(areas.get(position).getCorridor());
        holder.region.setText(areas.get(position).getRegion());
        holder.subLink.setText(areas.get(position).getSubLink());
        holder.shoulder.setText(areas.get(position).getShoulderType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(position,area);
            }
        });
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, Area model);
    }
    @Override
    public int getItemCount() {
        return areas.size();
    }
}

class AreaViewHolder extends RecyclerView.ViewHolder{

    public TextView road,link,start,startValue,end,endValue,corridor,region,subLink,shoulder;

    public AreaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.road = itemView.findViewById(R.id.list_road_body);
        this.link = itemView.findViewById(R.id.list_link_body);
        this.start = itemView.findViewById(R.id.list_start_body);
        this.startValue=itemView.findViewById(R.id.list_start_value);
        this.end = itemView.findViewById(R.id.list_end_body);
        this.endValue=itemView.findViewById(R.id.list_end_value);
        this.corridor = itemView.findViewById(R.id.list_corridor_body);
        this.region = itemView.findViewById(R.id.list_region_body);
        this.subLink = itemView.findViewById(R.id.list_sublink_body);
        this.shoulder = itemView.findViewById(R.id.list_shoulder_body);
    }
}
