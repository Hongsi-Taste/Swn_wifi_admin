package com.gachon.wifi_admin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class sendActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.send_activity,container,false);

        EditText floor_input = rootView.findViewById(R.id.fl_info);
        EditText location_input = rootView.findViewById(R.id.lo_info);

        Button to_scan = rootView.findViewById(R.id.return_main);

        to_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onFragmentChanged(1);
            }
        });

        Button send = rootView.findViewById(R.id.post_dt);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();

                int floor = Integer.parseInt(floor_input.getText().toString());
                int location = Integer.parseInt(location_input.getText().toString());

                activity.make_rssi_arr(location,floor);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}