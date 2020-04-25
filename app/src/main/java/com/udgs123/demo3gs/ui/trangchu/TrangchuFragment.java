package com.udgs123.demo3gs.ui.trangchu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.demo3gs.ConnectionHelper;
import com.udgs123.demo3gs.R;
import com.udgs123.demo3gs.ui.dslophoc.Dslophoc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrangchuFragment extends Fragment {

    View v;
    Connection connect;
    TextView mHotengs, mNgaysinh, mEmailgs, mSodienthoaigs, mDiachigs, mTruongtheohocgs, mChuyennganhgs, mMondaygs, mTrinhdogs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_trangchu,container,false);

        mHotengs = (TextView) v.findViewById( R.id.tv_hotengs );
        mNgaysinh = (TextView) v.findViewById( R.id.tv_ngaysinh );
        mEmailgs = (TextView) v.findViewById( R.id.tv_emailgs);
        mSodienthoaigs = (TextView) v.findViewById( R.id.tv_sodienthoaigs );
        mDiachigs = (TextView) v.findViewById( R.id.tv_diachigs );
        mTruongtheohocgs = (TextView) v.findViewById( R.id.tv_truongtheohocgs );
        mChuyennganhgs = (TextView) v.findViewById( R.id.tv_chuyennganhgs );
        mMondaygs = (TextView) v.findViewById( R.id.tv_mondaygs );
        mTrinhdogs = (TextView) v.findViewById( R.id.tv_trinhdogs );

        try {
            ConnectionHelper connectHelper = new ConnectionHelper();
            connect = connectHelper.connections();
            if (connect==null) {
                Toast.makeText(getActivity(),"Kiểm tra kết nối", Toast.LENGTH_SHORT).show();
            }
            else {
                SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = mPreferences.edit();

                String tentaikhoan = mPreferences.getString( "Tentaikhoangs","" );

                String query = "select * from ttgs where Tentaikhoangs = '"+tentaikhoan+"'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    mHotengs.setText(rs.getString("Hotengs"));
                    mNgaysinh.setText(rs.getString("Ngaysinhgs"));
                    mEmailgs.setText(rs.getString("Emailgs"));
                    mSodienthoaigs.setText(rs.getString("Sdtgs"));
                    mDiachigs.setText(rs.getString("Diachigs"));
                    mTruongtheohocgs.setText(rs.getString("Truongtheohoc"));
                    mChuyennganhgs.setText(rs.getString("Chuyennganh"));
                    mMondaygs.setText(rs.getString("Tenmongs"));
                    mTrinhdogs.setText(rs.getString("Tentrinhdo"));
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getActivity(),ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return v;
    }
}