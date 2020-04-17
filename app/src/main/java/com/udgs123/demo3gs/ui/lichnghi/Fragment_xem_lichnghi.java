package com.udgs123.demo3gs.ui.lichnghi;

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

public class Fragment_xem_lichnghi extends Fragment {


    View v;
    private RecyclerView myrecycleview;
    private List<Xemlichnghi> lstXemlichnghi;
    public Fragment_xem_lichnghi() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_xem_lichnghi,container,false);
        myrecycleview =(RecyclerView) v.findViewById(R.id.lichnghi_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstXemlichnghi);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recyclerViewAdapter);
        return v;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstXemlichnghi = new ArrayList<>();
        lstXemlichnghi.add(new Xemlichnghi("A123","1/2/2018","3/2/2018","bận việc gia đình","ôn lại kiến thức","Gia sư","29/1/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B123","5/3/2018","7/3/2018","bận họp","ôn lại kiến thức","Gia sư","3/3/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B123","4/8/2018","6/8/2018","bận việc cá nhân","ôn lại kiến thức","Gia sư","3/8/2018"));
        lstXemlichnghi.add(new Xemlichnghi("A123","9/7/2018","11/7/2018","bận việc gia đình","ôn lại kiến thức","Gia sư","7/7/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B123","2/5/2018","5/5/2018","bận họp","ôn lại kiến thức","Gia sư","1/5/2018"));
        lstXemlichnghi.add(new Xemlichnghi("A123","8/4/2018","10/4/2018","bận việc cá nhân","ôn lại kiến thức","Gia sư","7/4/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B123","18/3/2018","20/3/2018","nghỉ bệnh","ôn lại kiến thức","Gia sư","17/3/2018"));
        lstXemlichnghi.add(new Xemlichnghi("A123","24/2/2018","26/2/2018","bận việc cá nhân","ôn lại kiến thức","Gia sư","23/2/2018"));
        lstXemlichnghi.add(new Xemlichnghi("B123","27/3/2018","29/3/2018","bận họp","ôn lại kiến thức","Gia sư","26/3/2018"));
        lstXemlichnghi.add(new Xemlichnghi("A123","30/4/2018","3/5/2018","nghỉ lễ","ôn lại kiến thức","Gia sư","29/3/2018"));
    }

}
