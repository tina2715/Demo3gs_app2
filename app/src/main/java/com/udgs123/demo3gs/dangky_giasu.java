package com.udgs123.demo3gs;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
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
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;

public class dangky_giasu extends AppCompatActivity {
    private Button buttondongy1;
    private Button buttonhuy1;
//    DateFormat fmtDate = DateFormat.getDateInstance();
//    TextView lblDate;
//    Calendar myCalendar = Calendar.getInstance();
//    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            myCalendar.set(Calendar.YEAR, year);
//            myCalendar.set(Calendar.MONTH, monthOfYear);
//            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            updateLabel();
//        }
//    };
//
//    private void updateLabel () {
//        lblDate.setText(fmtDate.format(myCalendar.getTime()));
//    }
//

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_dangky_giasu);
//        lblDate = (TextView) findViewById(R.id.lblDate);
//        Button btnDate = (Button) findViewById(R.id.btnDate);
//        btnDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new DatePickerDialog(dangky_giasu.this, d,
//                        myCalendar.get(Calendar.YEAR),
//                        myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });

        //updateLabel();
//        Spinner mondaySpin = (Spinner) findViewById(R.id.spinner_monday);
//        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(dangky_giasu.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.mondaygs));
//        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mondaySpin.setAdapter(myAdapter1);
//
//
//        Spinner trinhdoSpin = (Spinner) findViewById(R.id.spinner_trinhdogs);
//        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(dangky_giasu.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.trinhdogs));
//        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        trinhdoSpin.setAdapter(myAdapter);

        buttondongy1 = (Button) findViewById(R.id.buttondongy);
        buttondongy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(dangky_giasu.this, dangnhap.class);
//                startActivity(intent);

                final EditText tentaikhoangs = (EditText) findViewById( R.id.edt_tentaikhoangs );
                final EditText matkhaugs = (EditText) findViewById( R.id.edt_matkhaugs );
                final EditText hotengs = (EditText) findViewById( R.id.edt_hotengs );
                final EditText emailgs = (EditText) findViewById( R.id.edt_emailgs );
                final EditText sodienthoaigs = (EditText) findViewById( R.id.edt_sodienthoaigs );
                final EditText diachigs = (EditText) findViewById( R.id.edt_diachigs );
                final EditText truongtheohocgs = (EditText) findViewById( R.id.edt_truongtheohocgs  );
                final EditText chuyennganhgs = (EditText) findViewById( R.id.edt_chuyennganhgs );
                final EditText daymongs  = (EditText) findViewById( R.id.edt_mondaygs );
                final EditText trinhdogs = (EditText) findViewById( R.id.edt_trinhdogs );
                if(tentaikhoangs.getText().toString().trim().equals( "" )
                        || matkhaugs.getText().toString().trim().equals( "" )
                        || hotengs.getText().toString().trim().equals( "" )
                        || emailgs.getText().toString().trim().equals( "" )
                        || sodienthoaigs.getText().toString().trim().equals( "" )
                        || diachigs.getText().toString().trim().equals( "" )
                        || truongtheohocgs.getText().toString().trim().equals( "" )
                        || chuyennganhgs.getText().toString().trim().equals( "" )
                        || daymongs.getText().toString().trim().equals( "" )
                        || trinhdogs.getText().toString().trim().equals( "" )) {
                    Toast.makeText( dangky_giasu.this, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT ).show();
                } else {

                    try {
                        ConnectionHelper connectionHelper = new ConnectionHelper();
                        Connection connect = connectionHelper.connections();
                        if( connect == null ) {
                            Toast.makeText( dangky_giasu.this, "Kiểm tra kết nối", Toast.LENGTH_SHORT ).show();
                        }
                        else {

                            try {

                                PreparedStatement pst = connect.prepareStatement( "insert into taikhoan_gs values(?,?,?,?,?,?,?,?,?,?)" );
                                pst.setString( 1, tentaikhoangs.getText().toString().trim() );
                                pst.setString( 2,matkhaugs.getText().toString().trim() );
                                pst.setString( 3,hotengs.getText().toString().trim() );
                                pst.setString( 4,emailgs.getText().toString().trim() );
                                pst.setString( 5,sodienthoaigs.getText().toString().trim() );
                                pst.setString( 6,diachigs.getText().toString().trim() );
                                pst.setString( 7,truongtheohocgs.getText().toString().trim() );
                                pst.setString( 8,chuyennganhgs.getText().toString().trim() );
                                pst.setString( 9,daymongs.getText().toString().trim() );
                                pst.setString( 10,trinhdogs.getText().toString().trim() );
                                pst.executeUpdate();
                                Toast.makeText( getApplicationContext(), "Chúc mừng bạn đã đăng ký thành công ", Toast.LENGTH_SHORT ).show();
                                startActivity( new Intent( dangky_giasu.this, dangnhap.class ) );
                                connect.close();
                            }
                            catch (SQLException e) {
                                Toast.makeText( getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT ).show();
                            }
                        }
                    } catch (Exception ex) {
                        Toast.makeText( dangky_giasu.this, ex.getMessage(), Toast.LENGTH_LONG).show();


                    }
                }
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
}
