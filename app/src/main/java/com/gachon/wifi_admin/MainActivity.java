package com.gachon.wifi_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    scanActivity mainFrag;
    sendActivity sendFrag;
    WifiManager wifiManager;
    TextView test_tv;

    public void scanSuccess() {
        List<ScanResult> results = wifiManager.getScanResults();
        String row_res = results.toString();
        String[] filter_res = row_res.split("] ");
        String final_res="";
        for(int i=0;i<filter_res.length;i++){
            filter_res[i]+="\n";
            final_res += filter_res[i];
        }
        Log.e("wifi-info",results.toString());
        test_tv.setText(final_res);
    };
    public void scanFailure() {
        ///handle failure
        ///consider using old result
        List<ScanResult> results = wifiManager.getScanResults();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test_tv = findViewById(R.id.res_v1);
        mainFrag = (scanActivity) getSupportFragmentManager().findFragmentById(R.id.scan_activity);
        sendFrag = new sendActivity();

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            Log.d("permission","checkSelfPermission");
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {

                Log.d("permission","shouldShowRequestPermissionRationale");
                // 사용자에게 설명을 보여줍니다.
                // 권한 요청을 다시 시도합니다.

            } else {
                // 권한요청

                Log.d("permission","권한 요청");
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.CHANGE_WIFI_STATE},
                        1000);

            }
        }
        wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context c, Intent intent) {
                boolean success = intent.getBooleanExtra(
                        WifiManager.EXTRA_RESULTS_UPDATED, false);
                if (success) {
                    scanSuccess();
                    Log.e("wifi","scanSucceed");
                } else {
                    // scan failure handling
                    scanFailure();
                    Log.e("wifi","scanFailed");
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(wifiScanReceiver, intentFilter);

    }
    //권한요청을 사용자에게 허락받았는지 못받았는지 결과를 알수 있는 콜백 메서드
    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1000: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // 권한 획득 성공
                    Log.d("permission","권한 획득 성공");

                } else {

                    // 권한 획득 실패
                    Log.d("permission","권한 획득 실패");
                }
                return;
            }

        }
    }
    public void onFragmentChanged(int index) {
        if(index==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,sendFrag).commit();
        } else if(index==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFrag).commit();
        }
    }
}