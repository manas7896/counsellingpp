package com.example.careerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ValueEventListener;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Lambda;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdaptervh> {

    public List<bookingprof> bookingmodel = new ArrayList<>();
    public Context context;

    public MyAdapter(List<bookingprof> usermodel, Context context1){
        this.bookingmodel = usermodel;
        this.context = context1;
    }



    @NonNull
    @Override
    public MyAdaptervh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cardholder,parent,false);

        return new MyAdaptervh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdaptervh holder, int position) {
    bookingprof bookingprof1 = bookingmodel.get(position);
    String date_time = bookingprof1.getDate_timeofapppoint();
    String name1 = bookingprof1.getFullname();
    String gende = bookingprof1.getGender();
    String numph = bookingprof1.getPhoneno();
    String ids = bookingprof1.getStudentid();

    holder.dat_time.setText(date_time);
    holder.name.setText(name1);
    holder.gend.setText(gende);
    holder.numphone.setText(numph);
    holder.idstude.setText(ids);
    }

    @Override
    public int getItemCount() {
        return bookingmodel.size();
    }

    public static class MyAdaptervh extends RecyclerView.ViewHolder{

        private TextView dat_time,name,gend,idstude,numphone;
        public MyAdaptervh(@NonNull View itemView) {
            super(itemView);
            dat_time = itemView.findViewById(R.id.appointdat_time);
            name = itemView.findViewById(R.id.fullname);
            gend = itemView.findViewById(R.id.gen_der);
            idstude = itemView.findViewById(R.id.idstud);
            numphone = itemView.findViewById(R.id.phoneno);

        }
    }
}
