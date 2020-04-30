package com.udgs123.demo3gs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.udgs123.demo3gs.ui.lopchonhan.Lopchonhan;
import com.udgs123.demo3gs.ui.lopchonhan.LopchonhanFragment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Chitiet_lopcangiasu extends AppCompatActivity {
    TextView malopHoc, tentaikhoanhv, caplop, tenmonhoc, diadiem, ngaydukien, soluonggio, ngayhoctrongtuan,
            giobatdau, loaitrinhdo, mota, ngaytao, trangthailop, hocphi;
    Button btnDangkynhanlop;
    Connection connect;
    String malophoc;
    int REQUEST_CODE_UPDATE = 1997;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.dialog_lopcangiasu);
        malopHoc = findViewById(R.id.tv_malop_dialog);
        tentaikhoanhv = findViewById(R.id.tv_tentaikhoanhv_dialog);
        caplop = findViewById( R.id.tv_caplop_dialog );
        tenmonhoc = findViewById( R.id.tv_tenmonhoc_dialog );
        diadiem = findViewById( R.id.tv_diadiemhoc_dialog );
        ngaydukien = findViewById( R.id.tv_ngaydukien_dialog );
        soluonggio = findViewById( R.id.tv_soluonggio_dialog );
        ngayhoctrongtuan = findViewById( R.id.tv_ngayhoctrongtuan_dialog );
        giobatdau = findViewById( R.id.tv_giobatdau_dialog );
        loaitrinhdo = findViewById( R.id.tv_loaitrinhdo_dialog );
        mota = findViewById( R.id.tv_mota_dialog );
        ngaytao = findViewById( R.id.tv_ngaytao_dialog );
        trangthailop = findViewById( R.id.tv_trangthailop_dialog );
        hocphi = findViewById(R.id.tv_hocphi_dialog);
        btnDangkynhanlop = findViewById( R.id.btn_dangkynhanlop_dialog );


        malophoc = getIntent().getStringExtra("malophoc");
        malopHoc.setText(malophoc);


        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = mPreferences.edit();

        final String tentaikhoan = mPreferences.getString( "Tentaikhoangs","" );
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connections();
            if(connect==null){
                Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
            } else {
                String query = "SELECT * FROM Quanlylop WHERE Malophoc ='"+malophoc+"'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()){
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
                    trangthailop.setText(rs.getString("Trangthailop"));
                    hocphi.setText(rs.getString("Hocphi"));
                }
            }
        } catch (Exception e) {
            Log.d("BBB",e.getMessage());
        }
        btnDangkynhanlop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ConnectionHelper connectionHelper = new ConnectionHelper();
                    connect = connectionHelper.connections();
                    if (connect==null){
                        Toast.makeText(getApplicationContext(),"Lỗi kết nối",Toast.LENGTH_LONG).show();
                    } else {
                        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        mPreferences.edit();

                        String tentaikhoan = mPreferences.getString( "Tentaikhoangs","" );
                        String query = "update Quanlylop set Tentaikhoangs='"+tentaikhoan+"', Trangthailop =1 where Malophoc = "+malophoc+"";
                        Statement st = connect.createStatement();
                        st.executeQuery(query);
                    } connect.close();
                } catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Đăng ký nhận lớp thành công",Toast.LENGTH_LONG).show();
                        Intent i = new Intent( Chitiet_lopcangiasu.this, LopchonhanFragment.class );
                        startActivity( i );
                }
            }
        } );


    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE_UPDATE && resultCode==RESULT_OK && data!=null) {
            finish();
            Intent intent = new Intent(Chitiet_lopcangiasu.this, Chitiet_lopcangiasu.class);
            intent.putExtra("malophoc", malophoc);
            startActivity(intent);
        }
        super.onActivityResult( requestCode, resultCode, data );
    }
}
