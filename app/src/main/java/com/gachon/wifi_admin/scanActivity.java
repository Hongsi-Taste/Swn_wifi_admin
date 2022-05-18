package com.gachon.wifi_admin;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class scanActivity extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.scan_activity,container,false);

        Button req_btn = rootView.findViewById(R.id.req_wifiinfo);
        Button send_btn = rootView.findViewById(R.id.send);


        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(0);
            }
        });
        req_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                boolean success = activity.wifiManager.startScan();
                if(!success){
                    activity.scanFailure();
                    Log.e("wifi","scanFailed");
                }
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}