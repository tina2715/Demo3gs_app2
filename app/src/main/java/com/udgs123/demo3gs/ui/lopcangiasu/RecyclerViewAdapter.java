package com.udgs123.demo3gs.ui.lopcangiasu;

import android.app.Dialog;
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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Lopcangiasu> mData;
    Dialog myDialog;
    public RecyclerViewAdapter(List<Lopcangiasu> mData) {
        this.mData=mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lopcangiasu,parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(parent.getContext());
        myDialog.setContentView(R.layout.dialog_lopcangiasu);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable( Color.TRANSPARENT));


        vHolder.btn_xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_tenlop_tv_tc = (TextView) myDialog.findViewById(R.id.dialog_tenlop_id_tc);
                TextView dialog_ngaydang_tv_tc = (TextView) myDialog.findViewById(R.id.dialog_ngaydang_id_tc);
                TextView dialog_motayeucau_tv_tc = (TextView) myDialog.findViewById(R.id.dialog_motayeucau_id_tc);
                TextView dialog_monhoc_tv_tc = (TextView) myDialog.findViewById(R.id.dialog_monhoc_id_tc);
                TextView dialog_diachi_tv_tc = (TextView) myDialog.findViewById(R.id.dialog_diachi_id_tc);
                TextView dialog_hocphi_tv_tc = (TextView) myDialog.findViewById(R.id.dialog_hocphi_id_tc);
                TextView dialog_trinhdogiasu_tv_tc = (TextView) myDialog.findViewById(R.id.dialog_trinhdogiasu_id_tc);
                TextView dialog_thoigianhoc_tv_tc = (TextView) myDialog.findViewById(R.id.dialog_thoigianhoc_id_tc);
                dialog_tenlop_tv_tc.setText(mData.get(vHolder.getAdapterPosition()).getTenloptc());
                dialog_ngaydang_tv_tc.setText(mData.get(vHolder.getAdapterPosition()).getNgaydangtc());
                dialog_motayeucau_tv_tc.setText(mData.get(vHolder.getAdapterPosition()).getMotayeucautc());
                dialog_monhoc_tv_tc.setText(mData.get(vHolder.getAdapterPosition()).getMonhoctc());
                dialog_diachi_tv_tc.setText(mData.get(vHolder.getAdapterPosition()).getDiachitc());
                dialog_hocphi_tv_tc.setText(mData.get(vHolder.getAdapterPosition()).getHocphitc());
                dialog_trinhdogiasu_tv_tc.setText(mData.get(vHolder.getAdapterPosition()).getTrinhdogiasutc());
                dialog_thoigianhoc_tv_tc.setText(mData.get(vHolder.getAdapterPosition()).getThoigianhoctc());

                myDialog.show();
            }
        });


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_tenlop.setText(mData.get(position).getTenloptc());
        holder.tv_ngaydang.setText(mData.get(position).getNgaydangtc());
        holder.tv_motayeucau.setText(mData.get(position).getMotayeucautc());
        holder.tv_monhoc.setText(mData.get(position).getMonhoctc());
        holder.tv_diachi.setText(mData.get(position).getDiachitc());
        holder.tv_hocphi.setText(mData.get(position).getHocphitc());
        holder.tv_trinhdogiasu.setText(mData.get(position).getTrinhdogiasutc());
        holder.tv_thoigianhoc.setText(mData.get(position).getThoigianhoctc());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_tenlop;
        private  TextView tv_ngaydang;
        private TextView tv_motayeucau;
        private TextView tv_monhoc;
        private TextView tv_diachi;
        private TextView tv_hocphi;
        private TextView tv_trinhdogiasu;
        private TextView tv_thoigianhoc;
        private Button btn_xemchitiet;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_tenlop = (TextView) itemView.findViewById( R.id.ten_ttlophoc_tc);
            tv_ngaydang = (TextView) itemView.findViewById(R.id.ngaydang_ttlophoc_tc);
            tv_motayeucau = (TextView) itemView.findViewById(R.id.motayeucau_ttlophoc_tc);
            tv_monhoc = (TextView) itemView.findViewById(R.id.monhoc_ttlophoc_tc);
            tv_diachi = (TextView) itemView.findViewById(R.id.diachi_ttlophoc_tc);
            tv_hocphi = (TextView) itemView.findViewById(R.id.hocphi_ttlophoc_tc);
            tv_trinhdogiasu = (TextView) itemView.findViewById(R.id.trinhdogiasu_ttlophoc_tc);
            tv_thoigianhoc = (TextView) itemView.findViewById(R.id.thoigianhoc_ttlophoc_tc);
            btn_xemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet_tc);
        }

    }

}
