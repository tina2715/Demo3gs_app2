package com.udgs123.demo3gs.ui.lichsulophoc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo3gs.R;

import java.util.ArrayList;
import java.util.List;

public class LichsulophocFragment extends Fragment {


    View v;
    private RecyclerView myrecyclerview;
    private List<Lichsulophoc> lstLichsulophoc;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_lichsulophoc,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.lichsulophoc_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstLichsulophoc);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstLichsulophoc=new ArrayList<>();
        lstLichsulophoc.add(new Lichsulophoc("Lớp 1","Đã dạy", "Tiếng Việt", "Quang Trung - Gò Vấp", "1.600.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
        lstLichsulophoc.add(new Lichsulophoc("Lớp 2","Đã dạy", "Tiếng Việt", "Lê Văn Sỹ - Tân Bình", "1.700.000","Giảng viên", "Thứ 3,5,7; Từ 19h-21h"));
        lstLichsulophoc.add(new Lichsulophoc("Lớp 3","Đã dạy", "Thanh nhạc", "Lê Đại Hành - Quận 11", "2.000.000","Đã tốt nghiệp", "Thứ 2,4,6; Từ 17h-19h"));
        lstLichsulophoc.add(new Lichsulophoc("Lớp 4","Đã dạy", "Môn Toán", "Đoàn Văn Bơ - Quận 4", "1.300.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
        lstLichsulophoc.add(new Lichsulophoc("Lớp 5","Đã dạy", "Tiếng Việt", "Trần Hưng Đạo - Quận 1", "1.800.000","Giảng viên", "Thứ 3,5,7; Từ 19h-21h"));
        lstLichsulophoc.add(new Lichsulophoc("Lớp 6","Đã dạy", "Ngữ văn", "Nguyễn Chí Thanh - Quận 5", "1.400.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
    }
}