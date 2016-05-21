package com.kevin.android.weatherwatch.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

public class MyService2 extends WearableListenerService {


    String LOG_TAG = "MyService";
    public MyService2() {
        Log.v(LOG_TAG, "constructor");
    }

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        Log.v(LOG_TAG, "onDataChanged()");
        for (DataEvent dataEvent : dataEvents) {
            DataMap dataMap = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap();
            String path = dataEvent.getDataItem().getUri().getPath();
            if (path.equals("/mypath")) {
                Log.v(LOG_TAG, "watch timestamp " + dataMap.getDouble("time_stamp"));
            }

        }
    }
}
