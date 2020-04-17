package com.udgs123.demo3gs.ui.lopcangiasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo3gs.R;

import java.util.ArrayList;
import java.util.List;

public class LopcangiasuFragment extends Fragment {
    private RecyclerView myrecyclerview;
    private List<Lopcangiasu> lopcangiasuList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lopcangiasu, container, false);

        myrecyclerview = (RecyclerView) v.findViewById( R.id.lopcangiasu_recyclerview );
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter( lopcangiasuList );
        myrecyclerview.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        myrecyclerview.setAdapter( recyclerViewAdapter );
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lopcangiasuList=new ArrayList<>();
        lopcangiasuList.add(new Lopcangiasu("Lớp 1","1/1/2018","Bé học yếu, cần hỗ trợ tập đọc", "Tiếng Việt", "Quang Trung - Gò Vấp", "1.600.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 2","1/1/2018","Luyện chữ", "Tiếng Việt", "Lê Văn Sỹ - Tân Bình", "1.700.000","Giảng viên", "Thứ 3,5,7; Từ 19h-21h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 3","1/1/2018","Luyện giọng khỏe hơn", "Thanh nhạc", "Lê Đại Hành - Quận 11", "2.000.000","Đã tốt nghiệp", "Thứ 2,4,6; Từ 17h-19h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 4","1/1/2018", "Cần hỗ trợ môn Toán","Môn Toán", "Đoàn Văn Bơ - Quận 4", "1.300.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 5","1/1/2018","Luyện chính tả", "Tiếng Việt", "Trần Hưng Đạo - Quận 1", "1.800.000","Giảng viên", "Thứ 3,5,7; Từ 19h-21h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 6","1/1/2018","Luyện văn", "Ngữ văn", "Nguyễn Chí Thanh - Quận 5", "1.400.000","Sinh viên", "Thứ 2,4,6; Từ 17h-19h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 7","1/1/2018","Hỗ trợ anh văn", "Tiếng Anh", "Võ Thị Sáu - Quận 3", "1.200.000","Sinh viên", "Thứ 3,5,7; Từ 7h-9h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 8","1/1/2018","Cần học anh văn giao tiếp", "Anh văn giao tiếp", "Nguyễn Khoái - Quận 4", "1.900.000","Giảng viên", "Thứ 2,4,6; Từ 13h-15h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 9","1/1/2018","Luyện thi vào lớp 10", "Luyện thi lớp 10", "Lê Quang Đinh - Bình Thạnh", "1.000.000","Sinh viên", "Thứ 3,5,7; Từ 19h-21h"));
        lopcangiasuList.add(new Lopcangiasu("Lớp 10","1/1/2018","Luyện anh văn Toeic", "Anh văn Toeic", "Phan Đăng Lưu - Phú Nhuận", "1.500.000","Đã tốt nghiệp", "Thứ 2,4,6; Từ 17h-19h"));

    }

}