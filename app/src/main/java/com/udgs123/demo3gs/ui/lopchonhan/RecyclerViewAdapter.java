package com.udgs123.demo3gs.ui.lopchonhan;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo3gs.R;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    Context mContext;
    List<Lopchonhan> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Lopchonhan> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_lopchonhan, parent, false);
        final MyViewHolder vHolder= new MyViewHolder(v);
        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_lopchonhan);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        vHolder.btn_xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_tenlop_tv = (TextView) myDialog.findViewById(R.id.dialog_tenlop_id);
                TextView dialog_trangthai_tv = (TextView) myDialog.findViewById(R.id.dialog_trangthai_id);
                TextView dialog_monhoc_tv = (TextView) myDialog.findViewById(R.id.dialog_monhoc_id);
                TextView dialog_diachi_tv = (TextView) myDialog.findViewById(R.id.dialog_diachi_id);
                TextView dialog_hocphi_tv = (TextView) myDialog.findViewById(R.id.dialog_hocphi_id);
                TextView dialog_trinhdogiasu_tv = (TextView) myDialog.findViewById(R.id.dialog_trinhdogiasu_id);
                TextView dialog_thoigianhoc_tv = (TextView) myDialog.findViewById(R.id.dialog_thoigianhoc_id);
                dialog_tenlop_tv.setText(mData.get(vHolder.getAdapterPosition()).getTenlop());
                dialog_trangthai_tv.setText(mData.get(vHolder.getAdapterPosition()).getTrangthai());
                dialog_monhoc_tv.setText(mData.get(vHolder.getAdapterPosition()).getMonhoc());
                dialog_diachi_tv.setText(mData.get(vHolder.getAdapterPosition()).getDiachi());
                dialog_hocphi_tv.setText(mData.get(vHolder.getAdapterPosition()).getHocphi());
                dialog_trinhdogiasu_tv.setText(mData.get(vHolder.getAdapterPosition()).getTrinhdogiasu());
                dialog_thoigianhoc_tv.setText(mData.get(vHolder.getAdapterPosition()).getThoigianhoc());
                myDialog.show();
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_tenlop.setText(mData.get(position).getTenlop());
        holder.tv_trangthai.setText(mData.get(position).getTrangthai());
        holder.tv_monhoc.setText(mData.get(position).getMonhoc());
        holder.tv_diachi.setText(mData.get(position).getDiachi());
        holder.tv_hocphi.setText(mData.get(position).getHocphi());
        holder.tv_trinhdogiasu.setText(mData.get(position).getTrinhdogiasu());
        holder.tv_thoigianhoc.setText(mData.get(position).getThoigianhoc());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        private TextView tv_tenlop;
        private TextView tv_trangthai;
        private TextView tv_monhoc;
        private TextView tv_diachi;
        private TextView tv_hocphi;
        private TextView tv_trinhdogiasu;
        private TextView tv_thoigianhoc;
        private Button btn_xemchitiet;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_tenlop = (TextView) itemView.findViewById(R.id.ten_ttlophoc);
            tv_trangthai = (TextView) itemView.findViewById(R.id.trangthai_ttlophoc);
            tv_monhoc = (TextView) itemView.findViewById(R.id.monhoc_ttlophoc);
            tv_diachi = (TextView) itemView.findViewById(R.id.diachi_ttlophoc);
            tv_hocphi = (TextView) itemView.findViewById(R.id.hocphi_ttlophoc);
            tv_trinhdogiasu = (TextView) itemView.findViewById(R.id.trinhdogiasu_ttlophoc);
            tv_thoigianhoc = (TextView) itemView.findViewById(R.id.thoigianhoc_ttlophoc);
            btn_xemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);

        }
    }
}
