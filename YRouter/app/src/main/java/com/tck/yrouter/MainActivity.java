package com.tck.yrouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

@YProtocol("Neacy://app/MainActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
