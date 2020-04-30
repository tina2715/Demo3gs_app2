package com.udgs123.demo3gs;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Chitiet_ttlophoc extends AppCompatActivity {
    TextView malopHoc, tentaikhoanhv, caplop, tenmonhoc, diadiem, ngaydukien, soluonggio, ngayhoctrongtuan,
            giobatdau, loaitrinhdo, mota, ngaytao, trangthailop, tentaikhoangs, hocphi;
    Connection connect;
    String malophoc;
    int REQUEST_CODE_UPDATE = 1997;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.dialog_ttlophoc );
        malopHoc = findViewById( R.id.tv_malop_dialog );
        tentaikhoanhv = findViewById(R.id.tv_tentaikhoanhv_dialog);
        caplop = findViewById( R.id.tv_caplop_dialog );
        tenmonhoc = findViewById( R.id.tv_tenmonhoc_dialog );
        diadiem = findViewById( R.id.tv_diadiemhoc_dialog );
        ngaydukien = findViewById( R.id.tv_ngaydukien_dialog );
        soluonggio = findViewById(R.id.tv_soluonggio_dialog);
        ngayhoctrongtuan = findViewById( R.id.tv_ngayhoctrongtuan_dialog );
        giobatdau = findViewById( R.id.tv_giobatdau_dialog );
        loaitrinhdo = findViewById( R.id.tv_loaitrinhdo_dialog );
        mota = findViewById( R.id.tv_mota_dialog );
        ngaytao = findViewById( R.id.tv_ngaytao_dialog );
        trangthailop = findViewById(R.id.tv_trangthailop_dialog);
        tentaikhoangs = findViewById( R.id.tv_tentaikhoangs_dialog );
        hocphi = findViewById( R.id.tv_hocphi_dialog );

        malophoc = getIntent().getStringExtra("malophoc");
        malopHoc.setText(malophoc);


        try {
            ConnectionHelper connectHelper = new ConnectionHelper();
            connect = connectHelper.connections();
            if(connect==null){
                Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
            } else {
                String query = "SELECT * FROM Quanlylop WHERE Malophoc ='"+malophoc+"'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()){
                    if (rs.getInt( "Trangthailop" )==2){
                        trangthailop.setTextColor( Color.GREEN);
                        trangthailop.setText("Đang học");
                    }
                    tentaikhoanhv.setText(rs.getString("Tentaikhoanhv"));
                    caplop.setText(rs.getString("Caplop"));
                    tenmonhoc.setText(rs.getString("Tenmonhoc"));
                    diadiem.setText(rs.getString("Diadiem"));
                    ngaydukien.setText(rs.getString("Ngaydukien"));
                    soluonggio.setText(rs.getString("Soluonggio"));
                    ngayhoctrongtuan.setText(rs.getString("Ngayhoctrongtuan"));
                    giobatdau.setText(rs.getString("Giobatdau"));
                    loaitrinhdo.setText(rs.getString("Loaitrinhdo"));
                    mota.setText(rs.getString("Mota"));
                    ngaytao.setText(rs.getString("Ngaytao"));
                    tentaikhoangs.setText(rs.getString("Tentaikhoangs"));
                    hocphi.setText(rs.getString("Hocphi"));
                }
            }
        } catch (Exception e) {
            Log.d("BBB",e.getMessage());
        }
    }
}
