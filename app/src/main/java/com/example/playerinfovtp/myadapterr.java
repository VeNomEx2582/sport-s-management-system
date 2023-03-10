package com.example.playerinfovtp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapterr extends RecyclerView.Adapter<myviewholder>
{
   ArrayList<Model> data;
   Context context;
    public myadapterr(ArrayList<Model> data, Context context)

    {
        this.data = data;
        this.context=context;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myviewholder holder, int position)
    {
       final Model temp=data.get(position);

       holder.t1.setText(data.get(position).getHeader());
       holder.t2.setText(data.get(position).getDesc());
       holder.img.setImageResource(data.get(position).getImgname());
//       holder.ima.setImageResource(data.get(position).getCourtimg());
        holder.t3.setText(data.get(position).getTv3());
        holder.t4.setText(data.get(position).getTv4());
        holder.t5.setText(data.get(position).getTv5());

       holder.img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                 Intent intent=new Intent(context,MainActivity2.class);
//                 intent.putExtra("courtimg",temp.getCourtimg());
                 intent.putExtra("imagename",temp.getImgname());
                 intent.putExtra("header",temp.getHeader());
                 intent.putExtra("desc",temp.getDesc());
                 intent.putExtra("tv3",temp.getTv3());
                 intent.putExtra("tv4",temp.getTv4());
                 intent.putExtra("tv5",temp.getTv5());
                 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }
}
