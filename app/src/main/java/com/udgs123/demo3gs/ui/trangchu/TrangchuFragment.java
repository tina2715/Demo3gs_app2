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
    TextView mHotengs, mEmailgs, mSodienthoaigs, mDiachigs, mTruongtheohocgs, mChuyennganhgs, mMondaygs, mTrinhdogs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_trangchu,container,false);

        mHotengs = (TextView) v.findViewById( R.id.tv_hotengs );
        mEmailgs = (TextView) v.findViewById( R.id.tv_emailgs );
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

                String tentaikhoan = mPreferences.getString( "tentaikhoangs","" );

                String query = "select * from taikhoan_gs where tentaikhoangs = '"+tentaikhoan+"'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    mHotengs.setText(rs.getString("hotengs"));
                    mEmailgs.setText(rs.getString("emailgs"));
                    mSodienthoaigs.setText(rs.getString("sodienthoaigs"));
                    mDiachigs.setText(rs.getString("diachigs"));
                    mTruongtheohocgs.setText(rs.getString("truongtheohocgs"));
                    mChuyennganhgs.setText(rs.getString("chuyennganhgs"));
                    mMondaygs.setText(rs.getString("mondaygs"));
                    mTrinhdogs.setText(rs.getString("trinhdogs"));
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getActivity(),ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        return v;
    }
}