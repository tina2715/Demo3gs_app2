package com.udgs123.demo3gs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class dangnhap extends AppCompatActivity {
    private Button buttonthoat;
    TextView textView;
    Connection connect;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private EditText mTentaikhoan, mMatkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        mTentaikhoan = (EditText) findViewById( R.id.edt_tentaikhoan );
        mMatkhau = (EditText) findViewById( R.id.edt_matkhau );

        mPreferences = PreferenceManager.getDefaultSharedPreferences( this );
        mEditor = mPreferences.edit();

        checkSharedPreferences();

        final TextView tv_dangky = (TextView) findViewById( R.id.tv_dangky );
        tv_dangky.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dangkyIntent = new Intent( dangnhap.this, dangky_giasu.class );
                startActivity( dangkyIntent );
            }
        } );


        final Button buttondangnhap1 = (Button) findViewById(R.id.buttondangnhap);
        buttondangnhap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tentaikhoan = mTentaikhoan.getText().toString();
                mEditor.putString( "Tentaikhoangs",tentaikhoan );
                String matkhau = mMatkhau.getText().toString();
                mEditor.putString( "Matkhaugs", matkhau );

                if (tentaikhoan.equals( "" )||matkhau.equals( "" )) {
                    Toast.makeText( getApplicationContext(),"Hãy nhập tên tài khoản và mật khẩu", Toast.LENGTH_SHORT ).show();
                }
                else {
                    try {
                        ConnectionHelper connectionHelper= new ConnectionHelper();
                        connect=connectionHelper.connections();
                        if (connect==null) {
                            Toast.makeText(getApplicationContext(),"Lỗi kết nối",Toast.LENGTH_SHORT).show();
                        } else {
                            //progressBar.setVisibility(View.VISIBLE);
                            String query ="select * from thongtingiasu where Tentaikhoangs = '" + tentaikhoan + "' and Matkhaugs = '"+ matkhau +"' ";
                            Statement stmt = connect.createStatement();
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next()) {
                                mEditor.commit();
                                Intent intent = new Intent(dangnhap.this, ManHinhDauTien.class);
                                startActivity( intent );
                            } else {
                                Toast.makeText(getApplicationContext(),"Nhập thiếu trường", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (Exception e) {
                        Toast.makeText( getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT ).show();
                    }

                }


            }
        });
    }
    public void checkSharedPreferences() {
        String tentaikhoan = mPreferences.getString( "Tentaikhoangs","" );
        String matkhau = mPreferences.getString( "Matkhaugs","" );

        mTentaikhoan.setText(tentaikhoan);
        mMatkhau.setText(matkhau);
    }
}
