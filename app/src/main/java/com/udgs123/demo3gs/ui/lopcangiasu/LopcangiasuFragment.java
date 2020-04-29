package com.udgs123.demo3gs.ui.lopcangiasu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo3gs.Chitiet_lopcangiasu;
import com.udgs123.demo3gs.ConnectionHelper;
import com.udgs123.demo3gs.LoadingDialog;
import com.udgs123.demo3gs.OnItemClickListener;
import com.udgs123.demo3gs.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LopcangiasuFragment extends Fragment {
Connection connect;
RecyclerView recyclerView;
ArrayList<Lopcangiasu> lopcangiasus;
RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<String> malophoc = new ArrayList<>();
    ArrayList<String> tentaikhoanhv = new ArrayList<>();
    ArrayList<String> caplop = new ArrayList<>();
    ArrayList<String> tenmonhoc = new ArrayList<>();
    ArrayList<String> diadiem = new ArrayList<>();
    ArrayList<String> ngaydukien = new ArrayList<>();
    ArrayList<String> soluonggio = new ArrayList<>();
    ArrayList<String> ngayhoctrongtuan = new ArrayList<>();
    ArrayList<String> giobatdau = new ArrayList<>();
    ArrayList<String> loaitrinhdo = new ArrayList<>();
    ArrayList<String> mota = new ArrayList<>();
    ArrayList<String> ngaytao = new ArrayList<>();
    ArrayList<String> trangthailop = new ArrayList<>();
    ArrayList<String> tentaikhoangs = new ArrayList<>();
    ArrayList<String> hocphi = new ArrayList<>();
    String[] malophocArr, tentaikhoanhvArr, caplopArr, tenmonhocArr,diadiemArr,ngaydukienArr,soluonggioArr,
            ngayhoctrongtuanArr,giobatdauArr,loaitrinhdoArr,motaArr,ngaytaoArr,trangthailopArr, tentaikhoangsArr, hocphiArr;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lopcangiasu, container, false);
        recyclerView = v.findViewById( R.id.lopcangiasu_recyclerview );
        lopcangiasus = new ArrayList<>();
        malophoc.clear();
        tentaikhoanhv.clear();
        caplop.clear();
        tenmonhoc.clear();
        diadiem.clear();
        ngaydukien.clear();
        soluonggio.clear();
        ngayhoctrongtuan.clear();
        giobatdau.clear();
        loaitrinhdo.clear();
        mota.clear();
        ngaytao.clear();
        trangthailop.clear();
        tentaikhoangs.clear();
        hocphi.clear();

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connections();
            if (connect==null){
                Toast.makeText(getActivity(),"Lỗi kết nối",Toast.LENGTH_LONG).show();
            } else {
                String query = "SELECT * FROM Quanlylop WHERE Trangthailop=0";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    malophoc.add(rs.getString("Malophoc"));
                    tentaikhoanhv.add(rs.getString("Tentaikhoanhv"));
                    caplop.add(rs.getString("Caplop"));
                    tenmonhoc.add(rs.getString("Tenmonhoc"));
                    diadiem.add(rs.getString("Diadiem"));
                    ngaydukien.add(rs.getString("Ngaydukien"));
                    soluonggio.add(rs.getString("Soluonggio"));
                    ngayhoctrongtuan.add(rs.getString("Ngayhoctrongtuan"));
                    giobatdau.add(rs.getString("Giobatdau"));
                    loaitrinhdo.add(rs.getString("Loaitrinhdo"));
                    mota.add(rs.getString("Mota"));
                    ngaytao.add(rs.getString("Ngaytao"));
                    trangthailop.add(rs.getString("Trangthailop"));
                    tentaikhoangs.add(rs.getString("Tentaikhoangs"));
                    hocphi.add(rs.getString("Hocphi"));
                }
                malophocArr = new String[malophoc.size()];
                malophocArr = malophoc.toArray(malophocArr);
                tentaikhoanhvArr = new String[tentaikhoanhv.size()];
                tentaikhoanhvArr = tentaikhoanhv.toArray(tentaikhoanhvArr);
                caplopArr = new String[caplop.size()];
                caplopArr = caplop.toArray(caplopArr);
                tenmonhocArr = new String[tenmonhoc.size()];
                tenmonhocArr = tenmonhoc.toArray(tenmonhocArr);
                diadiemArr = new String[diadiem.size()];
                diadiemArr = diadiem.toArray(diadiemArr);
                ngaydukienArr = new String[ngaydukien.size()];
                ngaydukienArr = ngaydukien.toArray(ngaydukienArr);
                soluonggioArr = new String[soluonggio.size()];
                soluonggioArr = soluonggio.toArray(soluonggioArr);
                ngayhoctrongtuanArr = new String[ngayhoctrongtuan.size()];
                ngayhoctrongtuanArr = ngayhoctrongtuan.toArray(ngayhoctrongtuanArr);
                giobatdauArr = new String[giobatdau.size()];
                giobatdauArr = giobatdau.toArray(giobatdauArr);
                loaitrinhdoArr = new String[loaitrinhdo.size()];
                loaitrinhdoArr = loaitrinhdo.toArray(loaitrinhdoArr);
                motaArr = new String[mota.size()];
                motaArr = mota.toArray(motaArr);
                ngaytaoArr = new String[ngaytao.size()];
                ngaytaoArr = ngaytao.toArray(ngaytaoArr);
                trangthailopArr = new String[trangthailop.size()];
                trangthailopArr = trangthailop.toArray(trangthailopArr);
                tentaikhoangsArr = new String[tentaikhoangs.size()];
                tentaikhoangsArr = tentaikhoangs.toArray(tentaikhoangsArr);
                hocphiArr = new String[hocphi.size()];
                hocphiArr = hocphi.toArray(hocphiArr);
                for (int i = 0; i < caplop.size(); i++) {
                    lopcangiasus.add(new Lopcangiasu(malophocArr[i],tentaikhoanhvArr[i],caplopArr[i],tenmonhocArr[i],diadiemArr[i],ngaydukienArr[i],soluonggioArr[i],ngayhoctrongtuanArr[i],giobatdauArr[i],loaitrinhdoArr[i],motaArr[i],ngaytaoArr[i],trangthailopArr[i],tentaikhoangsArr[i],hocphiArr[i]));
                }
                connect.close();
            }
        } catch (Exception e){
            Log.d("BBB", e.getMessage());
        }
        recyclerViewAdapter = new RecyclerViewAdapter(lopcangiasus);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        if (recyclerView.getAdapter()!=null){
            ((RecyclerViewAdapter) recyclerView.getAdapter()).setOnItemClickListener( new OnItemClickListener() {
                @Override
                public void onClick(View v, @NonNull int position) {
                    LoadingDialog loadingDialog = new LoadingDialog();
                    loadingDialog.loading(getActivity());
                    Intent detail = new Intent(getActivity(), Chitiet_lopcangiasu.class );
                    detail.putExtra("malophoc", malophocArr[position]);
                    startActivity(detail);
                }

                @Override
                public void onLongClick(View v, @NonNull int position) {

                }
            } );
        }

        return v;
    }


}