package com.udgs123.demo3gs.ui.lopchonhan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo3gs.R;

import java.util.ArrayList;
import java.util.List;

public class LopchonhanFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Lopchonhan> lstLopchonhan;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_lopchonhan,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.lopchonhan_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstLopchonhan);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstLopchonhan=new ArrayList<>();
        lstLopchonhan.add(new Lopchonhan("Lớp 1","Đang chờ duyệt", "Tiếng Việt", "Quang Trung - Gò Vấp", "1.600.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
        lstLopchonhan.add(new Lopchonhan("Lớp 2","Đang chờ duyệt", "Tiếng Việt", "Lê Văn Sỹ - Tân Bình", "1.700.000","Giảng viên", "Thứ 3,5,7; Từ 19h-21h"));
        lstLopchonhan.add(new Lopchonhan("Lớp 3","Đang chờ duyệt", "Thanh nhạc", "Lê Đại Hành - Quận 11", "2.000.000","Đã tốt nghiệp", "Thứ 2,4,6; Từ 17h-19h"));
        lstLopchonhan.add(new Lopchonhan("Lớp 4","Đang chờ duyệt", "Môn Toán", "Đoàn Văn Bơ - Quận 4", "1.300.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
        lstLopchonhan.add(new Lopchonhan("Lớp 5","Đang chờ duyệt", "Tiếng Việt", "Trần Hưng Đạo - Quận 1", "1.800.000","Giảng viên", "Thứ 3,5,7; Từ 19h-21h"));
        lstLopchonhan.add(new Lopchonhan("Lớp 6","Đang chờ duyệt", "Ngữ văn", "Nguyễn Chí Thanh - Quận 5", "1.400.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
    }
}