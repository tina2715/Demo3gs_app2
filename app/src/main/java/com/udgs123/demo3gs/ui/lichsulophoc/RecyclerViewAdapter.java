package com.udgs123.demo3gs.ui.lichsulophoc;

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

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.udgs123.demo3gs.OnItemClickListener;
import com.udgs123.demo3gs.R;
import com.udgs123.demo3gs.ui.dslophoc.Dslophoc;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    ArrayList<Lichsulophoc> mLichsulophoc;
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public RecyclerViewAdapter( ArrayList<Lichsulophoc> mLichsulophoc) {

        this.mLichsulophoc = mLichsulophoc;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lichsulophoc, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Lichsulophoc lichsulophoc = mLichsulophoc.get(position);
        holder.malophoc.setText(lichsulophoc.getMalophoc());
        holder.tentaikhoanhv.setText(lichsulophoc.getTentaikhoanhv());
        holder.caplop.setText(lichsulophoc.getCaplop());
        holder.tenmonhoc.setText(lichsulophoc.getTenmonhoc());
        holder.diadiem.setText(lichsulophoc.getDiadiem());
        holder.ngaydukien.setText(lichsulophoc.getNgaydukien());
        holder.soluonggio.setText(lichsulophoc.getSoluonggio());
        holder.ngayhoctrongtuan.setText(lichsulophoc.getNgayhoctrongtuan());
        holder.giobatdau.setText(lichsulophoc.getGiobatdau());
        holder.loaitrinhdo.setText(lichsulophoc.getLoaitrinhdo());
        holder.mota.setText(lichsulophoc.getMota());
        holder.ngaytao.setText(lichsulophoc.getNgaytao());
        holder.trangthailop.setText(lichsulophoc.getTrangthailop());
        holder.tentaikhoangs.setText(lichsulophoc.getTentaikhoangs());
        holder.hocphi.setText(lichsulophoc.getHocphi());
    }

    public int getItemCount() {
        return mLichsulophoc.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView malophoc, tentaikhoanhv, caplop, tenmonhoc, diadiem, ngaydukien, soluonggio, ngayhoctrongtuan, giobatdau, loaitrinhdo, mota, ngaytao, trangthailop, tentaikhoangs, hocphi;
        private Button btnXemchitiet;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            malophoc = (TextView) itemView.findViewById( R.id.tv_malophoc_item);
            tentaikhoanhv = (TextView) itemView.findViewById(R.id.tv_tentaikhoanhv_item);
            caplop = (TextView) itemView.findViewById(R.id.tv_caplop_item);
            tenmonhoc = (TextView) itemView.findViewById(R.id.tv_tenmonhoc_item);
            diadiem = (TextView) itemView.findViewById(R.id.tv_diadiem_item);
            ngaydukien = (TextView) itemView.findViewById(R.id.tv_ngaydukien_item);
            soluonggio = (TextView) itemView.findViewById(R.id.tv_soluonggio_item);
            ngayhoctrongtuan = (TextView) itemView.findViewById(R.id.tv_ngayhoctrongtuan_item);
            giobatdau = (TextView) itemView.findViewById(R.id.tv_giobatdau_item);
            loaitrinhdo = (TextView) itemView.findViewById(R.id.tv_loaitrinhdo_item);
            mota = (TextView) itemView.findViewById(R.id.tv_mota_item);
            ngaytao = (TextView) itemView.findViewById(R.id.tv_ngaytao_item);
            trangthailop = (TextView) itemView.findViewById(R.id.tv_trangthailop_item);
            tentaikhoangs = (TextView) itemView.findViewById(R.id.tv_tentaikhoangs_item);
            hocphi = (TextView) itemView.findViewById(R.id.tv_hocphi_item);
            btnXemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);
            PushDownAnim.setPushDownAnimTo(btnXemchitiet).setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(view, getLayoutPosition());
                }
            } );
            PushDownAnim.setPushDownAnimTo(btnXemchitiet).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onLongClick(view, getLayoutPosition());
                    return true;
                }
            } );


        }
    }
}
