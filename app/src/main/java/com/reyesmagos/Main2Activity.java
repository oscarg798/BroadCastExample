package com.reyesmagos;

import android.content.Intent;
import android.content.IntentFilter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        findViewById(R.id.tvX).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Main2Activity.this,ActivityToClose.class));
                close();
            }
        },5000);
    }

    private void close(){
        findViewById(R.id.tvX).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setAction("MyReceiver");
                sendBroadcast(intent);
            }
        },5000);
    }
}
