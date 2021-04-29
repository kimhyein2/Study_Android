package com.example.my14_smsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmsDisActivity extends AppCompatActivity {

    Button btnSender;
    TextView tvContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_dis);

        tvContents = findViewById(R.id.tvContents);
        btnSender = findViewById(R.id.btnSender);

        findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent disIntent = getIntent();
        processIntent(disIntent);


    }

    private void processIntent(Intent disIntent) {
        String sender = disIntent.getStringExtra("sender"); //보낸이름과 받는이름이 같아야함
        String receivedDate = disIntent.getStringExtra("receivedDate"); //보낸이름과 받는이름이 같아야함
        String contents = disIntent.getStringExtra("contents"); //보낸이름과 받는이름이 같아야함

        if(sender != null){
            btnSender.setText(sender + " 에서 문자 수신");
            tvContents.setText("[" + receivedDate + "]\n" + contents);
        }
    }

    // 기존 화면이 사용하고자 할 떄 onCreate() 를 사용하지 못하니
    // onNewIntent() 메소드를 사용하여 새로운 intent를 받아
    // 화면에 데이터를 갱신한다.
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        processIntent(intent);

    }
}