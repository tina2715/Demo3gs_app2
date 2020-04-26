package com.udgs123.demo3gs.ui.lopcangiasu;


import android.app.Dialog;
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
        public List<Lopcangiasu> lstLopcangiasu;
        public RecyclerViewAdapter(List<Lopcangiasu> lstLopcangiasu) {this.lstLopcangiasu = lstLopcangiasu;}
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lopcangiasu,parent,false);
            final MyViewHolder vHolder = new MyViewHolder(view);
            final Dialog dialogss=new Dialog(parent.getContext());
            dialogss.setContentView(R.layout.dialog_lopcangiasu);
            dialogss.getWindow();
            vHolder.btnXemchitiet.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView malophoc_dialog = (TextView) dialogss.findViewById(R.id.tv_malop_dialog);
                    TextView tentaikhoanhv_dialog = (TextView) dialogss.findViewById(R.id.tv_tentaikhoanhv_dialog);
                    TextView caplop_dialog = (TextView) dialogss.findViewById(R.id.tv_caplop_dialog);
                    TextView tenmonhoc_dialog = (TextView) dialogss.findViewById(R.id.tv_tenmonhoc_dialog);
                    TextView diadiemhoc_dialog = (TextView) dialogss.findViewById(R.id.tv_diadiemhoc_dialog);
                    TextView ngaydukien_dialog = (TextView) dialogss.findViewById(R.id.tv_ngaydukien_dialog);
                    TextView soluonggio_dialog = (TextView) dialogss.findViewById(R.id.tv_soluonggio_dialog);
                    TextView ngayhoctrongtuan_dialog = (TextView) dialogss.findViewById(R.id.tv_ngayhoctrongtuan_dialog);
                    TextView giobatdauhoc_dialog = (TextView) dialogss.findViewById(R.id.tv_giobatdau_dialog);
                    TextView loaitrinhdo_dialog = (TextView) dialogss.findViewById(R.id.tv_loaitrinhdo_dialog);
                    TextView mota_dialog = (TextView) dialogss.findViewById(R.id.tv_mota_dialog);
                    TextView ngaytao_dialog = (TextView) dialogss.findViewById(R.id.tv_ngaytao_dialog);
                    TextView hocphi_dialog = (TextView) dialogss.findViewById(R.id.tv_hocphi_dialog);


                    malophoc_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getMalophoc());
                    tentaikhoanhv_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getTentaikhoanhv());
                    caplop_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getCaplop());
                    tenmonhoc_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getTenmonhoc());
                    diadiemhoc_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getDiadiem());
                    ngaydukien_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getNgaydukien());
                    soluonggio_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getSoluonggio());
                    ngayhoctrongtuan_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getNgayhoctrongtuan());
                    giobatdauhoc_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getGiobatdau());
                    loaitrinhdo_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getLoaitrinhdo());
                    mota_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getMota());
                    ngaytao_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getNgaytao());
                    hocphi_dialog.setText(lstLopcangiasu.get(vHolder.getAdapterPosition()).getHocphi());
                    dialogss.show();
                }
            } );


            return vHolder;


        }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.malophoc.setText(lstLopcangiasu.get(position).getMalophoc());
            holder.tentaikhoanhv.setText(lstLopcangiasu.get(position).getTentaikhoanhv());
            holder.caplop.setText(lstLopcangiasu.get(position).getCaplop());
            holder.tenmonhoc.setText(lstLopcangiasu.get(position).getTenmonhoc());
            holder.diadiem.setText(lstLopcangiasu.get(position).getDiadiem());
            holder.ngaydukien.setText(lstLopcangiasu.get(position).getNgaydukien());
            holder.soluonggio.setText(lstLopcangiasu.get(position).getSoluonggio());
            holder.ngayhoctrongtuan.setText(lstLopcangiasu.get(position).getNgayhoctrongtuan());
            holder.giobatdau.setText(lstLopcangiasu.get(position).getGiobatdau());
            holder.loaitrinhdo.setText(lstLopcangiasu.get(position).getLoaitrinhdo());
            holder.mota.setText(lstLopcangiasu.get(position).getMota());
            holder.ngaytao.setText(lstLopcangiasu.get(position).getNgaytao());
            holder.trangthailop.setText(lstLopcangiasu.get(position).getTrangthailop());
            holder.tentaikhoangs.setText(lstLopcangiasu.get(position).getTentaikhoangs());
            holder.hocphi.setText(lstLopcangiasu.get(position).getHocphi());
    }

    @Override
    public int getItemCount() {
        return this.lstLopcangiasu.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
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
            }
        }

}
