package com.udgs123.demo3gs.ui.lopcangiasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo3gs.ConnectionHelper;
import com.udgs123.demo3gs.R;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LopcangiasuFragment extends Fragment {
Connection connect;
private RecyclerView myrecyclerview;
private List<Lopcangiasu> lstLopcangs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lopcangiasu, container, false);
        myrecyclerview = v.findViewById(R.id.lopcangiasu_recyclerview);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mLopcangiasu());
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }

public List<Lopcangiasu>mLopcangiasu(){
        List<Lopcangiasu> lopcangiasus = new ArrayList<>();
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connections();
            if (connect==null){
                Toast.makeText(getActivity(),"Loi",Toast.LENGTH_SHORT).show();
            } else {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select * from Quanlylop");
                while (rs.next()){
                lopcangiasus.add(new Lopcangiasu( rs.getString("Malophoc"),
                        rs.getString("Tentaikhoanhv"),
                        rs.getString("Caplop"),
                        rs.getString("Tenmonhoc"),
                        rs.getString("Diadiem"),
                        rs.getString("Ngaydukien"),
                        rs.getString("Soluonggio"),
                        rs.getString("Ngayhoctrongtuan"),
                        rs.getString("Giobatdau"),
                        rs.getString("Loaitrinhdo"),
                        rs.getString("Mota"),
                        rs.getString("Ngaytao"),
                        rs.getString("Trangthailop"),
                        rs.getString("Tentaikhoangs"),
                        rs.getString("Hocphi")
                        ));
                }
            }
        } catch (SQLException e) {
            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return lopcangiasus;
    }
}