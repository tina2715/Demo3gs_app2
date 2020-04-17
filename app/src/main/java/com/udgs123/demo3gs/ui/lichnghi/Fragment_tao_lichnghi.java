package com.udgs123.demo3gs.ui.lichnghi;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Calendar;
import com.udgs123.demo3gs.R;

public class Fragment_tao_lichnghi extends Fragment {
    View v;
    DateFormat fmt_ngaynghi = DateFormat.getDateInstance();
    DateFormat fmt_ngaybu = DateFormat.getDateInstance();
    TextView lbl_ngaynghi;
    TextView lbl_ngaybu;


    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
    Calendar myCalendar_nb = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener d_nb = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year_nb, int monthOfYear_nb, int dayOfMonth_nb) {
            myCalendar_nb.set(Calendar.YEAR, year_nb);
            myCalendar_nb.set(Calendar.MONTH, monthOfYear_nb);
            myCalendar_nb.set(Calendar.DAY_OF_MONTH,dayOfMonth_nb);
            updateLabel_nb();
        }
    };

    public Fragment_tao_lichnghi() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tao_lichnghi, container,false);

        lbl_ngaynghi = (TextView) v.findViewById(R.id.lbl_ngaynghi);
        Button btn_ngaynghi = (Button) v.findViewById(R.id.btn_ngaynghi);
        btn_ngaynghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar myCalendar = Calendar.getInstance();
                new DatePickerDialog(getActivity(), d,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        updateLabel();

        lbl_ngaybu = (TextView) v.findViewById(R.id.lbl_ngaybu);
        Button btn_ngaybu = (Button) v.findViewById(R.id.btn_ngaybu);
        btn_ngaybu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar myCalendar_nb = Calendar.getInstance();
                new DatePickerDialog(getActivity(),d_nb,
                        myCalendar_nb.get(Calendar.YEAR),
                        myCalendar_nb.get(Calendar.MONTH),
                        myCalendar_nb.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        updateLabel_nb();
        return v;
    }
    private void updateLabel() {
        lbl_ngaynghi.setText(fmt_ngaynghi.format(myCalendar.getTime()));
    }
    private void updateLabel_nb () {
        lbl_ngaybu.setText(fmt_ngaybu.format(myCalendar_nb.getTime()));
    }
}
