package com.udgs123.demo3gs;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class dangky_giasu extends AppCompatActivity {
    Connection connect;
    private Button buttondongy1;
    private Button buttonhuy1;
    private EditText edt_tentaikhoangs, edt_matkhaugs, edt_hotengs, edt_emailgs, edt_sdtgs, edt_diachigs, edt_truongtheohocgs, edt_chuyennganhgs;
    private TextView tv_ngsinh;
    Calendar mBirthday;
    int day, month, year;

    private Spinner spinDaymon, spinTrinhdo;
    ArrayList<String> monhocID = new ArrayList<>();
    String MonhocID;
    ArrayList<String> trinhdoID = new ArrayList<>();
    String TrinhdoID;


    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_dangky_giasu);

        // Ánh xạ
        edt_tentaikhoangs = (EditText) findViewById( R.id.edt_tentaikhoangs );
        edt_matkhaugs = (EditText) findViewById( R.id.edt_matkhaugs );
        edt_hotengs = (EditText) findViewById( R.id.edt_hotengs );
        tv_ngsinh = (TextView) findViewById( R.id.tv_ngsinh );
        edt_emailgs = (EditText) findViewById( R.id.edt_emailgs );
        edt_sdtgs = (EditText) findViewById( R.id.edt_sodienthoaigs );
        edt_diachigs = (EditText) findViewById( R.id.edt_diachigs );
        edt_truongtheohocgs = (EditText) findViewById( R.id.edt_truongtheohocgs );
        edt_chuyennganhgs = (EditText) findViewById( R.id.edt_chuyennganhgs );
        spinDaymon = (Spinner) findViewById(R.id.spin_daymon );
        spinTrinhdo = (Spinner) findViewById(R.id.spin_trinhdo);

        SelectedMonhocItem();
        SelectedTrinhdoItem();

        mBirthday = Calendar.getInstance();
        day = mBirthday.get(Calendar.DAY_OF_MONTH);
        month = mBirthday.get(Calendar.MONTH);
        year = mBirthday.get(Calendar.YEAR);
        month = month+1;
        tv_ngsinh.setText(day + "/" + month + "/" + year);
        tv_ngsinh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog= new DatePickerDialog( dangky_giasu.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear +1;
                        tv_ngsinh.setText( dayOfMonth+"/"+monthOfYear+"/"+year );
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        } );


        buttondongy1 = (Button) findViewById(R.id.buttondongy);
        buttondongy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Upload();
            }
        });
        buttonhuy1 = (Button) findViewById(R.id.buttonhuy);
        buttonhuy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangky_giasu.this, ManHinhDauTien.class);
                startActivity(intent);
            }
        });
    }
    public void SelectedMonhocItem() {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connections();
        if (connect==null) {
            Toast.makeText(getApplicationContext(),"Lỗi", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery( "Select * from Daymon" );
                rs.next();
                do {
                    monhocID.add(rs.getString(1));
                    //tenmon.add(rs.getString(2));
                } while (rs.next());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,monhocID);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinDaymon.setAdapter(adapter);
            spinDaymon.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MonhocID = monhocID.get(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            } );

        }
    }


    public void SelectedTrinhdoItem() {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connections();
        if (connect==null) {
            Toast.makeText(getApplicationContext(),"Lỗi", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery( "Select * from Trinhdogs" );
                rs.next();
                do {
                    trinhdoID.add(rs.getString(1));
                    //loaitrinhdo.add(rs.getString(2));
                } while (rs.next());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,trinhdoID);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinTrinhdo.setAdapter(adapter);
            spinTrinhdo.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TrinhdoID = trinhdoID.get(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            } );

        }
    }



    public void  Upload() {
        String msg = "Unknow";

        if (edt_tentaikhoangs.getText().toString().trim().equals( "" )
                || edt_matkhaugs.getText().toString().trim().equals("")
                || edt_hotengs.getText().toString().trim().equals("")
                || edt_sdtgs.getText().toString().trim().equals("")
                || edt_diachigs.getText().toString().trim().equals(""))
        {
            Toast.makeText( dangky_giasu.this, "Hãy nhập đầy đủ thông tin! ", Toast.LENGTH_SHORT ).show();
        } else {
            try {
                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connections();
                if (connect == null) {
                    Toast.makeText(getApplicationContext(), "Lỗi", Toast.LENGTH_SHORT ).show();
                } else {
                    try {
                        String edtTentaikhoan = edt_tentaikhoangs.getText().toString().trim();
                        String edtMatkhau = edt_matkhaugs.getText().toString().trim();
                        String edtHoten = edt_hotengs.getText().toString().trim();
                        String tvNgssinh = tv_ngsinh.getText().toString();
                        String edtEmail = edt_emailgs.getText().toString().trim();
                        String edtSdt = edt_sdtgs.getText().toString().trim();
                        String edtDiachi = edt_diachigs.getText().toString().trim();
                        String edtTruongtheohoc = edt_truongtheohocgs.getText().toString().trim();
                        String edtChuyennganh = edt_chuyennganhgs.getText().toString().trim();
                        String monhocID = MonhocID.toString();
                        String trinhdoID = TrinhdoID.toString();
                        String query = "INSERT INTO ttgs(Tentaikhoangs,Matkhaugs, Hotengs, Ngaysinhgs, Emailgs, Sdtgs, Diachigs, Truongtheohoc, Chuyennganh, Tenmongs, Tentrinhdo) VALUES('"
                                +edtTentaikhoan+"','"+edtMatkhau+"','"+edtHoten+"','"+tvNgssinh+"','"+edtEmail+"','"+edtSdt+"','"+edtDiachi+"','"+edtTruongtheohoc+"','"+edtChuyennganh+"','"+monhocID+"','"+trinhdoID+"')";
                        PreparedStatement pst = connect.prepareStatement(query);
                        pst.executeUpdate();
                        Toast.makeText( getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT ).show();
                        startActivity( new Intent( dangky_giasu.this, dangnhap.class ) );
                        connect.close();
                    } catch (SQLException e) {
                        Toast.makeText( getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT ).show();
                    }
                }
            } catch (Exception ex) {
                Toast.makeText( getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG ).show();
            }

        }
    }


}
