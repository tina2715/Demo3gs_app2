package com.udgs123.demo3gs.ui.lopcangiasu;


import android.app.Dialog;
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

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
        public ArrayList<Lopcangiasu> mLopcangiasu;
        private OnItemClickListener mOnItemClickListener;
        public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
            this.mOnItemClickListener = mOnItemClickListener;
        }
        public RecyclerViewAdapter(ArrayList<Lopcangiasu> mLopcangiasu) {this.mLopcangiasu = mLopcangiasu;}
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lopcangiasu,parent,false);
            final MyViewHolder vHolder = new MyViewHolder(view);
            return vHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Lopcangiasu lopcangiasu = mLopcangiasu.get(position);

            holder.malophoc.setText(lopcangiasu.getMalophoc());
            holder.tentaikhoanhv.setText(lopcangiasu.getTentaikhoanhv());
            holder.caplop.setText(lopcangiasu.getCaplop());
            holder.tenmonhoc.setText(lopcangiasu.getTenmonhoc());
            holder.diadiem.setText(lopcangiasu.getDiadiem());
            holder.ngaydukien.setText(lopcangiasu.getNgaydukien());
            holder.soluonggio.setText(lopcangiasu.getSoluonggio());
            holder.ngayhoctrongtuan.setText(lopcangiasu.getNgayhoctrongtuan());
            holder.giobatdau.setText(lopcangiasu.getGiobatdau());
            holder.loaitrinhdo.setText(lopcangiasu.getLoaitrinhdo());
            holder.mota.setText(lopcangiasu.getMota());
            holder.ngaytao.setText(lopcangiasu.getNgaytao());
            holder.trangthailop.setText(lopcangiasu.getTrangthailop());
            holder.tentaikhoangs.setText(lopcangiasu.getTentaikhoangs());
            holder.hocphi.setText(lopcangiasu.getHocphi());
    }

    @Override
    public int getItemCount() {
        return this.mLopcangiasu.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView malophoc, tentaikhoanhv, caplop, tenmonhoc, diadiem, ngaydukien, soluonggio, ngayhoctrongtuan, giobatdau, loaitrinhdo, mota, ngaytao, trangthailop, tentaikhoangs, hocphi;
            private Button btnXemchitiet;

            public MyViewHolder(View itemView){
                super(itemView);
                malophoc = (TextView) itemView.findViewById(R.id.tv_malop_item);
                tentaikhoanhv = (TextView) itemView.findViewById(R.id.tv_tentaikhoanhv_item);
                caplop = (TextView) itemView.findViewById(R.id.tv_caplop_item);
                tenmonhoc = (TextView) itemView.findViewById(R.id.tv_tenmonhoc_item);
                diadiem = (TextView) itemView.findViewById(R.id.tv_diadiemhoc_item);
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
                PushDownAnim.setPushDownAnimTo(btnXemchitiet).setOnLongClickListener( new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        mOnItemClickListener.onLongClick(view, getLayoutPosition());
                        return true;
                    }
                } );

            }
        }

}
